package com.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsFromDbRole implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;


     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             //return User.withUsername("1234").password(passwordEncoder.encode("1234")).roles("user").build();
         return new User("1", passwordEncoder.encode("1"), getRole());
    }


    private Collection<? extends GrantedAuthority> getRole() {
         List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("user"));
        return list;
    }

}
