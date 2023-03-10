package com.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDetailsFromDb implements AuthenticationProvider /*UserDetailsService*//*, AuthenticationProvider*/ {
    @Autowired
    PasswordEncoder passwordEncoder;


    // @Override
/*
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ///  return User.withUsername("thavam").password(passwordEncoder.encode("123456")).roles("user").build();

        return new User("thavam", passwordEncoder.encode("1234"), getRole());
    }
*/

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        String password = token.getCredentials().toString();
        return new UsernamePasswordAuthenticationToken(username, password, getRole());

    }

    private Collection<? extends GrantedAuthority> getRole() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("user"));
        return list;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
