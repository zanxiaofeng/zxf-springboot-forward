package zxf.springboot.forwardservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import zxf.springboot.forwardservice.support.httpforward.HttpForwardUrlForward;
import zxf.springboot.forwardservice.support.httpforward.HttpForwarder;

import static java.nio.charset.StandardCharsets.UTF_8;
import static zxf.springboot.forwardservice.support.httpforward.HttpForwardPostProcessor.defaultPostProcess;
import static zxf.springboot.forwardservice.support.httpforward.HttpForwardPreProcessor.*;

@Configuration
public class HttpForwarderConfig {
    private final HttpForwardUrlForward contentServiceUrlForward = HttpForwardUrlForward.create(
            "http://localhost:8080", "/forward/content/([\\w-./?%&=]*)", "/$1");
    private final String basicAuthHeaderValue = HttpHeaders.encodeBasicAuth("zxf", "zxf", UTF_8);

    @Bean(name = "contentServiceForwarder")
    public HttpForwarder contentServiceForwarder() {
        return new HttpForwarder(defaultPreProcess()
                .andThen(urlPreProcess(contentServiceUrlForward))
                .andThen(extraHeaderPreProcess(HttpHeaders.AUTHORIZATION, basicAuthHeaderValue)),
                defaultPostProcess());
    }
}
