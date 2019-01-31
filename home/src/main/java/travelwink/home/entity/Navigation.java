package travelwink.home.entity;

import lombok.Data;

import java.util.List;

@Data
public class Navigation {
    private int id;
    private String name;
    private int parentId;
    private int level;
    private int seq;
    private String url;
    private String desc;
    private String imgUrl;
    private int linkStyle;
    private List<Navigation> children;
}
