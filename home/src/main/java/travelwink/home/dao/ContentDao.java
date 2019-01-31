package travelwink.home.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.Content;

import java.util.List;

@Mapper
@Repository
public interface ContentDao {

    @Select("SELECT * FROM t_content tc WHERE tc.id = #{id}")
    Content findById(int id);

    @Select("SELECT * FROM t_content tc WHERE tc.status = 1 AND tc.fk_content_type_id = 1 ORDER BY tc.create_date DESC LIMIT 1")
    @Results({
            @Result(column = "fk_content_type_id", property = "contentType",
                    one = @One(select = "travelwink.home.dao.ContentTypeDao.findById", fetchType = FetchType.EAGER))
    })
    Content findLastRelease();

    @Select("SELECT * FROM t_content tc WHERE tc.status = 1 AND tc.home_location = 1 ORDER BY tc.create_date DESC LIMIT 2")
    @Results({
            @Result(column = "fk_content_type_id", property = "contentType",
                    one = @One(select = "travelwink.home.dao.ContentTypeDao.findById", fetchType = FetchType.EAGER))
    })
    List<Content> findAtHome1();

    @Select("SELECT * FROM t_content tc WHERE tc.status = 1 AND tc.home_location = 2 ORDER BY tc.create_date DESC LIMIT 3")
    @Results({
            @Result(column = "fk_content_type_id", property = "contentType",
                    one = @One(select = "travelwink.home.dao.ContentTypeDao.findById", fetchType = FetchType.EAGER))
    })
    List<Content> findAtHome2();

}
