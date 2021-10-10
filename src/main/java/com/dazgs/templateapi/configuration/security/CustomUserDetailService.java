package com.dazgs.templateapi.configuration.security;

import com.dazgs.templateapi.core.domains.sql.Account;
import com.dazgs.templateapi.core.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

//    private final List<Account> accountRepository = List.of(
//            new Account("adminuser", "{noop}adminpass", "ROLE_ADMIN"),
//            new Account("simpluser", "{noop}simpleuserpass", "ROLE_USER")
//    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        var account = accountRepository.stream().filter(acc -> acc.username.equals(username)).findAny();
//        if (account.isEmpty()) {
//            throw new UsernameNotFoundException("");
//        }

        Account existedAccount = accountService.findByUsername(username);

//        var password = account.get().getPassword();
//        var role = account.get().getRole();

        var password = existedAccount.getPassword();
        var role = existedAccount.getRole();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        var user = new User(username, password, authorities);

        return user;
    }

//    @Data
//    @AllArgsConstructor
//    class Account {
//
//        private String username;
//        private String password;
//        private String role;
//    }
}
