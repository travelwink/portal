package travelwink.manage.domain.entity;

import lombok.Data;

@Data
public class FooterLink extends BaseEntity {
    int id;
    ContentType contentType;
    String title;
    String desc;
    File file;
}
