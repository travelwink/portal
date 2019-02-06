package travelwink.manage.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.*;

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

    @Select("SELECT * FROM t_page tp WHERE id = (SELECT tc.fk_page_id FROM t_content tc WHERE tc.id = #{id})")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "paragraphs", many = @Many(select = "travelwink.manage.dao.ReleaseDao.findParagraphByPageId")),
            @Result(column = "id", property = "footerLinks", many = @Many(select = "travelwink.manage.dao.ReleaseDao.findFooterLinkByPageId"))
    })
    Page findPageById(int id);

    @Select("SELECT * FROM t_paragraph tp WHERE tp.fk_page_id = #{id}")
    List<Paragraph> findParagraphByPageId(int id);

    @Select("SELECT * FROM t_footer_link tfl WHERE tfl.fk_page_id = #{id}")
    @Results({
            @Result(column = "fk_content_type_id", property = "contentType", one = @One(select = "travelwink.manage.dao.ReleaseDao.findById"))
    })
    List<FooterLink> findFooterLinkByPageId (int id);
}
