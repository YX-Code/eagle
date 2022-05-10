package cn.eagle.spring.webmvc.config;

import cn.canary.core.AbstractJsonDataExtractor;
import cn.eagle.spring.webmvc.converter.CustomMappingJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author yaojianxing
 */
@SuppressWarnings("rawtypes")
@Configuration
public class EagleWebConfigure implements WebMvcConfigurer {
    
    private final AbstractJsonDataExtractor abstractJsonDataExtractor;
    
    public EagleWebConfigure(AbstractJsonDataExtractor abstractJsonDataExtractor) {
        this.abstractJsonDataExtractor = abstractJsonDataExtractor;
    }
    
    /**
     * 配置消息转换器
     *
     * @param converters Spring中已配置的转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //Spring默认对Json数据的处理是使用Jackson，如果定义了Json数据提取器，需要覆盖原有配置
        if (abstractJsonDataExtractor != null) {
            converters.removeIf(converter -> converter instanceof AbstractJackson2HttpMessageConverter);
            CustomMappingJackson2HttpMessageConverter messageConverter = new CustomMappingJackson2HttpMessageConverter();
            messageConverter.setAbstractJsonDataExtractor(abstractJsonDataExtractor);
            converters.add(messageConverter);
        }
    }
}