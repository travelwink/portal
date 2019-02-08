package travelwink.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.ContentType;

import java.util.List;

@Mapper
@Repository
public interface ContentTypeDao {

    @Select("SELECT * FROM t_content_type tct WHERE tct.id = #{id}")
    ContentType findById(int id);

    @Select("SELECT * FROM t_content_type tct")
    List<ContentType> findAll();
}
