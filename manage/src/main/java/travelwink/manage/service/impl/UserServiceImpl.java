package travelwink.manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import travelwink.manage.common.Constant;
import travelwink.manage.dao.MenuDao;
import travelwink.manage.dao.UserDao;
import travelwink.manage.domain.entity.Menu;
import travelwink.manage.domain.entity.User;
import travelwink.manage.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MenuDao menuDao;

    @Override
    public User loadUserByUsername(String name) {
        User user = userDao.loadUserByUsername(name);
        List<Menu> menuPermissions = user.getDepartment().getMenus();

        List<Menu> viewMenuList = new ArrayList<Menu>();

        menuPermissions.forEach(menu -> {
            if (0 == menu.getParentId()){
                viewMenuList.add(menu);
            } else {
                viewMenuList.forEach(viewMenu -> {
                    if (viewMenu.getId() == menu.getParentId()) {
                        if (null == viewMenu.getSubMenus()){
                            viewMenu.setSubMenus(new ArrayList<Menu>());
                            viewMenu.getSubMenus().add(menu);
                        } else {
                            viewMenu.getSubMenus().add(menu);
                        }

                    }
                });
            }
        });
        user.getDepartment().setMenus(viewMenuList);
        return user;
    }

    @Override
    public int add(User user) {
        String encodePassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodePassword);
        return userDao.create(user);
    }

    @Override
    public int modify(User user) {
        int resultCount = userDao.update(user);
        return resultCount;
    }


    @Override
    public int delete(int id){
        return userDao.delete(id);
    }

    @Override
    public User findById(int id) {
        User user = userDao.findById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
