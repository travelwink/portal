package travelwink.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.manage.dao.SlideDao;
import travelwink.manage.domain.entity.Slide;
import travelwink.manage.service.SlideService;

import java.util.List;

@Service
public class SlideServiceImpl implements SlideService {

    @Autowired
    SlideDao slideDao;

    @Override
    public List<Slide> findAll() {
        List<Slide> slides = slideDao.findAll();
        return slides;
    }

    @Override
    public void addSlide(Slide slide) {
        slideDao.addSlide(slide);
    }
}
