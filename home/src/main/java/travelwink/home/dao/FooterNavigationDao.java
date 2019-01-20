package travelwink.home.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.FooterNavigation;

import java.util.List;

@Mapper
@Repository
public interface FooterNavigationDao {

    @Select("SELECT * FROM t_footer_navigation tfn WHERE tfn.status = 1 ORDER BY tfn.seq ASC")
    List<FooterNavigation> findAll();
}
