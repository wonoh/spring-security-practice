package com.wonoh.spring.security.practice.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/user")
    public ResponseEntity home(Principal principal){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok(principal);
    }


    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.signUp(accountDto));
    }




}
