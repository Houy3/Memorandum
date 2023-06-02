package os.memorandum.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.memorandum.dto.TestDto;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/get")
    public ResponseEntity<TestDto> get() {

        throw  new RuntimeException("fdfdf");
//        return ResponseEntity.ok(new TestDto("sdsds"));
    }
}
