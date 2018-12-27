package travelwink.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import travelwink.manage.bean.RestBody;
import travelwink.manage.domain.entity.Department;

@Controller
public class DepartmentController {

    @RequestMapping("/create")
    @ResponseBody
    public RestBody create(Department department){
        return RestBody.success();
    }

}
