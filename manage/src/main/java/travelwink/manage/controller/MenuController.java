package travelwink.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travelwink.manage.bean.RestBody;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.service.MenuService;

import java.util.List;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/getMenu")
    public RestBody getMenu (){
        List<Menu> menuList = menuService.getMenu();
        System.out.println(menuList);
        return RestBody.success();
    }


}
