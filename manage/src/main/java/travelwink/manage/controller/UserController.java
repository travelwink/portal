package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import travelwink.manage.bean.RestBody;
import travelwink.manage.common.Constant;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.domain.entity.User;
import travelwink.manage.service.DepartmentService;
import travelwink.manage.service.UserService;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("departments")
    public List<Department> populateDepartments() {
        log.info("--------------> # 部门列表 #");
        return this.departmentService.findAll();
    }

    @ModelAttribute("users")
    public List<User> populateUsers() {
        log.info("--------------> # 用户列表 #");
        return this.userService.findAll();
    }

    @RequestMapping
    public String initPage (User user) {
        log.info("--------------> # 跳转用户管理页面 #");
        return "manage/user";
    }

    @RequestMapping(value = "/add", params = {"add"})
    public String add (User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getAllErrors().toString());
            return "manage/user";
        } else {
            user.setPassword("111111");
            user.setCreateDate(new Date());
            user.setStatus(Constant.VALID);
            int result = userService.add(user);
            log.info("--------------> # 新增用户 #" + result + "个");
            return "redirect:/user";
        }
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
