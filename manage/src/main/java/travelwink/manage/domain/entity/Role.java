package travelwink.manage.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Role extends BaseEntity {
    private int roleId;
    private String roleName;
}
