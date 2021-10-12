package com.dazgs.templateapi.web.controller.rest;

import com.dazgs.templateapi.core.domains.sql.Account;
import com.dazgs.templateapi.core.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('ADMIN') AND @customAuthorizationService.authorize(authentication)")
    public ResponseEntity<String> getTestAccountName() {
        return new ResponseEntity<>("TestName", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Account>> findAll(@PageableDefault(sort = "createdOn", direction = Sort.Direction.DESC) Pageable pageable) {

        var res = accountService.findAll(pageable);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
