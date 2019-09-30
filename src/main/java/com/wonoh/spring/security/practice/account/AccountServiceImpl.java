package com.wonoh.spring.security.practice.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Account signUp(AccountDto accountDto) {


        Account account = accountDto.toEntity();
        account.encodePassword(passwordEncoder);
        return accountRepository.save(account);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByName(username);
        if(account == null){
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(account.getName())
                .password(account.getPassword())
                .build();
    }
}
