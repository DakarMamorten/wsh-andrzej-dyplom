package com.dyplom.controller;

import com.dyplom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/list")
  @PreAuthorize("hasAuthority('ADMINISTRATOR')")
  public String list(Model model) {
    model.addAttribute("users",userService.shawAll());
    return "user/list";
  }
}
