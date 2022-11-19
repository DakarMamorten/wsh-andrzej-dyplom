package com.dyplom.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@UtilityClass
public class UserUtil {
    public static String getAuthorizedUserName() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Object principal = authentication.getPrincipal();
        if (!principal.toString().equals("anonymousUser")) {
            final User userAuth = (User) principal;
            return userAuth.getUsername();
        }
        return "";
    }
}
