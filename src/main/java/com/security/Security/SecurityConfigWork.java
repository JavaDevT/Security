package com.security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfigWork {
    public String[] adminAccess = {"/admin-login", "/admin-dashboard",};
    public String[] userAccess = {"/user-login", "/user-dashboard", "/user"};

    /* public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         return http.csrf().disable().authorizeHttpRequests().requestMatchers("/register").permitAll()
               //  .and()
               //  .authorizeHttpRequests().requestMatchers(adminAccess).authenticated()
                // .and()
                // .authorizeHttpRequests()
                // .requestMatchers(userAccess)hasAuthority("user"
                 //authenticated()
                 .and().formLogin().and().build();
     }
 }
 */
   /* @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
           .authorizeHttpRequests(authorize -> {
                       try {
                           authorize
                                        .requestMatchers(  "/register", "/dashboard").authenticated().and()
                                           .formLogin();
                       } catch (Exception e) {
                           throw new RuntimeException(e);
                       }
                   }
                        //.requestMatchers("/admin/**").hasRole("ADMIN")
                        //.anyRequest().denyAll()
                );

        return http.build();
    }*/
}