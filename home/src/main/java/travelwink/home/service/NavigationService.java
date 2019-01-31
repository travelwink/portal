package travelwink.home.service;

import travelwink.home.entity.Navigation;

import java.util.List;

public interface NavigationService {

    Navigation populateSecondaryNavigationByCurrentId(int id);

    Navigation populateBreadcrumbsByCurrentId(int id);

    List<Navigation> findLevel1();

    List<Navigation> findAll();


}
