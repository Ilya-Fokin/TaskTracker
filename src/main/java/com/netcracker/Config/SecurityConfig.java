package com.netcracker.Config;

import com.netcracker.Entity.User;
import com.netcracker.Service.SecurityService.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/").authenticated()
                .anyRequest().permitAll()

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")

                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/sign_in")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/login?error");

        http.csrf().disable();
    }


}
