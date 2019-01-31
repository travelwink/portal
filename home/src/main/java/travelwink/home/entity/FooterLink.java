package travelwink.home.entity;

import lombok.Data;

@Data
public class FooterLink {
    int id;
    ContentType contentType;
    String title;
    String desc;
    File file;
}
