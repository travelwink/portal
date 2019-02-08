package travelwink.manage.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.*;

import java.util.List;

@Mapper
@Repository
public interface ReleaseDao {

    @Insert("INSERT INTO t_content (fk_content_type_id, no, title, description, fk_page_id, status) VALUES (#{contentType.id}, #{no}, #{title}, #{description}, #{page.id}, #{status})")
    @Options(useGeneratedKeys = true)
    int addContent(Content content);

    @Insert("INSERT INTO t_page (keywords, fk_navigation_id, head_img, head_img_vertical, customer_form, footer_link_style) VALUES (#{keywords}, #{navigation.id}, #{headImg}, #{headImgVertical}, #{customerForm}, #{footerLinkStyle})")
    @Options(useGeneratedKeys = true)
    int addPage(Page page);

    @Insert("INSERT INTO t_paragraph (fk_page_id, text, type, style, seq) VALUES (#{fkPageId}, #{text}, #{type}, #{style}, #{seq})")
    @Options(useGeneratedKeys = true)
    int addParagraph(Paragraph paragraph);

    @Select("SELECT * FROM t_content")
    @Results({
            @Result(column = "fk_content_type_id", property = "contentType", one = @One(select = "travelwink.manage.dao.ContentTypeDao.findById"))
    })
    List<Content> findAll();

    @Select("SELECT * FROM t_content tc WHERE tc.fk_page_id = #{id}")
    Content findByPageId(int id);

    @Select("SELECT * FROM t_page tp WHERE id = (SELECT tc.fk_page_id FROM t_content tc WHERE tc.id = #{id})")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "fk_navigation_id", property = "navigation", one = @One(select = "travelwink.manage.dao.NavigationDao.simpleFindById")),
            @Result(column = "id", property = "paragraphs", many = @Many(select = "travelwink.manage.dao.ReleaseDao.findParagraphByPageId")),
            @Result(column = "id", property = "footerLinks", many = @Many(select = "travelwink.manage.dao.ReleaseDao.findFooterLinkByPageId"))
    })
    Page findPageById(int id);

    @Select("SELECT * FROM t_paragraph tp WHERE tp.fk_page_id = #{id}")
    List<Paragraph> findParagraphByPageId(int id);

    @Select("SELECT * FROM t_footer_link tfl WHERE tfl.fk_page_id = #{id}")
    @Results({
            @Result(column = "fk_content_type_id", property = "contentType", one = @One(select = "travelwink.manage.dao.ContentTypeDao.findById"))
    })
    List<FooterLink> findFooterLinkByPageId (int id);
}
