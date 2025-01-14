package com.mycompany.jakartasec.controller;


import com.mycompany.jakartasec.model.UserCredentials;
import com.mycompany.jakartasec.service.UserService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;

import java.io.Serializable;
import java.security.Principal;

@Named
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    private UserService userService;

    @Inject
    private SecurityContext securityContext;

    private UserCredentials user;

    public boolean isLogged() {
        return getUsername() != null;
    }

    public String getUsername() {
        if (user != null) {
            return user.getUsername();
        }

        Principal principal = securityContext.getCallerPrincipal();
        if (principal != null) {
            user = userService.findByUsername(principal.getName());
        }

        return user != null ? user.getUsername() : null;
    }
}
