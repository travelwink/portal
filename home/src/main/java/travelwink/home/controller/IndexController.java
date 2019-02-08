package travelwink.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import travelwink.home.entity.*;
import travelwink.home.service.*;

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
    PageService pageService;

    @Autowired
    FooterNavigationService footerNavigationService;

    // 导航菜单
    @ModelAttribute("navigationList")
    public List<Navigation> populateNavigationList() {
        return this.navigationService.findAll();
    }

    // 页脚
    @ModelAttribute("footerNavigationList")
    public List<FooterNavigation> populateFooterNavigationList() {
        return this.footerNavigationService.findAll();
    }

    @RequestMapping
    public String init(Model model){

        // 轮播图
        List<Slide> slides = slideService.findAll();
        model.addAttribute("slides", slides);

        // 主页最新发布新闻栏
        Content lastRelease = contentService.findLastRelease();
        model.addAttribute("lastRelease", lastRelease);

        // 主页发布内容
        List<Content> contentsAtHome = contentService.findAtHome();
        model.addAttribute("contentsAtHome", contentsAtHome);

        return "index";
    }

    @RequestMapping("/page/{id}")
    public String page(@PathVariable String id, Model model) {

        int pageId = Integer.valueOf(id);
        Page page = pageService.findById(pageId);
        model.addAttribute("page", page);

        String keywords = page.getKeywords();
        model.addAttribute("keywords", keywords);

        Navigation breadcrumbs;
        if (null != page.getNavigation()) {
            Navigation secondaryNavigation = navigationService.populateSecondaryNavigationByCurrentId(page.getNavigation().getId());
            model.addAttribute("secondaryNavigation", secondaryNavigation);
            breadcrumbs = navigationService.populateBreadcrumbsByCurrentId(page.getNavigation().getId());
        } else {
            breadcrumbs = new Navigation();
            breadcrumbs.setName(page.getTitle());
        }
        model.addAttribute("breadcrumbs",breadcrumbs);

        return "page";
    }


}
