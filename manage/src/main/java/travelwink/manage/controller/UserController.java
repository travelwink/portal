package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import travelwink.manage.bean.RestBody;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.domain.entity.User;
import travelwink.manage.service.DepartmentService;
import travelwink.manage.service.UserService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String initPage (Model model) {
        log.info("--------------> # 查询所有用户 #");
        List<User> userList = userService.query();
        List<Department> departments = departmentService.query();
        model.addAttribute("departments", departments);
        model.addAttribute("userList",userList);
        log.info("--------------> # 跳转用户管理页面 #");
        return "manage/user";
    }

    @PostMapping("/add")
    public RestBody add (User user) {
        log.info("--------------> # 新增用户 #");
        int result = userService.add(user);
        return RestBody.success("新增成功");
    }

    @GetMapping(value="/getUserList")
    public List<User> getUserList(@RequestBody User user){
        return null;
    }

    @PostMapping("/signIn")
    public RestBody signIn(@RequestBody User user){
        log.info("--------------> # 用户登陆 # <--------------");
        User data = userService.signIn(user);
        return RestBody.success("登陆成功",data);
    }


}
