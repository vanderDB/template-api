package com.dazgs.templateapi.web.controller.rest;

import com.dazgs.templateapi.core.domains.sql.User;
import com.dazgs.templateapi.core.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> getTestUserName() {
        return new ResponseEntity<>("TestName", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<User>> findAll(@PageableDefault(sort = "createdOn", direction = Sort.Direction.DESC) Pageable pageable) {

        var res = userService.findAll(pageable);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
