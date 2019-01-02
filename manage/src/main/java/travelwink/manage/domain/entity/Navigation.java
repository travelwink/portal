package travelwink.manage.domain.entity;

import lombok.Data;

@Data
public class Navigation extends BaseEntity{

    private int id;
    private String name;
    private int level;
    private int seq;
}
