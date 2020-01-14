package com.lxc.service;

import com.lxc.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> findAllUser();

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    boolean userLogin(String username, String password);

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean delUser(int id);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    User findUser(int id);

    /**
     * 修改用户信息
     * @param user
     * @param id
     * @return
     */
    boolean updateUser(User user, int id);

}
