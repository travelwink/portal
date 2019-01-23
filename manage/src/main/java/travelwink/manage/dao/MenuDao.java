package travelwink.manage.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Menu;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {
    List<Menu> getFirstMenu();

    @Select("SELECT * FROM t_menu tm WHERE tm.status = 1 AND tm.level = 1")
    @Results({
            @Result(column = "id", property = "subMenus", many = @Many(select = "travelwink.manage.dao.MenuDao.findByParentid"))
    })
    List<Menu> findAll();

    @Select("SELECT * FROM t_menu tm WHERE tm.status = 1 AND tm.parent_id = #{id}")
    Menu findByParentid(int id);

    @Select("SELECT * FROM t_menu tm WHERE tm.id IN (SELECT rdm.fk_menu_id FROM tr_department_menu rdm WHERE rdm.fk_department_id= #{id}) AND status = 1")
    List<Menu> findByDeptId(int deptId);
}
