package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import travelwink.manage.bean.RestBody;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.service.DepartmentService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String initPage(Model model){
        log.info("--------------> # 查询所有部门 #");
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        log.info("--------------> # 跳转部门管理页面 #");
        return "manage/department";
    }

    @RequestMapping("/create")
    @ResponseBody
    public RestBody create(Department department){
        return RestBody.success();
    }

}
