package com.lxc.service;

import com.lxc.domain.Search;
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

    /**
     * 获取分页user列表
     * @param startCount
     * @param rowsCount
     * @return
     */
    List<User> findPageUser(int startCount, int rowsCount);

    /**
     * 获取数据库总行数
     * @return
     */
    int findRowsCount();

    /**
     * 获取搜索list
     * @param startCount
     * @param rowsCount
     * @param search
     * @return
     */
    List<User> findSearchUser(int startCount, int rowsCount, Search search);

    /**
     * 获取搜索总列数
     * @param search
     * @return
     */
    int findSearchRowsCount(Search search);

}
