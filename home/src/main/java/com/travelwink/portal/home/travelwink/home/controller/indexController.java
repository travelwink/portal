package com.travelwink.portal.home.travelwink.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import travelwink.manage.domain.entity.Navigation;
import travelwink.manage.service.NavigationService;

import java.util.List;

@Slf4j
@Controller
public class indexController {

    @Autowired
    private NavigationService navigationService;

    @ModelAttribute("navigations")
        public List<Navigation> populateNavigations() {
        log.info("--------------> # 导航列表 #");
        return navigationService.findAll();
    }

    @RequestMapping("/")
    public String init(){
        return "index";
    }
}
