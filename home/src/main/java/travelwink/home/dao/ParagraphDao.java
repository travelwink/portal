package travelwink.home.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.Paragraph;

import java.util.List;

@Mapper
@Repository
public interface ParagraphDao {

    @Select("SELECT * FROM t_paragraph tp WHERE tp.fk_page_id = #{id} ORDER BY tp.seq")
    List<Paragraph> findByPageId(int id);
}
