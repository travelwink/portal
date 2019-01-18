package travelwink.manage.configurer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import travelwink.manage.conversion.DepartmentFormatter;

@Configuration
@EnableAutoConfiguration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addFormatter(departmentFormatter());
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/signIn").setViewName("login");
//        registry.addViewController("/").setViewName("index");
//    }

    @Bean
    public DepartmentFormatter departmentFormatter() {
        return new DepartmentFormatter();
    }

}
