package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/navigation")
public class NavigationController {

    @GetMapping
    public String initPage(Model model) {
        model.addAttribute("navigationList");
        return "page/navigation";
    }

}
