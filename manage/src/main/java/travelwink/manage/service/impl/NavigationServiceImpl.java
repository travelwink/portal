package travelwink.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.manage.dao.NavigationDao;
import travelwink.manage.domain.entity.Navigation;
import travelwink.manage.service.NavigationService;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    NavigationDao navigationDao;

    @Override
    public List<Navigation> findRoot() {
        return navigationDao.findRoot();
    }

    @Override
    public List<Navigation> findAll() {
        return navigationDao.findAll();
    }
}
