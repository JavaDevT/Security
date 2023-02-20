package com.security.Security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<Object> exception(BadCredentials exception) {
        return new ResponseEntity<>("Bad Credentials from custom exception", HttpStatus.BAD_REQUEST);
    }
}
