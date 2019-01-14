package travelwink.manage.service;

import travelwink.manage.domain.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    Department findById(int id);
}
