package com.security.Security;

public class BadCredentials extends RuntimeException {
    public BadCredentials(String message) {
        super(message);
    }
}
