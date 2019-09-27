package com.wonoh.spring.security.practice.config;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YmlEncryptorConfig {

    @Bean("ymlEncryptor")
    public StandardPBEStringEncryptor standardPBEStringEncryptor(){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();
        config.setPassword("!@#$%^");
        config.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setConfig(config);
        return encryptor;
    }

}
