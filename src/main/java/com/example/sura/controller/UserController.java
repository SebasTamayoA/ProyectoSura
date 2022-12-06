package com.example.sura.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "api/user")

public class UserController {
    @GetMapping(value = "/test")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.status(HttpStatus.OK).body("Test Get");
    }

    @PostMapping(value = "/test")
    public ResponseEntity<String> testPost() {
        return ResponseEntity.status(HttpStatus.OK).body("Test Post");
    }

}
