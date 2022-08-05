package zxf.springboot.contentservice.rest;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/text")
public class TextController {
    @GetMapping("/json")
    public ResponseEntity<String> getJson() {
        return ResponseEntity.ok("{'state': 'ok'}");
    }

    @PostMapping("/json")
    public ResponseEntity<String> postJson(RequestEntity<String> json) {
        return ResponseEntity.ok(json.getBody());
    }

    @GetMapping("/xml")
    public ResponseEntity<String> getXml() {
        return ResponseEntity.ok("<abc>davis</abc>");
    }

    @PostMapping("/xml")
    public ResponseEntity<String> postXml(RequestEntity<String> xml) {
        return ResponseEntity.ok(xml.getBody());
    }

    @GetMapping("/bad")
    public ResponseEntity<String> bad() {
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("{text failed}");
    }
}
