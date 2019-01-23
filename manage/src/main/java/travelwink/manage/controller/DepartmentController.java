package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import travelwink.manage.bean.RestBody;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.domain.entity.Navigation;
import travelwink.manage.service.DepartmentService;
import travelwink.manage.service.MenuService;
import travelwink.manage.service.NavigationService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/department")
public class DepartmentController {

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
        model.addAttribute("menus",menus);
        model.addAttribute("navigationRoots", navigationRoots);
        return "manage/department";
    }

    @RequestMapping("/create")
    @ResponseBody
    public RestBody create(Department department){
        return RestBody.success();
    }

}
