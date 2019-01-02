package travelwink.manage.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu extends BaseEntity{
    private int menuId;
    private String menuName;
    private int parentMenuId;
    private int priority;
    private String icon;
    private String href;
    private int level;
    private List<Menu> subMenu;
}
