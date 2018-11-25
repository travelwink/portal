package travelwink.manage.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class User extends BaseEntity{
    private int userId;
    private String userName;
    private String password;
    private String nickName;
    private String avatar;
    private String email;
    private String mobile;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date latestSignIn;
}
