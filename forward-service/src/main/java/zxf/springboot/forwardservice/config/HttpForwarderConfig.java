package zxf.springboot.forwardservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zxf.springboot.forwardservice.support.httpforward.HttpForwardUrlForward;
import zxf.springboot.forwardservice.support.httpforward.HttpForwarder;

import static zxf.springboot.forwardservice.support.httpforward.HttpForwardPostProcessor.defaultPostProcess;
import static zxf.springboot.forwardservice.support.httpforward.HttpForwardPreProcessor.defaultPreProcess;
import static zxf.springboot.forwardservice.support.httpforward.HttpForwardPreProcessor.urlPreProcess;

@Configuration
public class HttpForwarderConfig {
    private final HttpForwardUrlForward contentServiceUrlForward = HttpForwardUrlForward.create(
            "http://localhost:8080", "/forward/content/([\\w-./?%&=]*)", "/$1");

    @Bean(name="contentServiceForwarder")
    public HttpForwarder contentServiceForwarder() {
        return new HttpForwarder(defaultPreProcess().andThen(urlPreProcess(contentServiceUrlForward)), defaultPostProcess());
    }
}
