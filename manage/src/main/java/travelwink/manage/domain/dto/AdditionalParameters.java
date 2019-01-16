package travelwink.manage.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdditionalParameters {
    private int id;
    private List<NavigationTree> children;

    public AdditionalParameters(int id, List<NavigationTree> children) {
        this.id = id;
        this.children = children;
    }
}
