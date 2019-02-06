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
import travelwink.manage.domain.entity.Content;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.domain.entity.Page;
import travelwink.manage.service.MenuService;
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

    @RequestMapping
    public String initPage(Content content, Model model) {
        Menu breadcrumb = menuService.findByUrl("/release");
        model.addAttribute("breadcrumb", breadcrumb);
        List<Content> contents = releaseService.findAll();
        model.addAttribute("contents", contents);
        return "page/release";
    }

    @RequestMapping("/modifyDetail/{id}")
    public String modifyDetail(@PathVariable String id, Model model) {
        int contentId = Integer.valueOf(id);
        Page page = releaseService.findPageById(contentId);
        model.addAttribute("page", page);

        Menu breadcrumb = menuService.findByUrl("/release");
        model.addAttribute("breadcrumb", breadcrumb);

        String action = "页面编辑";
        model.addAttribute("action",action);
        return "page/releaseDetail";
    }

}
