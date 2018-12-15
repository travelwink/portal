package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travelwink.manage.bean.RestBody;
import travelwink.manage.domain.entity.User;
import travelwink.manage.service.UserService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String userPage () {
        log.info("--------------> # 跳转用户管理页面 # <--------------");
        return "user";
    }

    @GetMapping(value="/getUserList")
    public List<User> getUserList(@RequestBody User user){
        log.info("--------------> # 查询用户列表 # <--------------");
        return userService.queryUser(user);
    }

    @PostMapping(value="/signIn")
    public RestBody signIn(@RequestBody User user){
        log.info("--------------> # 用户登陆 # <--------------");
        User data = userService.signIn(user);
        return RestBody.success("登陆成功",data);
    }


}
