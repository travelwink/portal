package travelwink.home.entity;

import lombok.Data;

import java.util.List;

@Data
public class Page {
    int id;
    String keywords;
    Navigation navigation;
    String headImg;
    String headImgVertical;
    int customerForm;
    int footerLinkStyle;
    List<Paragraph> paragraphs;
    List<FooterLink> footerLinks;
}
