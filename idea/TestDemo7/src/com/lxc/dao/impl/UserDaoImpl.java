package com.lxc.dao.impl;

import com.lxc.dao.UserDao;
import com.lxc.domain.User;
import com.lxc.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAllUser() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public boolean userLogin(String username, String password) {
        String sql = "select count(*) from admin where `username`=? and `password`=?";
        int count = template.queryForObject(sql,Integer.class, username, password);
        System.out.println("数据库查询结果"+count);
        if (count == 1){
            return true;
        }
        return false;
    }
}
