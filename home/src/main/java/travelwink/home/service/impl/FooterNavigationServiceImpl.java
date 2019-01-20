package travelwink.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.home.dao.FooterNavigationDao;
import travelwink.home.entity.FooterNavigation;
import travelwink.home.service.FooterNavigationService;

import java.util.List;

@Service
public class FooterNavigationServiceImpl implements FooterNavigationService {

    @Autowired
    FooterNavigationDao footerNavigationDao;

    @Override
    public List<FooterNavigation> findAll() {
        List<FooterNavigation> footerNavigationList = footerNavigationDao.findAll();
        return footerNavigationList;
    }
}
