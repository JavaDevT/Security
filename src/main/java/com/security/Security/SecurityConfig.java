package com.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    public String[] adminAccess = {"/admin-login/**"};
    public String[] userAccess = {"/user-login/**"};
   // @Autowired
   // private JwtAuthenticationFilter jwtAuthFilter;

    /* @Bean
     public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
         // UserDetails userDetailsService = User.withUsername("thavam").password(passwordEncoder.encode("123456")).roles("user").build();
        //    return new InMemoryUserDetailsManager(userDetailsService);
        return new UserDetailsFromDbRole();
     }*/
     @Bean
    public AuthenticationProvider authenticationManagerBean() throws Exception {
        return new UserDetailsFromDb();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable().authorizeHttpRequests()
                .requestMatchers("/userauth/**").permitAll()
                 .anyRequest().authenticated()
                 .and()
                 .authenticationProvider(authenticationManagerBean());
               // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        //    .and()
        // .sessionManagement().invalidSessionUrl("/register");
        return http.build();
    }

     @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}