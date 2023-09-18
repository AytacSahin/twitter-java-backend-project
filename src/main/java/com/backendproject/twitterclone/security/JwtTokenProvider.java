package com.backendproject.twitterclone.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${twitterapp.app.secret}")
    private String APP_SECRET;
    @Value("${twitterapp.expires.in}")
    private int EXPIRES_IN;

    // Token generate etmek için:
    public String generateJwtToken(Authentication auth) {
        JwtUserDetails userDetails = (JwtUserDetails) auth.getPrincipal();
        Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);
        return Jwts.builder().setSubject(Integer.toString(userDetails.getId()))
                .setIssuedAt(new Date()).setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();
    }

    // Gelen token'dan kullanıcının user_id'sini çekmek için:
    int getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getSubject());
    }

    // Token'ı validate etmek için: 
    boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (SignatureException |
                 IllegalArgumentException |
                 MalformedJwtException |
                 ExpiredJwtException |
                 UnsupportedJwtException e) {
            return false;
        }
    }

    // Gelen token expire olmuş mu, bu bilgiyi validateToken'a gönderiyor.
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

}
