package travelwink.manage.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Navigation;

import java.util.List;

@Mapper
@Repository
public interface NavigationDao {

    @Insert("INSERT INTO t_navigation (name, parent_id, level) VALUES (#{name}, 0, 1)")
    int addRoot(Navigation navigation);

    @Select("SELECT * FROM t_navigation tn WHERE tn.id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "subNavigation", javaType = List.class,
                    many = @Many(select = "travelwink.manage.dao.NavigationDao.findByParentId", fetchType = FetchType.LAZY))
    })
    Navigation findById(int id);

    @Select("SELECT * FROM t_navigation tn WHERE tn.id = #{id}")
    Navigation simpleFindById(int id);

    @Select("SELECT * FROM t_navigation tn WHERE tn.status = 1 AND tn.level = 1")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "subNavigation", javaType = List.class,
                    many = @Many(select = "travelwink.manage.dao.NavigationDao.findByParentId", fetchType = FetchType.LAZY))
    })
    List<Navigation> findRoot();

    @Select("SELECT * FROM t_navigation tn WHERE tn.status = 1 AND tn.parent_id = #{id}")
    List<Navigation> findChildren(int id);

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
