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
        return count == 1;
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into `user` values(null,?,?,?,?,?,?)";
        int update = template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());
        return update == 1;
    }

    @Override
    public boolean delUser(int id) {
        String sql = "delete from user where `id`=?";
        int update = template.update(sql, id);
        return update==1;
    }

    @Override
    public User findUser(int id) {
        String sql = "select * from user where `id`=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public boolean updateUser(User user, int id) {
        String sql = "update user set `name`=?,`gender`=?,`age`=?,`address`=?,`qq`=?,`email`=? where `id`=?";
        int update = template.update(sql, user.getName(), user.getGender(),
                user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), id);
        return update == 1;
    }
}
