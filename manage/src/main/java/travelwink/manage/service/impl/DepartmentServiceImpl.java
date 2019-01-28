package travelwink.manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import travelwink.manage.dao.DepartmentDao;
import travelwink.manage.domain.entity.*;
import travelwink.manage.service.DepartmentService;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    @Transactional
    public int add(Department department) {
        int resultCount = departmentDao.create(department);
        List<Navigation> navigations = department.getNavigations();
        List<Menu> menus = department.getMenus();

        int navigationRelResults = 0;
        for (Navigation navigation : navigations) {
            DepartmenuNavigationRel deptNavRel = new DepartmenuNavigationRel();
            deptNavRel.setFkDepartmentId(department.getId());
            deptNavRel.setFkNavigationId(navigation.getId());
            int relResult = departmentDao.addNavigationRel(deptNavRel);
            if (1 == relResult) {
                navigationRelResults++;
            }
        }

        int menuRelResults = 0;
        for (Menu menu : menus) {
            DepartmentMenuRel deptMenuRel = new DepartmentMenuRel();
            deptMenuRel.setFkDepartmentId(department.getId());
            deptMenuRel.setFkMenuId(menu.getId());
            int relResult = departmentDao.addMenuRel(deptMenuRel);
            if (1 == relResult) {
                menuRelResults++;
            }
        }

        if (1 == resultCount && navigationRelResults == navigations.size() && menuRelResults == menus.size()) {
            return resultCount;
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<Department> findAllForSelect() {
        return departmentDao.findAllForSelect();
    }

    @Override
    public Department findById(int id) {
        Department department = departmentDao.findById(id);
        log.info(department.toString());
        return department;
    }

    @Override
    public Department findSimpleDataById(int id) {
        return departmentDao.findSimpleDataById(id);
    }
}
