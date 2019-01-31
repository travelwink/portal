package travelwink.home.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.Navigation;

import java.util.List;

@Mapper
@Repository
public interface NavigationDao {

    @Select("SELECT * FROM t_navigation tn WHERE tn.id = #{id}")
    Navigation findById(int id);

    @Select("SELECT * FROM t_navigation tn WHERE tn.parent_id = #{parentId} AND tn.id != #{id}")
    List<Navigation> findBrotherByNavigation(@Param("parentId") int parentId, @Param("id") int id);

    @Select("SELECT * FROM t_navigation tn WHERE tn.id = #{parentId}")
    Navigation findCurrentParent(int parentId);

    @Select("SELECT * FROM t_navigation tn WHERE tn.level = 1 AND tn.status = 1")
    List<Navigation> findRoots();

    @Select("SELECT * FROM t_navigation tn WHERE tn.status = 1 AND tn.level = 1")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "children", javaType = List.class,
                    many = @Many(select = "travelwink.home.dao.NavigationDao.findChildrenByParentId", fetchType = FetchType.LAZY))
    })
    List<Navigation> findAll();

    @Select("SELECT * FROM t_navigation tn WHERE tn.parent_id = #{parentId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "children", javaType = List.class,
                    many = @Many(select = "travelwink.home.dao.NavigationDao.findChildrenByParentId", fetchType = FetchType.LAZY))
    })
    List<Navigation> findChildrenByParentId(int parentId);

}
