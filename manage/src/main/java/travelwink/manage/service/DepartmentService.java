package travelwink.manage.service;

import travelwink.manage.domain.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    List<Department> findAllWithMenu();

    Department findById(int id);
}
