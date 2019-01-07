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
        return userDao.findById(user.getId()).get(0);
    }

    @Override
    public int add(User user) {
        return userDao.create(user);
    }

    @Override
    public int delete(int id){
        return userDao.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
