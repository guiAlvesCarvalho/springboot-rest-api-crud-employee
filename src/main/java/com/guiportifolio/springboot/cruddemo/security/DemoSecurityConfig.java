package com.guiportifolio.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails user1 = User.builder()
                .username("user1")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails user3 = User.builder()
                .username("user3")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);

        // Com esta config o SpringSecurity não utilizará a senha do application.properties
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("ADMIN")
                );

        // user HTTP Basic auth
        http.httpBasic();

        // desabilitar CSRF (Cross Site Request Forgery)
        // no geral, não é necessário para REST APIs stateless que usem POST, PUT, DELETE e/ou PATCH

        http.csrf().disable();

        return http.build();

    }
}
