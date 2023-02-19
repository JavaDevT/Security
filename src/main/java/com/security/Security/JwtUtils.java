package com.security.Security;

 import io.jsonwebtoken.*;
 import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public String generateToken(String userName) {
        Claims claims = Jwts.claims()
                .setSubject("userLogin").setIssuer(userName).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000));
      //  claims.put("name", "thavam");
      //  claims.put("age", "1");

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "secret").compact();

    }

    public void validateToken(String token) {
        try {
            Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new JwtException("Token Expired");
        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            throw new JwtException("INVALID_CREDENTIALS");
        }
    }
}
