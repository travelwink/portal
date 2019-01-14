package travelwink.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Menu;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {
    List<Menu> getFirstMenu();

    List<Menu> findAll();

    Menu findByid(int id);

    List<Menu> findByDeptId(int deptId);
}
