package travelwink.manage.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/manage/user/signIn")
//                .permitAll()
//                .and()
//                    .logout().logoutSuccessUrl("/login.html")
                .and()
                    .authorizeRequests().antMatchers(
                            "/css/**",
                            "/fonts/**",
                            "/images/**",
                            "/js/**"
                    ).permitAll().anyRequest().authenticated();
    }
}
