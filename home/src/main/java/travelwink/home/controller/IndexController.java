package travelwink.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import travelwink.home.entity.Content;
import travelwink.home.entity.FooterNavigation;
import travelwink.home.entity.Navigation;
import travelwink.home.entity.Slide;
import travelwink.home.service.ContentService;
import travelwink.home.service.FooterNavigationService;
import travelwink.home.service.NavigationService;
import travelwink.home.service.SlideService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping
public class IndexController {


    @Autowired
    NavigationService navigationService;

    @Autowired
    ContentService contentService;

    @Autowired
    SlideService slideService;

    @Autowired
    FooterNavigationService footerNavigationService;

    @RequestMapping
    public String init(Model model){
        Content lastRelease = contentService.findLastRelease();
        List<Content> contentsAtHome = contentService.findAtHome();
        List<Navigation> navigationList = navigationService.findAll();
        List<Slide> slides = slideService.findAll();
        List<FooterNavigation> footerNavigationList = footerNavigationService.findAll();
        model.addAttribute("navigationList", navigationList);
        model.addAttribute("lastRelease", lastRelease);
        model.addAttribute("contentsAtHome", contentsAtHome);
        model.addAttribute("slides", slides);
        model.addAttribute("footerNavigationList", footerNavigationList);
        return "index";
    }

    @RequestMapping("/page/{id}")
    public String page(@PathVariable String id, Model model) {
        log.info("id:" + id);
        List<Navigation> navigationList = navigationService.findAll();
        model.addAttribute("navigationList", navigationList);
        List<FooterNavigation> footerNavigationList = footerNavigationService.findAll();
        model.addAttribute("footerNavigationList", footerNavigationList);
        return "page";
    }


}
