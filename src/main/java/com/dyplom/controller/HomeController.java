package com.dyplom.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String home() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdministrator= authentication.getAuthorities().
                stream().
                anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ADMINISTRATOR"));

        return hasRoleAdministrator ? "/admin/index" : "/user/index";
    }
}
