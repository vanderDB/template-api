package com.dazgs.templateapi.core.service;

import com.dazgs.templateapi.core.domains.sql.Account;
import com.dazgs.templateapi.core.repository.sql.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findByUsername(String username) {

        return accountRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Account with provided username not found"));
    }

    public Page<Account> findAll(Pageable pageable) {

        return accountRepository.findAll(pageable);
    }
}
