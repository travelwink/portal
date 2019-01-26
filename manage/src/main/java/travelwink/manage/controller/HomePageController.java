package travelwink.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.service.MenuService;

@Controller
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    MenuService menuService;

    @RequestMapping
    public String initPage(Model model) {
        Menu breadcrumb = menuService.findByUrl("/home");
        model.addAttribute("breadcrumb", breadcrumb);
        return "page/home";
    }

}
