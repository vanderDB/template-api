package com.dazgs.templateapi.web.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @GetMapping("/test")
    public ResponseEntity<String> getTestUserName() {
        return new ResponseEntity<>("Vlad", HttpStatus.OK);
    }
}
