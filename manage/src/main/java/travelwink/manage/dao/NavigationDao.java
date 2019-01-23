package travelwink.manage.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Navigation;

import java.util.List;

@Mapper
@Repository
public interface NavigationDao {

    @Select("SELECT * FROM t_navigation tn WHERE tn.status = 1 AND tn.level = 1")
    List<Navigation> findRoot();

    @Select("SELECT * FROM t_navigation tn WHERE tn.status = 1 AND tn.level = 1")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "subNavigation", javaType = List.class,
                    many = @Many(select = "travelwink.manage.dao.NavigationDao.findByParentId", fetchType = FetchType.LAZY))
    })
    List<Navigation> findAll();

    @Select("SELECT * FROM t_navigation tn WHERE tn.status = 1 and tn.parent_id = #{parentId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "subNavigation", javaType = List.class,
                    many = @Many(select = "travelwink.manage.dao.NavigationDao.findByParentId", fetchType = FetchType.LAZY))
    })
    List<Navigation> findByParentId(int parentId);


}
