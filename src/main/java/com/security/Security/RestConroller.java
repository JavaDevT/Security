package com.security.Security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestConroller {
    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    @GetMapping("/auth_login")
    public String userLogin() {
        return "auth_login";
    }



}
