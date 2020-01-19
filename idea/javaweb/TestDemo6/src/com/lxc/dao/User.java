package com.lxc.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据库
 */
public class User {

    private Map<String, String> users;

    public User(){
        users = new HashMap<>();
        users.put("aaa","aaa");
        users.put("bbb", "bbb");
        users.put("admin", "admin");
    }

    public String getPassword(String username){
        return users.get(username);
    }

}
