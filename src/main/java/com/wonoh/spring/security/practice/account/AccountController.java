package com.wonoh.spring.security.practice.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AccountController {

    @GetMapping("/user")
    public String home(){
        return "index";
    }

    @PostMapping("/login-success")
    public String loginSuccess(Model model,Principal principal){

        model.addAttribute("username",principal.getName());
        return "login-success";

    }
}
