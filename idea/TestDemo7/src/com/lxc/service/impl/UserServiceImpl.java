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

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean delUser(int id) {
        return userDao.delUser(id);
    }

    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }

    @Override
    public boolean updateUser(User user, int id) {
        return userDao.updateUser(user,id);
    }
}
