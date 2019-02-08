package travelwink.manage.service;

import travelwink.manage.domain.entity.Content;
import travelwink.manage.domain.entity.Navigation;
import travelwink.manage.domain.entity.Page;
import travelwink.manage.domain.entity.Paragraph;

import java.util.List;

public interface ReleaseService {


    int addContent(Content content);

    int addParagraph(Paragraph paragraph);

    List<Content> findAll();

    Page findPageById(int id);

    Content findByPageId(int id);

    Navigation findParent(Navigation navigation);
}
