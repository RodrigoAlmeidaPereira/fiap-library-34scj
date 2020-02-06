package br.com.fiap.library.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private int expire;

    public String generateToken(String username) {
        Date createdAt = getNow(LocalDateTime.now());
        Date expires = getNow(LocalDateTime.now().plusMinutes(expire));

        return Jwts.builder()
                .addClaims(new HashMap<>())
                .setSubject(username)
                .setIssuedAt(createdAt)
                .setExpiration(expires)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
     }

     public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();

        return claims.getSubject();
     }

    private Date getNow(LocalDateTime time) {
        return Date.from(time.toInstant(OffsetDateTime.now().getOffset()));
    }
}
