package travelwink.manage.dao;

import travelwink.manage.domain.entity.User;

import java.util.List;

public interface UserDao {
    List<User> queryUser();

    User queryUserById(int userId);

    int createUser(User user);

    int modifyUser(User user);


}
