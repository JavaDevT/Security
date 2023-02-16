package com.security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    public String[] adminAccess = {"/admin-login", "/admin-dashboard",};
    public String[] userAccess = {"/user-login", "/user-dashboard", "/user"};

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // UserDetails userDetailsService = User.withUsername("thavam").password(passwordEncoder.encode("123456")).roles("user").build();
       //    return new InMemoryUserDetailsManager(userDetailsService);
       return new UserDetailsFromDb();
    }

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers("/register", "/dashboard").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers(userAccess).hasRole("user")
                .and()
                .authorizeHttpRequests().requestMatchers(adminAccess).hasRole("ADMIN").anyRequest().authenticated().and().formLogin()
                  .and()
                .sessionManagement().invalidSessionUrl("/register");


        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}