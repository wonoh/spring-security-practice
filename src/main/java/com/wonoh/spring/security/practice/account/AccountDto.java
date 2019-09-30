package com.wonoh.spring.security.practice.account;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    private String name;
    private String password;

    public Account toEntity(){
        return Account.builder()
                .name(this.name)
                .password(this.password)
                .build();

    }

}
