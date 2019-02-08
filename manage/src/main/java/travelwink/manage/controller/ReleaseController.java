package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Result;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travelwink.manage.bean.Message;
import travelwink.manage.common.Constant;
import travelwink.manage.domain.entity.*;
import travelwink.manage.service.ContentTypeService;
import travelwink.manage.service.MenuService;
import travelwink.manage.service.NavigationService;
import travelwink.manage.service.ReleaseService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    MenuService menuService;

    @Autowired
    ReleaseService releaseService;

    @Autowired
    ContentTypeService contentTypeService;

    @Autowired
    NavigationService navigationService;

    @RequestMapping
    public String initPage(Content content, Model model) {
        Menu breadcrumb = menuService.findByUrl("/release");
        model.addAttribute("breadcrumb", breadcrumb);

        List<Content> contents = releaseService.findAll();
        model.addAttribute("contents", contents);

        List<ContentType> contentTypes = contentTypeService.findAll();
        model.addAttribute("contentTypes", contentTypes);
        return "page/release";
    }

    @RequestMapping("/add")
    public String addConetnt(Content content, RedirectAttributes attributes) {
        Message message;
        log.info(""+content);
        int resultCount = releaseService.addContent(content);
        if (1 == resultCount) {
            message = new Message(1, Constant.MESSAGE_SAVE_SUCCESS);
        } else {
            message = new Message(0, Constant.MESSAGE_SAVE_FAILURE);
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/release";
    }

    @RequestMapping("/modifyDetail/{id}")
    public String modifyDetail(@PathVariable String id, Navigation navigation, Model model) {
        int contentId = Integer.valueOf(id);
        Page page = releaseService.findPageById(contentId);
        model.addAttribute("page", page);

        Navigation pageNavigation = null;
        if (null != page.getNavigation()) {
            pageNavigation = releaseService.findParent(page.getNavigation());
        } else {
            pageNavigation = new Navigation();
        }
        model.addAttribute("pageNavigation", pageNavigation);

        List<Navigation> navigations = navigationService.findRoot();
        model.addAttribute("navigations", navigations);

        Menu breadcrumb = menuService.findByUrl("/release");
        model.addAttribute("breadcrumb", breadcrumb);

        String action = "页面编辑";
        model.addAttribute("action",action);
        return "page/releaseDetail";
    }

}
