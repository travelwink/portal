package travelwink.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import travelwink.manage.domain.entity.TempEntity;

import java.util.List;

@Mapper
@Repository
public interface TempDao {

    @Select("SELECT * FROM temp")
    List<TempEntity> getJSON();
}
