package travelwink.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.home.dao.NavigationDao;
import travelwink.home.entity.Navigation;
import travelwink.home.service.NavigationService;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    NavigationDao navigationDao;

    @Override
    public List<Navigation> findLevel1() {
        List<Navigation> Level1NavigationList = navigationDao.findLevel1();
        return Level1NavigationList;
    }

    public List<Navigation> findAll() {
        List<Navigation> navigationList = navigationDao.findAll();
        return navigationList;
    }
}
