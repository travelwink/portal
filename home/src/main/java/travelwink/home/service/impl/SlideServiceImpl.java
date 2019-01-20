package travelwink.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.home.dao.SlideDao;
import travelwink.home.entity.Slide;
import travelwink.home.service.SlideService;

import java.util.List;

@Service
public class SlideServiceImpl implements SlideService {

    @Autowired
    SlideDao slideDao;

    @Override
    public List<Slide> findAll() {
        return slideDao.findAll();
    }
}
