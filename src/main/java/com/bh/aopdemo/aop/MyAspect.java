package com.bh.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	/**
	 * 定义切入点
	 */
	@Pointcut("execution(* com.bh.aopdemo..*.*(..))")
	private void myPointCut() {
	  
	}
	
	
	/*
	 * @Before("myPointCut()") public void myBefore(JoinPoint jp) {
	 * System.out.println("Aspect日志输出： "+jp.getSignature().getName()+" 方法执行前..."); }
	 */

	/**
	 * 环绕通知
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
		System.out.println("Aspect日志输出： "+proceedingJoinPoint.getSignature().getName()+" 方法执行前...");
        Object obj=proceedingJoinPoint.proceed();
        System.out.println("Aspect日志输出： "+proceedingJoinPoint.getSignature().getName()+" 方法执行后...");
		return obj;
	}

	/**
	 * 异常通知
	 * @param jp
	 * @param ex
	 */
	@AfterThrowing(value="myPointCut()",throwing="ex")
	public void myAfterThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("异常通知：" +jp.getSignature().getName()+ "方法出错了..." + ex.getMessage());
	}

}
