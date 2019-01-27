package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travelwink.manage.bean.Message;
import travelwink.manage.bean.RestBody;
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

//    @ModelAttribute("departments")
//    public List<Department> populateDepartments() {
//        return this.departmentService.findAll();
//    }
//
//    @ModelAttribute("menus")
//    public List<Menu> populateMenus() {
//        return this.menuService.findAll();
//    }

    @GetMapping
    public String initPage(Department department, Model model){
        List<Menu> menus = menuService.findAll();
        List<Navigation> navigationRoots = navigationService.findRoot();
        List<Department> departments = departmentService.findAll();
        Menu breadcrumb = menuService.findByUrl("/department");
        model.addAttribute("menus",menus);
        model.addAttribute("navigationRoots", navigationRoots);
        model.addAttribute("departments", departments);
        model.addAttribute("breadcrumb",breadcrumb);
        return "manage/department";
    }

    @RequestMapping(value = "/add", params = {"add"})
    public String add(Department department, RedirectAttributes attributes, Principal principal){
        Message message;
        department.setCreateBy(""+ userService.loadUserByUsername(principal.getName()).getId());
        department.setCreateDate(new Date());
        department.setStatus(Constant.VALID);
        int resultCount = departmentService.add(department);
        Department savedDepartment = department;
        if (1 == resultCount) {
            message = new Message(1,Constant.MESSAGE_SAVE_SUCCESS);
        } else {
            message = new Message(0, Constant.MESSAGE_SAVE_FAILURE);
        }
        attributes.addFlashAttribute("message",message);
        return "redirect:/department";
    }

}
