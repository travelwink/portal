package travelwink.manage.service;

import travelwink.manage.domain.entity.Navigation;

import java.util.List;

public interface NavigationService {

    int addRoot(Navigation navigation);

    List<Navigation> findRoot();

    List<Navigation> findChildren(int id);

    List<Navigation> findAll();

}
