package travelwink.home.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.home.entity.File;

@Mapper
@Repository
public interface FileDao {

    @Select("SELECT * FROM t_file tf WHERE tf.id = #{id}")
    File findById(int id);
}
