package travelwink.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomePageController {

    @RequestMapping
    public String initPage(Model model) {
        return "page/home";
    }

}
