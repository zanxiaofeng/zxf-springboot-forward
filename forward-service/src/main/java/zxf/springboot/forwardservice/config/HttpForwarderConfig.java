package zxf.springboot.forwardservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zxf.springboot.forwardservice.support.httpforward.HttpForwarder;

@Configuration
public class HttpForwarderConfig {
    @Bean
    public HttpForwarder contentServiceForwarder(){
        return null;
    }
}
