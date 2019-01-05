package travelwink.manage.service;

import travelwink.manage.domain.entity.User;

import java.util.List;

public interface UserService {

    User signIn(User user);

    int add(User user);

    List<User> findAll();
}
