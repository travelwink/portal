package travelwink.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.home.dao.PageDao;
import travelwink.home.entity.Page;
import travelwink.home.service.PageService;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    PageDao pageDao;

    @Override
    public Page findById(int id) {
        return pageDao.findById(id);
    }
}
