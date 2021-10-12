package com.dazgs.templateapi.configuration.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthorizationService {

    public boolean authorize(Authentication auth) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String userName = userDetails.getUsername();

        return userName.equals("admin@dazg.com");
    }
}
