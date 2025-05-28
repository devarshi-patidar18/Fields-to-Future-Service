package com.apis.Fields_To_Future_Services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apis.Fields_To_Future_Services.Jwt.JwtHelper;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtHelper jwtHelper;

    public SecurityConfig(JwtHelper jwtHelper) {
        System.out.println("SecurityConfig initialized ------------------------- in constructor");
        this.jwtHelper = jwtHelper;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("SecurityFilterChain initialized ------------------------- in securityFilterChain method");
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> {
                auth
                    .requestMatchers("/login","/user/register").permitAll()
                    .requestMatchers("/loan/create").authenticated();
            })
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtHelper, UsernamePasswordAuthenticationFilter.class);
            System.out.println("SecurityFilterChain configured ------------------------- in securityFilterChain method");
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        System.out.println("PasswordEncoder initialized ------------------------- in passwordEncoder method");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration conf) throws Exception {
        System.out.println("AuthenticationManager initialized ------------------------- in authenticationManager method");
        return conf.getAuthenticationManager();
    }
}
