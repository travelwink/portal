package travelwink.manage.domain.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Department extends BaseEntity {
    private int id;

    @NotBlank(message = "部门名称不可为空")
    @Length(max = 16, min = 2, message = "部门名称长度只能在2到16字符之间")
    private String name;
    private int parentId;
    private int level;

    @NotNull(message = "顺序不可为空")
    private int seq;

    private int status;

    @Length(max = 150, message = "备注长度不能超过150字符")
    private String remark;
}
