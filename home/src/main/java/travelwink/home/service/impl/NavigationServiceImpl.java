package travelwink.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.home.dao.NavigationDao;
import travelwink.home.entity.Navigation;
import travelwink.home.service.NavigationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    NavigationDao navigationDao;

    @Override
    public Navigation populateSecondaryNavigationByCurrentId(int id) {

        Navigation navigation = navigationDao.findById(id);

        List<Navigation> subNavigation = navigationDao.findChildrenByParentId(id);

        navigation.setChildren(subNavigation);

        Navigation secondaryNavigation = this.initSecondaryNavigation(navigation);

        return secondaryNavigation;
    }

    @Override
    public Navigation populateBreadcrumbsByCurrentId(int id) {
        Navigation navigation = navigationDao.findById(id);
        Navigation breadcrumbs = this.findCurrentParent(navigation);
        return breadcrumbs;
    }

    @Override
    public List<Navigation> findLevel1() {
        List<Navigation> Level1NavigationList = navigationDao.findRoots();
        return Level1NavigationList;
    }

    public List<Navigation> findAll() {
        List<Navigation> navigationList = navigationDao.findAll();
        return navigationList;
    }

    public Navigation findCurrentParent(Navigation navigation) {
        if (navigation.getParentId() != 0) {

            Navigation parentNavigation = navigationDao.findCurrentParent(navigation.getParentId());

            parentNavigation.setChildren(new ArrayList<Navigation>());
            parentNavigation.getChildren().add(navigation);

            if (parentNavigation.getParentId() != 0){
                this.findCurrentParent(parentNavigation);
            } else {
                return parentNavigation;
            }
        }
        return navigation;
    }

    /**
     * 生成内页左侧导航列表
     * @param navigation
     * @return
     */
    public Navigation initSecondaryNavigation(Navigation navigation) {
        if (navigation.getParentId() != 0) {
            // 查询当前导航的父菜单
            Navigation parentNavigation = navigationDao.findCurrentParent(navigation.getParentId());
            // 查询当前导航的兄弟菜单
            List<Navigation> brotherNavigations = navigationDao.findBrotherByNavigation(navigation.getParentId(), navigation.getId());
            // 父菜单中加入兄弟菜单
            parentNavigation.setChildren(brotherNavigations);
            // 指定位置加入当前菜单
            parentNavigation.getChildren().add(navigation.getSeq()-1,navigation);
            if (parentNavigation.getParentId() != 0){
                this.findCurrentParent(parentNavigation);
            } else {
                return parentNavigation;
            }
        }
        return navigation;
    }


}
