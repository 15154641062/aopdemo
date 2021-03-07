package com.bh.aopdemo.dao;

import com.bh.aopdemo.pojo.User;

import java.util.List;

public interface UserDao {
   List<User> findAllUser();
}
