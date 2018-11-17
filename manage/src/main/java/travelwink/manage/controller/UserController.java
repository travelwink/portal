package travelwink.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import travelwink.manage.domain.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import travelwink.manage.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/signIn")
    public User signIn(){

        return null;
    }

    @PostMapping(value="/getUserList")
    public List<User> getUserList(){
        return userService.queryUser();
    }
}
