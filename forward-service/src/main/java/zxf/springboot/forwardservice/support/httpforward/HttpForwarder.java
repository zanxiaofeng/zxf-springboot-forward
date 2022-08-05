package zxf.springboot.forwardservice.support.httpforward;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public class HttpForwarder {
    private final HttpForwardPreProcessor httpForwardPreProcessor;
    private final HttpForwardPostProcessor httpForwardPostProcessor;

    public HttpForwarder(HttpForwardPreProcessor httpForwardPreProcessor, HttpForwardPostProcessor httpForwardPostProcessor) {
        this.httpForwardPreProcessor = httpForwardPreProcessor;
        this.httpForwardPostProcessor = httpForwardPostProcessor;
    }

    public ResponseEntity<byte[]> forward(RequestEntity<byte[]> requestEntity) {
        return null;
    }
}
