package com.guiportifolio.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    // adicionando suporte aos users via JDBC - TABELAS CUSTOM
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // query user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");


        // query authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");


        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/employees/list").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/employees/list").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/employees/list").hasRole("ADMIN")
        );
        // user HTTP Basic auth
        http.httpBasic();

        // desabilitar CSRF (Cross Site Request Forgery)
        // no geral, não é necessário para REST APIs stateless que usem POST, PUT, DELETE e/ou PATCH

        http.csrf().disable();


        return http.build();
    }

/*
    // adicionando suporte aos users via JDBC - TABELAS PADRÃO SPRING SECUTIRY
    // Tabela users -> "username", "password", "enabled"
    // Tabela authorities -> "username", "authority"

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
    }
*/



/*
    // Usuários salvos em memória, no próprio código java
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
 */
}
