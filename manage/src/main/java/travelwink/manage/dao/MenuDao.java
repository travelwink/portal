package travelwink.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import travelwink.manage.domain.entity.Menu;

import java.util.List;

@Mapper
public interface MenuDao {
    List<Menu> getFirstMenu();

    List<Menu> getMenu (Menu menu);
}
