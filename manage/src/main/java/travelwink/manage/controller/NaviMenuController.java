package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/naviMenu")
public class NaviMenuController {

    @GetMapping
    public String initPage(Model model) {
        return "page/naviMenu";
    }

}
