package travelwink.manage.domain.entity;

import lombok.Data;

@Data
public class Release {

    private int id;
    private String manageCode;
    private String title;
    private String subTitle;
    private boolean release;
}
