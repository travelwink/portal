package travelwink.manage.domain.entity;

import lombok.Data;

@Data
public class DepartmenuNavigationRel extends BaseEntity {
    int id;
    int fkDepartmentId;
    int fkNavigationId;
}
