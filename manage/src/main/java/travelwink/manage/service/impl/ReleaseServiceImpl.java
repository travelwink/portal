package travelwink.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.manage.dao.ReleaseDao;
import travelwink.manage.domain.entity.Content;
import travelwink.manage.domain.entity.Page;
import travelwink.manage.service.ReleaseService;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseDao releaseDao;

    @Override
    public List<Content> findAll() {
        return releaseDao.findAll();
    }

    @Override
    public Page findPageById(int id) {
        return releaseDao.findPageById(id);
    }
}
