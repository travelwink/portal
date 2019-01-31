package travelwink.home.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.Page;

@Mapper
@Repository
public interface PageDao {

    @Select("SELECT * FROM t_page tp WHERE tp.id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "fk_navigation_id", property = "navigation", one = @One(select = "travelwink.home.dao.NavigationDao.findById")),
            @Result(column = "id", property = "paragraphs", many = @Many(select = "travelwink.home.dao.ParagraphDao.findByPageId")),
            @Result(column = "id", property = "footerLinks", many = @Many(select = "travelwink.home.dao.FooterLinkDao.findByPageId"))
    })
    Page findById(int id);

}
