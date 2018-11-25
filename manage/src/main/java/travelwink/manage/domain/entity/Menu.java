package travelwink.manage.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
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
