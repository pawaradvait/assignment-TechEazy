package com.TechEazy.config;

import com.TechEazy.filter.JWTTokenGeneratorFilter;
import com.TechEazy.filter.JWTTokenValidatorFilter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class Websecurity {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/api/student").permitAll()
                        .requestMatchers("/api/login").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/api/getStudent/id").hasRole("ADMIN")
                        .requestMatchers("/api/subject").hasRole("ADMIN")
                        .requestMatchers("/api/addstudentTosubject").hasRole("ADMIN")
                        .requestMatchers("/api/getAllStudents").hasRole("ADMIN")
                        .requestMatchers("/api/getAllSubject").hasRole("ADMIN")
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()

        );
        http.sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class);
        http.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class);

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.headers(header -> header.frameOptions(frameOptions -> frameOptions.sameOrigin()));

        http.csrf(csrf ->csrf.disable());
        return http.build();
    }


    @Bean
    AuthenticationManager authenticationManager(CustomUserDetailService customUserDetailService,PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
