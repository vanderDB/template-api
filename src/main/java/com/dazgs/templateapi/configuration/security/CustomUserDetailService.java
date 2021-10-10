package com.dazgs.templateapi.configuration.security;

import lombok.AllArgsConstructor;
import lombok.Data;
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

    private final List<Account> accountRepository = List.of(
            new Account("adminuser", "adminpass", "ADMIN"),
            new Account("simpluser", "simpleuserpass", "USER")
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var account = accountRepository.stream().filter(acc -> acc.username.equals(username)).findAny();
        if (account.isEmpty()) {
            throw new UsernameNotFoundException("");
        }

        var password = account.get().getPassword();
        var role = account.get().getRole();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        var user = new User(username, password, authorities);

        return user;
    }

    @Data
    @AllArgsConstructor
    class Account {

        private String username;
        private String password;
        private String role;
    }
}
