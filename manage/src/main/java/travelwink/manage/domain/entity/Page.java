package travelwink.manage.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class Page extends BaseEntity {
    int id;
    Navigation navigation;
    String headImg;
    String headImgVertical;
    int customerForm;
    int footerLinkStyle;
    List<Paragraph> paragraphs;
    List<FooterLink> footerLinks;
}
