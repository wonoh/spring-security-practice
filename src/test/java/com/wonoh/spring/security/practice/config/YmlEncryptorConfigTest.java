package com.wonoh.spring.security.practice.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class YmlEncryptorConfigTest {

    @Value("${spring.datasource.password}")
    private String password;

    @Qualifier(value = "ymlEncryptor")
    @Autowired
    private StandardPBEStringEncryptor encryptor;

    private static final String ENCRYPTED_PASSWORD = "utofG6dMNVzVwmuq2bSFGLxRqUgwi2mM0q/TIvmfUYiRkQ1h0DGVqA==";

    @Test
    public void encryptor객체_가져오기(){
        assertNotNull(this.encryptor);
    }

    @Test
    public void 복호화_테스트(){

        final String decryptedPassword = encryptor.decrypt(ENCRYPTED_PASSWORD);
        assertThat(decryptedPassword,is(this.password));

    }

}