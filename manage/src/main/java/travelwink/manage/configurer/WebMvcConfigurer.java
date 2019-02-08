package travelwink.manage.configurer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import travelwink.manage.conversion.ContentTypeFormatter;
import travelwink.manage.conversion.DepartmentFormatter;
import travelwink.manage.conversion.MenuFormatter;
import travelwink.manage.conversion.NavigationFormatter;
import travelwink.manage.domain.entity.ContentType;

@Configuration
@EnableAutoConfiguration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addFormatter(departmentFormatter());
        registry.addFormatter(navigationFormatter());
        registry.addFormatter(menuFormatter());
        registry.addFormatter(contentTypeFormatter());
    }

    @Bean
    public DepartmentFormatter departmentFormatter() {
        return new DepartmentFormatter();
    }

    @Bean
    public NavigationFormatter navigationFormatter() {
        return new NavigationFormatter();
    }

    @Bean
    public MenuFormatter menuFormatter(){
        return new MenuFormatter();
    }

    @Bean
    public ContentTypeFormatter contentTypeFormatter() {
        return new ContentTypeFormatter();
    }

}
