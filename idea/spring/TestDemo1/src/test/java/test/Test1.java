package test;

import com.lxc.dao.UserDao;
import com.lxc.domain.User;
import com.lxc.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:bean.xml" })
public class Test1 {

    @Autowired
    UserDao userDao = null;

    @Test
    public void test(){
        List<User> allUser = userDao.findAllUser();
        for (User u:allUser){
            System.out.println(u.toString());
        }
    }

}
