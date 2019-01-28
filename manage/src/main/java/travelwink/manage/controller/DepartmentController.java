package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travelwink.manage.bean.Message;
import travelwink.manage.common.Constant;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.domain.entity.Navigation;
import travelwink.manage.service.DepartmentService;
import travelwink.manage.service.MenuService;
import travelwink.manage.service.NavigationService;
import travelwink.manage.service.UserService;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private NavigationService navigationService;

    @GetMapping
    public String initPage(Department department, Model model){

        List<Menu> menus = menuService.findAll();
        model.addAttribute("menus",menus);

        List<Navigation> navigationRoots = navigationService.findRoot();
        model.addAttribute("navigationRoots", navigationRoots);

        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);

        Menu breadcrumb = menuService.findByUrl("/department");
        model.addAttribute("breadcrumb",breadcrumb);

        return "manage/department";
    }

    @RequestMapping(value = "/add", params = {"add"})
    public String add (Department department, RedirectAttributes attributes, Principal principal) {
        Message message;
        department.setCreateBy(""+ userService.loadUserByUsername(principal.getName()).getId());
        department.setCreateDate(new Date());
        department.setStatus(Constant.VALID);
        int departmentResult = departmentService.add(department);
        if( 1 == departmentResult) {
            message = new Message(1,"保存成功");
        } else {
            message = new Message(0,"保存失败");
        }
        attributes.addFlashAttribute("message",message);
        return "redirect:/department";
    }

}
