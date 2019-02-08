package travelwink.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.manage.dao.ContentTypeDao;
import travelwink.manage.domain.entity.ContentType;
import travelwink.manage.service.ContentTypeService;

import java.util.List;

@Service
public class ContentTypeServiceImpl implements ContentTypeService {

    @Autowired
    ContentTypeDao contentTypeDao;

    @Override
    public List<ContentType> findAll() {
        return contentTypeDao.findAll();
    }

    @Override
    public ContentType findById(int id) {
        return contentTypeDao.findById(id);
    }
}
