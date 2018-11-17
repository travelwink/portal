package travelwink.manage.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {
    private int userId;
    private String userName;
    private String password;
    private String nickName;
    private String avatar;
    private String email;
    private String mobile;
    private int status;
    private Date createDate;
    private Date updateDate;
    private Date latestSignIn;
}
