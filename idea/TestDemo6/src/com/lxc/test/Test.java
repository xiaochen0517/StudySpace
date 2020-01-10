package com.lxc.test;

import com.lxc.dao.User;

public class Test {

    public static void main(String[] args) {
        User user = new User();
        String a = user.getPassword("a");
        System.out.println(a);
    }

}
