package com.lxc.dao;

import com.lxc.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    int addUser(User user);

    int updateUser(User user);

    User findUser(int id);

    int deleteUser(int id);

}
