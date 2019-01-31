package travelwink.home.service;

import travelwink.home.entity.Content;

import java.util.List;

public interface ContentService {

    Content findById(int id);

    Content findLastRelease();

    List<Content> findAtHome();
}
