package travelwink.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Department;

import java.util.List;

@Mapper
@Repository
public interface DepartmentDao {

    @Select("SELECT * FROM t_department")
    List<Department> findAll();
}
