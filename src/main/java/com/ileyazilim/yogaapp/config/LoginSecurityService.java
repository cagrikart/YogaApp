package com.ileyazilim.yogaapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoginSecurityService {

    public static Authentication getAuthenticatedUserInfo() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
