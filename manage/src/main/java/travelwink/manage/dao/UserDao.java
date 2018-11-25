package travelwink.manage.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import travelwink.manage.domain.entity.User;

import java.util.List;

@Mapper
public interface UserDao {

    int createUser(User user);

    int modifyUser(User user);

    List<User> getUser(User user);

}
