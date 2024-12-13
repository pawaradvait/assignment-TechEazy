package com.TechEazy.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class Websecurity {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/api/student").permitAll()
                        .requestMatchers("/api/subject").hasRole("STUDENT")
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                );

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.headers(header->header.frameOptions(frameoption ->frameoption.sameOrigin()));
        http.csrf(csrf ->csrf.disable());
        return http.build();
    }



    @Bean
    PasswordEncoder passwordEncoder(){
        return  PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
