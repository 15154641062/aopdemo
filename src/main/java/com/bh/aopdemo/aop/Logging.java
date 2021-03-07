package com.bh.aopdemo.aop;

import org.aspectj.lang.JoinPoint;

public class Logging {

    /**
     * 方法执行前
     */
    public void myBefore(JoinPoint jp){
        System.out.println("Aspect日志输出： "+jp.getSignature().getName()+" 方法执行前...");
    }

    /**
     * 方法执行后
     */
    public void myAfter(JoinPoint jp){
        System.out.println("Aspect日志输出： "+jp.getSignature().getName()+" 方法执行后...");
    }

    /**
     * 方法执行返回后
     */
    public void myAfterReturning(JoinPoint jp,Object returnVal){
        System.out.println("Aspect日志输出： "+jp.getSignature().getName()+" 方法返回后...返回值："+returnVal.toString());
    }

    /**
     * 方法执行出现异常
     */
    public void myAfterThrowing(JoinPoint jp,Exception ex){
        System.out.println("异常通知：" +jp.getSignature().getName()+ "方法出错了..." + ex.getMessage());
    }
}
