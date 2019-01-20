package travelwink.home.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.Slide;

import java.util.List;

@Mapper
@Repository
public interface SlideDao {

    @Select("SELECT * FROM t_slide ts WHERE ts.status = 1")
    List<Slide> findAll();
}
