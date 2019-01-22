package travelwink.manage.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.Slide;

import java.util.List;

@Mapper
@Repository
public interface SlideDao {

    @Select("SELECT * FROM t_slide ts")
    List<Slide> findAll();

    @Insert("INSERT INTO t_slide (title, content, theme, img_src, img_mobile_src, img_size, url, create_by, create_date, update_by, update_date, status) VALUES (#{title}, #{content}, #{theme}, #{imgSrc}, #{imgMobileSrc}, #{imgSize}, #{url}, #{createBy}, #{createDate}, #{updateBy}, #{updateDate}, #{status})")
    void addSlide(Slide slide);

}
