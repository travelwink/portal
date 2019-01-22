package travelwink.manage.service;

import travelwink.manage.domain.entity.Slide;

import java.util.List;

public interface SlideService {

    List<Slide> findAll();

    void addSlide(Slide slide);
}
