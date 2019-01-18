package travelwink.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import travelwink.manage.common.Constant;
import travelwink.manage.domain.dto.AdditionalParameters;
import travelwink.manage.domain.dto.NavigationTree;
import travelwink.manage.domain.entity.Navigation;
import travelwink.manage.service.NavigationService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/navigation")
public class NavigationController {

    @Autowired
    NavigationService navigationService;

    @GetMapping
    public String initPage(Navigation navigation, Model model) {
        List<Navigation> navigationList =  navigationService.findAll();
        List<NavigationTree> navigationTrees = recursiveTreeData(navigationList);
        model.addAttribute("navigationTrees", navigationTrees);
        return "page/navigation";
    }

    /**
     * Recursion tree data for fuelux tree constructor method
     * @return List<NavigationTree>
     */
    public List<NavigationTree> recursiveTreeData(List<Navigation> navigationList) {
        if(null != navigationList || !navigationList.isEmpty()) {
            List<NavigationTree> navigationTrees = new ArrayList<NavigationTree>();
            for(Navigation navigation : navigationList) {
                NavigationTree navigationTree = new NavigationTree();
                navigationTree.setName(navigation.getName());
                List<Navigation> subNavigationList = navigation.getSubNavigation();
                if (null != subNavigationList && !subNavigationList.isEmpty()) {
                    navigationTree.setType(Constant.NAVIGATION_FOLDER_TYPE);
                    navigationTree.setAdditionalParameters(
                            new AdditionalParameters(navigation.getId(), recursiveTreeData(subNavigationList)));
                } else {
                    navigationTree.setType(Constant.NAVIGATION_ITEM_TYPE);
                }
                navigationTrees.add(navigationTree);
            }
            return navigationTrees;
        } else {
            return null;
        }
    }

}
