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
        User user = new User();
        List<User> userList = userDao.findById(user.getId());
        assertEquals(3,userList.size());
    }

    @Test
    @Ignore
    public void queryUserByName() {
        User userDto = new User();
        userDto.setName("travelwink");
        userDto.setStatus(1);
        User user = userDao.findById(userDto.getId()).get(0);
        assertEquals("travelwink", user.getName());
    }

    @Test
    @Ignore
    public void createUser() {
        User user = new User();
        user.setName("root");
        user.setPassword("root");
        user.setNickName("root");
        user.setEmail("root@travelwink.com");
        user.setStatus(1);
        user.setCreateDate(new Date());
        user.setMobile("1234567890");
        int effectedNum = userDao.create(user);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void modifyUser() {
        User user = new User();
        user.setId(1);
        user.setMobile("17701677661");
        user.setUpdateDate(new Date());
        user.setStatus(1);
        int effectedNum = userDao.modifyUser(user);
        assertEquals(1,effectedNum);
    }
}