package cn.eagle.spring.boot.web.config;

import cn.eagle.spring.webmvc.config.EagleWebConfigure;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(EagleWebConfigure.class)
public class EagleSpringBootWebAutoConfigure {
}
