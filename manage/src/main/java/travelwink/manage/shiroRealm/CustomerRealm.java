package travelwink.manage.shiroRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import travelwink.manage.dao.UserDao;
import travelwink.manage.domain.entity.User;

public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 授权逻辑
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        User user = new User();

        user.setUserName("admin");

        // 认证逻辑
        // 从主体传入的token中获取用户名
        String userName = (String)token.getPrincipal();

        String password = userDao.getUser(user).get(0).getPassword();

        return null;
    }
}
