package travelwink.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.manage.dao.MenuDao;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> findAll() {
        return menuDao.findAll();
    }
}
