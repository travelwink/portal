package travelwink.manage.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import travelwink.manage.service.UserService;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("name")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error=true")
//                    .loginProcessingUrl("/manage/user/login")
                    .permitAll()
                .and()
                    .logout().logoutSuccessUrl("/")
                .and()
                    .authorizeRequests()
                        .antMatchers(
                            "/css/**",
                                "/fonts/**",
                                "/images/**",
                                "/js/**"
                        )
                        .permitAll()
                .anyRequest().authenticated();

        httpSecurity.csrf().disable();
    }
}
