package travelwink.manage.conversion;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import travelwink.manage.domain.entity.Department;
import travelwink.manage.service.DepartmentService;

import java.util.Locale;

public class DepartmentFormatter implements Formatter<Department> {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public Department parse(String s, Locale locale) {
        if (StringUtils.isNotBlank(s)){
            int departmentId = Integer.valueOf(s);
            return this.departmentService.findById(departmentId);
        }
        return null;
    }

    @Override
    public String print(Department department, Locale locale) {
        return (department != null ? department.toString() : "");
    }
}
