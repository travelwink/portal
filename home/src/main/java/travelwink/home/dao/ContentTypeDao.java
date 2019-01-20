package travelwink.home.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.ContentType;

@Mapper
@Repository
public interface ContentTypeDao {

    @Select("SELECT * FROM t_content_type tct WHERE tct.id = #{id}")
    ContentType findById(int id);

}
