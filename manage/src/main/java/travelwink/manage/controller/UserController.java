package travelwink.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import travelwink.manage.bean.RestBody;
import travelwink.manage.domain.entity.User;
import travelwink.manage.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/signIn")
    public RestBody signIn(@RequestBody User user){
        User data = userService.signIn(user);
        return new RestBody().success("登陆成功",data);
    }

    public RestBody signUp(@RequestBody User user){
        try{
            userService.createUser(user);
            return new RestBody().success("注册成功",null);
        } catch (Exception e){
            e.printStackTrace();
            return new RestBody().success("注册失败",e.getMessage());
        }
    }

    @GetMapping(value="/getUserList")
    public List<User> getUserList(@RequestBody User user){
        return userService.queryUser(user);
    }
}
