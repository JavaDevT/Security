package com.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    public String[] adminAccess = {"/admin-login/**"};
    public String[] userAccess = {"/user-login/**"};

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    /* @Bean
         public UserDetailsService userDetailsService() {
                 UserDetails userDetailsService = User.withUsername("thavam").password(("123456")).roles("user").build();
             InMemoryUserDetailsManager inMemoryUserDetailsManager= new InMemoryUserDetailsManager();
             inMemoryUserDetailsManager.createUser(userDetailsService);
                 return inMemoryUserDetailsManager;
              //  return new UserDetailsFromDbRole();
         }*/
   /* @Bean
    public AuthenticationProvider authenticationManagerBean() throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        //return new UserDetailsFromDb();
        return authProvider;
    }*/
   /* @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
       *//* config.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                "1234",
                "1234"
        ));*//*
        return config.getAuthenticationManager();
    }*/

    /*@Bean
   @Order(2)
   public SecurityFilterChain web(HttpSecurity http) throws Exception {
       http.csrf().disable().authorizeHttpRequests().requestMatchers("/register", "/dashboard").permitAll().
               and().authorizeHttpRequests().requestMatchers(userAccess).hasAuthority("user")
               .and()
               .authorizeHttpRequests().requestMatchers(adminAccess).hasAuthority("admin").anyRequest().authenticated().and().formLogin();
       return http.build();
   }*/
    @Bean
    // @Order(1)
    public SecurityFilterChain restApis(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests().requestMatchers("/api/**").

                authenticated().and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // .and().authenticationProvider();
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /*@Autowired
    private UserDetailsService jwtUserDetailsService;*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}