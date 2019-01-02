package travelwink.manage.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createDate;

    private String updateBy;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date updateDate;

    private int status;
}
