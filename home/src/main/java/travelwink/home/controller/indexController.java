package travelwink.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import travelwink.home.entity.Navigation;
import travelwink.home.service.NavigationService;

import java.util.List;

@Slf4j
@Controller
public class indexController {


    @Autowired
    NavigationService navigationService;

    @RequestMapping({"/index","/"})
    public String init(Model model){
        List<Navigation> navigationList = navigationService.findAll();
        model.addAttribute("navigationList", navigationList);
        return "index";
    }
}
