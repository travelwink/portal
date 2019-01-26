package travelwink.manage.domain.entity;

import lombok.Data;

import java.util.List;

/**
 * 后台管理菜单实体类
 */
@Data
public class Menu extends BaseEntity{
    private int id;
    private String name;
    private int parentId;
    private int priority;
    private String icon;
    private String href;
    private int level;
    private List<Menu> subMenus;
}
