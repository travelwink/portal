package travelwink.manage.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import travelwink.manage.common.Constant;

import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;

@Data
public class User extends BaseEntity implements UserDetails {
    private int id;
    @NotBlank(message = "用户编号不可为空")
    private String name;
    private String password;
    private String nickName;
    private String avatar;
    private String email;
    private String mobile;
    private Department department;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date latestSignIn;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (this.getStatus() == Constant.VALID) {
            return true;
        } else {
            return false;
        }
    }
}
