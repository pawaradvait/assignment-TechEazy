package com.TechEazy.config;

import com.TechEazy.model.Student;
import com.TechEazy.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student s= studentRepo.findByEmail(username);
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(s.getRole()));
        return new User(s.getEmail(), s.getPassword(), authorities);

    }
}
