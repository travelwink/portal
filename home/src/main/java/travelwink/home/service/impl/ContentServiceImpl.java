package travelwink.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.home.dao.ContentDao;
import travelwink.home.entity.Content;
import travelwink.home.service.ContentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentDao contentDao;

    @Override
    public Content findById(int id) {
        return contentDao.findById(id);
    }

    @Override
    public Content findLastRelease() {
        Content lastRelease = contentDao.findLastRelease();
        return lastRelease;
    }

    @Override
    public List<Content> findAtHome() {
        List<Content> homeContent1 = contentDao.findAtHome1();
        List<Content> homeContent2 = contentDao.findAtHome2();
        List<Content> homeContent = new ArrayList<Content>();
        homeContent.addAll(homeContent1);
        homeContent.addAll(homeContent2);
        return homeContent;
    }
}
