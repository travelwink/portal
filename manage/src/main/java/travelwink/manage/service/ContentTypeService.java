package travelwink.manage.service;

import travelwink.manage.domain.entity.ContentType;

import java.util.List;

public interface ContentTypeService {

    List<ContentType> findAll();

    ContentType findById(int id);
}
