package com.lxc.dao;

import com.lxc.domain.Search;
import com.lxc.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUser();

    boolean userLogin(String username, String password);

    boolean addUser(User user);

    boolean delUser(int id);

    User findUser(int id);

    boolean updateUser(User user, int id);

    List<User> findPageUser(int startCount, int rowsCount);

    int findRowsCount();

    List<User> findSearchUser(int startCount, int rowsCount, Search search);

    int findSearchRowsCoun(Search search);

}
