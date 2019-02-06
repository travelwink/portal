package travelwink.manage.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class File extends BaseEntity{
    int id;
    String url;
    Date createDate;
}
