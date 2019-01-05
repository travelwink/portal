package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/release")
public class ReleaseController {


    public String initPage(ModelMap modelMap) {
        log.info("--------------> # 查询所有内容发布列表 #");
        return "/manage/release";
    }


}
