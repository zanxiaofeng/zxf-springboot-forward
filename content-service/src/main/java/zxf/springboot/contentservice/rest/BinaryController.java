package zxf.springboot.contentservice.rest;

import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/binary")
public class BinaryController {
    @GetMapping("/zip")
    public ResponseEntity<UrlResource> getZip() throws FileNotFoundException {
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/zip"))
                .body(new UrlResource(ResourceUtils.getURL("classpath:files/example.zip")));
    }

    @PostMapping("/zip")
    public ResponseEntity<byte[]> postZip(RequestEntity<byte[]> zip) {
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/zip")).body(zip.getBody());
    }

    @GetMapping("/bad")
    public ResponseEntity<String> bad() {
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("\"binary failed\"");
    }
}
