package travelwink.home.entity;

import lombok.Data;

import java.util.List;

@Data
public class Navigation {
    private int id;
    private String name;
    private int parentId;
    private int level;
    private String url;
    private List<Navigation> children;
}
