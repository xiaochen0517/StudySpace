package com.lxc.service.impl;

import com.lxc.dao.UserDao;
import com.lxc.dao.impl.UserDaoImpl;
import com.lxc.domain.User;
import com.lxc.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public boolean userLogin(String username, String password) {
        return userDao.userLogin(username, password);
    }
}
