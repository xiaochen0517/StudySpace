package com.lxc.service;

import com.lxc.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    boolean userLogin(String username, String password);

}
