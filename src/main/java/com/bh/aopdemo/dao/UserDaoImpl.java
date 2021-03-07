package com.bh.aopdemo.dao;

import com.bh.aopdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    @Override
    public List<User> findAllUser() {
        System.out.println("selecting...");
        String sql="select * from t_user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
