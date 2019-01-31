package travelwink.manage.conversion;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.domain.entity.Navigation;
import travelwink.manage.service.MenuService;

import java.text.ParseException;
import java.util.Locale;

public class MenuFormatter implements Formatter<Menu> {

//    @Autowired
//    MenuService menuService;

    @Override
    public Menu parse(String id, Locale locale) throws ParseException {
//        if (StringUtils.isNotBlank(id)){
//            int menuId = Integer.valueOf(id);
//            return this.menuService.findById(menuId);
//        }
//        return null;
        Menu menu = new Menu();
        menu.setId(Integer.valueOf(id));
        return menu;
    }

    @Override
    public String print(Menu menu, Locale locale) {
        return (menu != null ? menu.toString() : "");
    }
}
