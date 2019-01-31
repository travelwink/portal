package travelwink.home.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.FooterLink;

import java.util.List;

@Mapper
@Repository
public interface FooterLinkDao {

    @Select("SELECT * FROM t_footer_link tfl WHERE fk_page_id = #{pageId}")
    @Results({
            @Result(column = "fk_content_type_id", property = "contentType", one = @One(select = "travelwink.home.dao.ContentTypeDao.findById")),
            @Result(column = "fk_file_id", property = "file", one = @One(select = "travelwink.home.dao.FileDao.findById"))
    })
    List<FooterLink> findByPageId(int pageId);

}
