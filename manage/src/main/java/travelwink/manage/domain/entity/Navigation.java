package travelwink.manage.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class Navigation extends BaseEntity{

    private int id;
    private String name;
    private int parentId;
    private int level;
    private int seq;
    private List<Navigation> subNavigation;
}
