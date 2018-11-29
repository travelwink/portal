package travelwink.manage.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin()
                .loginPage("/login.html")
                .and()
                .authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/**/*.js",
                        "/**/*.css",
                        "/**/*.otf",
                        "/**/*.svg",
                        "/**/*.tff",
                        "/**/*.woff",
                        "/**/*.jpg",
                        "/**/*.png",
                        "/**/*.gif").permitAll()
                .anyRequest()
                .authenticated();
    }
}
