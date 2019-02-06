package travelwink.manage.domain.entity;

import lombok.Data;

@Data
public class Paragraph extends BaseEntity{
    int id;
    String text;
    int type;
    String style;
    int seq;
}
