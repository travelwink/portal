package travelwink.manage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelwink.manage.dao.DepartmentDao;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.service.DepartmentService;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

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
