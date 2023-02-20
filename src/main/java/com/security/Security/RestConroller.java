package com.security.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestConroller {
    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/auth")
    public String auth() {

        authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken("thavam", "thavam"));

        return "auth";
    }

    @GetMapping("/auth_login")
    public String userLogin() {
        return "auth_login";
    }


}
