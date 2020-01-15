package com.lxc.test;

import com.lxc.dao.UserDao;
import com.lxc.dao.impl.UserDaoImpl;
import com.lxc.domain.User;

import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        List<User> pageUser = userDao.findPageUser(0, 10);
        for (User u : pageUser){
            System.out.println(u.toString());
        }
        System.out.println(userDao.findRowsCount());
    }

}
