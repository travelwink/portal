package travelwink.manage.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin()
                .loginPage("/static/login.html")
                .and()
                .authorizeRequests()
                .antMatchers("/static/login.html").permitAll()
                .anyRequest()
                .authenticated();
    }
}
