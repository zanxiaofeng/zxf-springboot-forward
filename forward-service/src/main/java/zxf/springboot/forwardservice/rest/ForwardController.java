package zxf.springboot.forwardservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zxf.springboot.forwardservice.support.httpforward.HttpForwarder;


@RestController
public class ForwardController {
    @Autowired
    HttpForwarder contentServiceForwarder;

    @RequestMapping("/forward/**")
    public ResponseEntity<byte[]> forwardAll(RequestEntity<byte[]> requestEntity) {
        return contentServiceForwarder.forward(requestEntity);
    }
}
