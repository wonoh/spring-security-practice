package com.wonoh.spring.security.practice.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByName(String username);
}
