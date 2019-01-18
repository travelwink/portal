package travelwink.home.service;

import travelwink.home.entity.Navigation;

import java.util.List;

public interface NavigationService {
    List<Navigation> findLevel1();

    List<Navigation> findAll();
}
