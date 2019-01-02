package travelwink.manage.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User extends BaseEntity{
    private int id;
    private String name;
    private String password;
    private String nickName;
    private String avatar;
    private String email;
    private String mobile;
    private Department department;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date latestSignIn;
}
