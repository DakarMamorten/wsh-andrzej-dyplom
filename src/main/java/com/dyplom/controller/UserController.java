package com.dyplom.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class UserController {

  @GetMapping
  public String home() {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    System.out.println(authentication.getAuthorities());
    return "/index";
  }
}
