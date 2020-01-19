package com.lxc.test;

import com.lxc.dao.UserDao;
import com.lxc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest1 {

    @Test
    public void Test1(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            SqlSession session = sqlSessionFactory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            List<User> users = userDao.findAll();
            for (User u:users){
                System.out.println(u.toString());
            }
            session.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
