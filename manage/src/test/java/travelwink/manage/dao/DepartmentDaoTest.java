package travelwink.manage.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import travelwink.manage.domain.entity.Department;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentDaoTest {

    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void findAll() {
        List<Department> departments = departmentDao.findAll();
        assertEquals(3,departments.size());
    }


    @Test
    public void getMenuListById() {
    }

    @Test
    public void findById1() {
        int deptId = 1;
        Department department = departmentDao.findById(deptId);
        assertEquals(3, department.getMenus().size());
    }
}