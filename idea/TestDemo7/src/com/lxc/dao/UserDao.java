package com.lxc.dao;

import com.lxc.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUser();

    boolean userLogin(String username, String password);

}
