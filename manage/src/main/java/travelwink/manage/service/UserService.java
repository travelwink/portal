package travelwink.manage.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import travelwink.manage.domain.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    int add(User user);

    int delete(int id);

    List<User> findAll();

    User loadUserByUsername(String userName);
}
