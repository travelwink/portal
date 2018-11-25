package travelwink.manage.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class JdbcRealmTest {

    @Test
    public void jdbcRealmTest(){
        JdbcRealm jdbcRealm = new JdbcRealm();
        // 开启默认关闭状态的权限联查功能
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "SELECT password FROM t_user WHERE user_name = ?";
        jdbcRealm.setPermissionsQuery(sql);

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        // 传入登陆用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
        subject.login(token);

        System.out.println("是否认证(isAuthenticated)：" + subject.isAuthenticated());

    }
}
