package com.wonoh.spring.security.practice.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .mvcMatchers("","/","logout").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .successForwardUrl("/login-success");

        http.httpBasic();

        http.logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");

    }

    @Override
    public void configure(WebSecurity web) {

        //css/**" , "/js/**" , "/images/**" , "/webjars/**" , "/**favicon.ico"
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
