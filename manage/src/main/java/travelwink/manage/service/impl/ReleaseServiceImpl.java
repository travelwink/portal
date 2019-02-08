package travelwink.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import travelwink.manage.common.Constant;
import travelwink.manage.dao.NavigationDao;
import travelwink.manage.dao.ReleaseDao;
import travelwink.manage.domain.entity.Content;
import travelwink.manage.domain.entity.Navigation;
import travelwink.manage.domain.entity.Page;
import travelwink.manage.service.ReleaseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseDao releaseDao;

    @Autowired
    NavigationDao navigationDao;

    @Override
    @Transactional
    public int addContent(Content content) {
        int resultCount = 0;
        Page page = new Page();
        int pageResult = releaseDao.addPage(page);
        content.setPage(page);
        int contentResult = releaseDao.addContent(content);
        if (1==contentResult && 1==pageResult) {
            resultCount = 1;
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return resultCount;
        }
        return resultCount;
    }

    @Override
    public List<Content> findAll() {
        return releaseDao.findAll();
    }

    @Override
    public Page findPageById(int id) {
        return releaseDao.findPageById(id);
    }

    @Override
    public Navigation findParent(Navigation navigation) {
        Navigation parentNavigation;
        Navigation grandparent;
        if (Constant.NAVIGATION_ROOT != navigation.getParentId()) {
            parentNavigation = navigationDao.findById(navigation.getParentId());
            parentNavigation.setSubNavigation(new ArrayList<Navigation>());
            parentNavigation.getSubNavigation().add(navigation);
            if (Constant.NAVIGATION_ROOT != parentNavigation.getParentId()) {
                grandparent = this.findParent(parentNavigation);
                return grandparent;
            }
            return parentNavigation;
        }
        return navigation;
    }

}
