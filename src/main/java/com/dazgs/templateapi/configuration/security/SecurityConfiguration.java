package com.dazgs.templateapi.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("myadmin").password("myadminpassword").roles("AADMIN").build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("myuser").password("myuserpassword").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }
}
