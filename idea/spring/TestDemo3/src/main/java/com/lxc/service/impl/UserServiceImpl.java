package com.lxc.service.impl;

import com.lxc.service.UserService;

public class UserServiceImpl implements UserService {
    public void findUser() {
        System.out.println("findUser");
    }

    public void updateUser(int i) {
        System.out.println("updateUser-->"+i);
    }

    public int deleteUser() {
        System.out.println("deleteUser");
        return 0;
    }
}
