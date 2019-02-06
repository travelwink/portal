package travelwink.manage.service;

import travelwink.manage.domain.entity.Content;
import travelwink.manage.domain.entity.Page;

import java.util.List;

public interface ReleaseService {

    List<Content> findAll();

    Page findPageById(int id);

}
