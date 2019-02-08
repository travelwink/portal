package travelwink.manage.conversion;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import travelwink.manage.domain.entity.ContentType;
import travelwink.manage.service.ContentTypeService;

import java.text.ParseException;
import java.util.Locale;

public class ContentTypeFormatter implements Formatter<ContentType> {

    @Autowired
    ContentTypeService contentTypeService;

    @Override
    public ContentType parse(String id, Locale locale) throws ParseException {
        if (StringUtils.isNotBlank(id)){
            int contentTypeId = Integer.valueOf(id);
            return this.contentTypeService.findById(contentTypeId);
        }
        return null;
    }

    @Override
    public String print(ContentType contentType, Locale locale) {
        return (contentType != null ? contentType.toString() : "");
    }
}
