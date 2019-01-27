package travelwink.manage.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.domain.entity.User;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Select("SELECT * FROM t_user tu WHERE tu.name = #{name}")
    @Results({
            @Result(column = "fk_dept_id", property = "department", one = @One(select = "travelwink.manage.dao.DepartmentDao.findById", fetchType = FetchType.EAGER))
    })
    User loadUserByUsername(String name);

    @Insert("INSERT INTO t_user (name, password, nick_name, avatar, email, mobile, fk_dept_id, status, create_date, create_by) VALUES (#{name}, #{password}, #{nickName}, #{avatar}, #{email}, #{mobile}, #{department.id}, #{status}, #{createDate}, #{createBy})")
    int create(User user);

    @Update("UPDATE t_user SET name = #{name}, password = #{password}, nick_name = #{nickName}, email = #{email}, fk_dept_id = #{department.id} WHERE id = #{id}")
    int update(User user);

    @Delete("DELETE FROM t_user WHERE id = #{id}")
    int delete(int id);

    @Select("SELECT * FROM t_user tu WHERE tu.status = 1")
    @Results({
            @Result(column = "fk_dept_id", property = "department", one = @One(select = "travelwink.manage.dao.UserDao.findDepartment", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select("SELECT * FROM t_user WHERE id = #{id} ")
    @Results({
            @Result(column = "fk_dept_id", property = "department", one = @One(select = "travelwink.manage.dao.DepartmentDao.findById", fetchType = FetchType.EAGER))
    })
    User findById(int id);

    @Select("SELECT * FROM t_department td WHERE td.id = #{id} ")
    Department findDepartment(int id);
}
