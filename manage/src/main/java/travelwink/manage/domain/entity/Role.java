package travelwink.manage.domain.entity;

import lombok.Data;

@Data
public class Role extends BaseEntity {
    private int roleId;
    private String roleName;
}
