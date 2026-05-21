package com.example.calculator.controller;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class InsecureDemoController {

    @GetMapping("/run-command")
    public ResponseEntity<String> runCommand(@RequestParam String command) throws IOException {
        Runtime.getRuntime().exec(command);
        return ResponseEntity.ok("Command submitted: " + command);
    }
}
