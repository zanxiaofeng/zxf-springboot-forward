package zxf.springboot.forwardservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zxf.springboot.forwardservice.support.httpforward.HttpForwarder;


@RestController
@RequestMapping("/forward")
public class ForwardController {
    @Autowired
    @Qualifier("contentServiceForwarder")
    HttpForwarder contentServiceForwarder;

    @RequestMapping("/content/**")
    public ResponseEntity<byte[]> forwardAll(RequestEntity<byte[]> requestEntity) {
        return contentServiceForwarder.forward(requestEntity);
    }
}
