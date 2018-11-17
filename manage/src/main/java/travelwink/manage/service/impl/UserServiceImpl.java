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
    public UserDao userDao;

    @Override
    public List<User> queryUser() {

        return userDao.queryUser();
    }
}
