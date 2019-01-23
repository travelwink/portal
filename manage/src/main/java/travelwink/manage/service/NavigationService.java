package travelwink.manage.service;

import travelwink.manage.domain.entity.Navigation;

import java.util.List;

public interface NavigationService {

    List<Navigation> findRoot();

    List<Navigation> findAll();

}
