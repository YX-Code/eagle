package cn.eagle.spring.webmvc.converter;

import cn.canary.core.AbstractJsonDataExtractor;
import cn.canary.core.dto.response.SingleResponse;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.lang.reflect.Type;
@SuppressWarnings("rawtypes")
public class CustomMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    private AbstractJsonDataExtractor abstractJsonDataExtractor;
    
    @Override
    protected void writeInternal(Object object, @Nullable Type type, HttpOutputMessage outputMessage)
        throws IOException, HttpMessageNotWritableException {
        if (abstractJsonDataExtractor != null) {
            object = abstractJsonDataExtractor.toSingle(object);
            type = SingleResponse.class;
        }
        super.writeInternal(object,type,outputMessage);
    }
    
    public AbstractJsonDataExtractor getAbstractJsonDataExtractor() {
        return abstractJsonDataExtractor;
    }
    
    public void setAbstractJsonDataExtractor(AbstractJsonDataExtractor abstractJsonDataExtractor) {
        this.abstractJsonDataExtractor = abstractJsonDataExtractor;
    }
}
