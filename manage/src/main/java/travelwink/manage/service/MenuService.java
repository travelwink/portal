package travelwink.manage.service;

import travelwink.manage.domain.entity.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> findAll();

    Menu findById(int id);

    Menu findByUrl(String url);

}
