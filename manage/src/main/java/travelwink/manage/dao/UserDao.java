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

    @Insert("INSERT INTO t_user (name, password, nick_name, avatar, email, mobile, fk_dept_id, status, create_date, create_by) VALUES (#{name}, #{password}, #{nickName}, #{avatar}, #{email}, #{mobile}, #{department.id}, #{status}, #{createDate}, #{createBy})")
    int create(User user);

    int modifyUser(User user);

    @Select("SELECT * FROM t_user tu WHERE tu.status = 1")
    @Results(
            @Result(column = "fk_dept_id", property = "department", one = @One(select = "travelwink.manage.dao.UserDao.getDeptById", fetchType = FetchType.EAGER))
    )
    List<User> findAll();

    @Select("SELECT * FROM t_user WHERE id = #{id} ")
    @Results(
            @Result(column = "fk_dept_id", property = "department", one = @One(select = "travelwink.manage.dao.UserDao.getDeptById", fetchType = FetchType.EAGER))
    )
    List<User> findById(int id);

    @Select("SELECT * FROM t_department WHERE id = #{id}")
    Department getDeptById(String id);
}
