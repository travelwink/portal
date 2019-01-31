package travelwink.manage.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Content;
import travelwink.manage.domain.entity.ContentType;

import java.util.List;

@Mapper
@Repository
public interface ReleaseDao {

    @Select("SELECT * FROM t_content")
    @Results({
            @Result(column = "fk_content_type_id", property = "contentType", one = @One(select = "travelwink.manage.dao.ReleaseDao.findById"))
    })
    List<Content> findAll();

    @Select("SELECT * FROM t_content_type tct WHERE tct.id = #{id}")
    ContentType findById(int id);
}
