package travelwink.manage.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Content extends BaseEntity{
    private int id;
    private ContentType contentType;
    private String no;
    private String title;
    private String description;
    private Page page;
    private String fileUrl;
    private int homeLocation;
}
