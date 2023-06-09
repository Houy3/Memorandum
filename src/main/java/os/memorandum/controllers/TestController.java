package os.memorandum.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import os.memorandum.dto.test.NewTestDto;
import os.memorandum.dto.test.TestDto;
import os.memorandum.services.TestService;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @PostMapping()
    public ResponseEntity<TestDto> add(@Valid @RequestBody NewTestDto dto) {
        return ResponseEntity
                .ok(service.add(dto));
    }
}
