package com.dyplom.controller;

import com.dyplom.domain.Role;
import com.dyplom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/list")
  public String list(Model model) {
    model.addAttribute("users",userService.shawAll());
    return "user/list";
  }

  @PostMapping("/add")
  public String add(final Role role, final String username, final String password){
    userService.add(role,username,password);
    return "redirect:/users/list";
  }
}
