package travelwink.manage.domain.dto;

import lombok.Data;


@Data
public class NavigationTree {

    private String name;
    private String type;
    private AdditionalParameters additionalParameters;

}
