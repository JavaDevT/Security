package com.security.Security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexConroller {
    @GetMapping("/user")
    public String user() {
        return "Hi user";
    }

    @GetMapping("/user-login")
    public String userLogin() {
        return "user-login";
    }

    @GetMapping("/user-dashboard")
    public String userDash() {
        return "user-dashboard";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/admin-login")
    public String adminLogin() {
        return "adminlogin";
    }

    @GetMapping("/admin-dashboard")
    public String adminDash() {
        return "admin-dashboard";
    }

    @GetMapping("/dashboard")
    public String index() {
        return "commaon dashboard";
    }
}
