package travelwink.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travelwink.manage.dao.TempDao;
import travelwink.manage.domain.entity.TempEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConvertJSON {

    @Autowired
    TempDao tempDao;

    @RequestMapping("/temp")
    public List<TempEntity> convertToJSON (){

        List<TempEntity> tempEntityList = tempDao.getJSON();

        List<TempEntity> coveredTempEntityList = new ArrayList<TempEntity>();

        for (TempEntity tempEntity: tempEntityList) {
            String cover = "****";
            StringBuffer stringBuffer = new StringBuffer(tempEntity.getMobile());
            stringBuffer.replace(3,7,cover);
            tempEntity.setMobile(stringBuffer.toString());
            coveredTempEntityList.add(tempEntity);
        }

        return coveredTempEntityList;
    }

}
