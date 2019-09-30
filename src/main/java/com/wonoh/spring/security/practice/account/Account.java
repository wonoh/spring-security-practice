package com.wonoh.spring.security.practice.account;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(value = AuditingEntityListener.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "password",nullable = false)
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Builder
    public Account(String name,String password){
        this.name = name;
        this.password = password;
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }


}
