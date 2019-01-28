package travelwink.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.manage.dao.MenuDao;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.service.MenuService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    @Override
    public Menu findById(int id) {
        return menuDao.findById(id);
    }

    @Override
    public Menu findByUrl(String url) {
        Menu menu = menuDao.findByUrl(url);
        Menu menuRoot = menuDao.findParentById(menu.getParentId());
        menuRoot.setSubMenus(new ArrayList<Menu>());
        menuRoot.getSubMenus().add(menu);
        return menuRoot;
    }
}
