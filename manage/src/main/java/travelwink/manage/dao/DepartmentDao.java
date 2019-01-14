package travelwink.manage.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.domain.entity.Menu;

import java.util.List;

@Mapper
@Repository
public interface DepartmentDao {

    @Select("SELECT * FROM t_department td WHERE td.status = 1")
    List<Department> findAll();

    @Select("SELECT * FROM t_department td WHERE td.id = #{id};")
    @Results(
            @Result(column = "id", property = "menus", many = @Many(select = "travelwink.manage.dao.MenuDao.findByDeptId", fetchType = FetchType.EAGER))
    )
    Department findById(int id);

    @Select("SELECT * FROM t_department td, t_menu tm, tr_department_menu rdm WHERE rdm.fk_department_id = td.id AND rdm.fk_menu_id = tm.id AND rdm.fk_department_id = #{id};")
    List<Menu> getMenuListById(String id);

}
