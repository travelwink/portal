package travelwink.manage.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import travelwink.manage.domain.entity.Menu;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuDaoTest {

    @Autowired
    private MenuDao menuDao;

    @Test
    public void getFirstMenu(){
        List<Menu> menuList = menuDao.getFirstMenu();
        assertEquals(1,menuList.size());
    }


    @Test
    public void getMenu() {
        Menu menuDto = new Menu();
        menuDto.setId(1);
        List<Menu> menuList = menuDao.findAll();
        assertEquals(2,menuList.size());
    }

    @Test
    public void findByDeptId() {
        int deptId = 1;
        List<Menu> menus = menuDao.findByDeptId(deptId);
        assertEquals(3, menus.size());
    }


}