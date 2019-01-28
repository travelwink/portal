package travelwink.manage.domain.entity;

import lombok.Data;

@Data
public class DepartmentMenuRel extends BaseEntity{
    int id;
    int fkDepartmentId;
    int fkMenuId;
}
