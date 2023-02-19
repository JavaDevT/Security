package com.security.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexConroller {

    @Autowired
    JwtUtils jwtUtils;

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
    public String register(@RequestParam String name) {
        if (name.equals("thavam"))
            return jwtUtils.generateToken(name);
        return "InvalidUser user";
       // return "register";
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
