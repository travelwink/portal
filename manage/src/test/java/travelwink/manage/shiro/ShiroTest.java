package travelwink.manage.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class ShiroTest {

    //realm
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser(){
        // realm中加入账号(用户名, 密码, 角色1, 角色2)
        simpleAccountRealm.addAccount("admin","admin","admin","user");
    }

    @Test
    public void testShiro(){

        // 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        // 传入登陆用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
        subject.login(token);

        System.out.println("是否认证(isAuthenticated)：" + subject.isAuthenticated());

        // 验证角色授权
        subject.checkRole("admin");

        subject.checkRoles("admin", "user");

        // 登出
        subject.logout();

        System.out.println("是否认证(isAuthenticated)：" + subject.isAuthenticated());
    }
}
