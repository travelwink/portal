package travelwink.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import travelwink.manage.domain.entity.Menu;

import java.util.ArrayList;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(Model model){
        Menu breadcrumb = new Menu();
        breadcrumb.setSubMenus(new ArrayList<Menu>());
        breadcrumb.getSubMenus().add(new Menu());
        model.addAttribute("breadcrumb", breadcrumb);
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
