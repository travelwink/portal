package travelwink.home.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Content {
    private int id;
    private ContentType contentType;
    private String title;
    private String description;
    private String pageUrl;
    private String fileUrl;
    private int homeLocation;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
}
