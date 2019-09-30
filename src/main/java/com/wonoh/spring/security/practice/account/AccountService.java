package com.wonoh.spring.security.practice.account;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {

    @Transactional
    Account signUp(AccountDto accountDto);
}
