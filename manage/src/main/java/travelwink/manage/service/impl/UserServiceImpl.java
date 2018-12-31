package travelwink.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.manage.dao.UserDao;
import travelwink.manage.domain.entity.User;
import travelwink.manage.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User signIn(User user) {
        return userDao.getUser(user).get(0);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public List<User> queryUser() {
        return userDao.findAll();
    }
}
