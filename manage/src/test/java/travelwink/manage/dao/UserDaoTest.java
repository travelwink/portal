package travelwink.manage.dao;

import travelwink.manage.domain.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Ignore
    public void queryUser() {
        List<User> userList = userDao.queryUser();
        assertEquals(2,userList.size());
    }

    @Test
    public void queryUserById() {
        User user = userDao.queryUserById(1);
        assertEquals("travelwink", user.getUserName());
    }

    @Test
    @Ignore
    public void createUser() {
        User user = new User();
        user.setUserName("root");
        user.setPassword("root");
        user.setNickName("root");
        user.setEmail("root@travelwink.com");
        user.setStatus(1);
        user.setCreateDate(new Date());
        user.setMobile("1234567890");
        int effectedNum = userDao.createUser(user);
        assertEquals(1,effectedNum);
    }

    @Test
    public void modifyUser() {
        User user = new User();
        user.setUserId(1);
        user.setMobile("17701677661");
        user.setUpdateDate(new Date());
        user.setStatus(1);
        int effectedNum = userDao.modifyUser(user);
        assertEquals(1,effectedNum);
    }
}