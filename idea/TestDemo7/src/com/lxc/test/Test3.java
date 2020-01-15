package com.lxc.test;

import com.lxc.dao.UserDao;
import com.lxc.dao.impl.UserDaoImpl;
import com.lxc.domain.Search;
import com.lxc.domain.User;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        Search search = new Search();
        search.setName("");
        search.setAddress("");
        search.setEmail("12");
        List<User> searchUser = userDao.findSearchUser(0, 10, search);
        for (User user : searchUser){
            System.out.println(user.toString());
        }
        System.out.println(userDao.findSearchRowsCoun(search));
    }
}
