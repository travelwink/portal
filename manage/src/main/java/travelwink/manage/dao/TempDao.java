package travelwink.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import travelwink.manage.domain.entity.TempEntity;

import java.util.List;

@Mapper
public interface TempDao {

    @Select("SELECT * FROM temp")
    List<TempEntity> getJSON();
}
