package com.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/userauth")
    public String authencate(@RequestParam String name, @RequestParam String pass) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name, pass));
        if (name.equals("thavam"))
            return jwtUtils.generateToken(name);
        return "InvalidUser user";
    }

    @GetMapping("/check")
    public String userLogin() {
        return "token valid";
    }

}
