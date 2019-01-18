package travelwink.home.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.Navigation;

import java.util.List;

@Mapper
@Repository
public interface NavigationDao {

    @Select("SELECT * FROM t_navigation tn WHERE tn.level = 1 AND tn.status = 1")
    List<Navigation> findLevel1();

    @Select("SELECT * FROM t_navigation tn WHERE tn.status = 1 AND tn.level = 1")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "children", javaType = List.class,
                    many = @Many(select = "travelwink.home.dao.NavigationDao.findByParentId", fetchType = FetchType.LAZY))
    })
    List<Navigation> findAll();

    @Select("SELECT * FROM t_navigation tn WHERE tn.parent_id = #{parentId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "children", javaType = List.class,
                    many = @Many(select = "travelwink.home.dao.NavigationDao.findByParentId", fetchType = FetchType.LAZY))
    })
    List<Navigation> findByParentId(int parentId);

}
