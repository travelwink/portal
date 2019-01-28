package travelwink.manage.conversion;

import org.springframework.format.Formatter;
import travelwink.manage.domain.entity.Navigation;

import java.text.ParseException;
import java.util.Locale;

public class NavigationFormatter implements Formatter<Navigation> {

    @Override
    public Navigation parse(String id, Locale locale) throws ParseException {
        Navigation navigation = new Navigation();
        navigation.setId(Integer.valueOf(id));
        return navigation;
    }

    @Override
    public String print(Navigation navigation, Locale locale) {
        return (navigation != null ? navigation.toString() : "");
    }
}
