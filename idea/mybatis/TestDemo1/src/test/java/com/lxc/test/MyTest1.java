package com.lxc.test;

import com.lxc.dao.UserDao;
import com.lxc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest1 {

    private SqlSession session;
    private InputStream is;
    private UserDao userDao;

    @Before
    public void init() {
        try {
            is = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            session = sqlSessionFactory.openSession();
            userDao = session.getMapper(UserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destroy() {
        try {
            session.commit();
            session.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test1() {
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void Test2(){
        User user = new User();
        user.setName("测试");
        user.setGender("男");
        user.setAge(23);
        user.setAddress("上海");
        user.setQq("741852");
        user.setEmail("456@123.com");
        int i = userDao.addUser(user);
        System.out.println(i);
    }

    @Test
    public void Test3(){
        User user = userDao.findUser(56);
        user.setName("测试1");
        int i = userDao.updateUser(user);
        System.out.println(i);
    }

    @Test
    public void Test4(){
        int i = userDao.deleteUser(56);
        System.out.println(i);
    }

}
