package com.vinod.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Step 1: Authentication logic.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("username")
                .password("password")
                .roles("USER")
                .and()
                .withUser("vinod")
                .password("vinod")
                .roles("ADMIN");
    }

    /**
     * Step 2: Authorization logic.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin")
                .hasAnyRole("ADMIN")
                .antMatchers("/user")
                .hasAnyRole("ADMIN","USER")
                .antMatchers("/")
                .permitAll()
                .and()
                .formLogin();
    }

    /**
     * Password encoder - From Spring 2.0 its compulsory to use any type of password encoding compulsory.
     *
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
