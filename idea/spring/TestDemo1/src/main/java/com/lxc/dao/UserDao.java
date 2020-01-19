package com.lxc.dao;

import com.lxc.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from user;")
    List<User> findAllUser();

}
