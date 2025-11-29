package com.yanhua.backend.springboot.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yanhua.backend.springboot.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import io.jsonwebtoken.Claims;

@Service
public class JwtService {
    
    @Autowired
    private JwtEncoder jwtEncoder;
    
    @Autowired
	@Qualifier("userService")
	private UserService userService;

    public String generateJwt(Authentication auth) {
        Instant now = Instant.now();

        String scope = auth.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" ")); // string con espacios: "ROLE_USER ROLE_ADMIN"
        
        String picture = null;
        Optional<User> u = userService.findUserByUsername(auth.getName());
        picture = u.get().getPicture().toString();

        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plus(30, ChronoUnit.DAYS)) // ⏰ Token válido por 30 días
            .subject(auth.getName())
            .claim("picture", picture)
            .claim("roles", scope)
            .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
    
    
   /* public String getUsernameFromToken(String token) {
        Jwt jwt = jwtDecoder.decode(token);
        return jwt.getSubject();
    }
    
    public boolean isTokenExpired(String token) {
        try {
            Jwt jwt = jwtDecoder.decode(token);
            Instant expiration = jwt.getExpiresAt();
            return expiration != null && expiration.isBefore(Instant.now());
        } catch (JwtException | IllegalArgumentException e) {
            return true; // Consideramos el token inválido o ya expirado
        }
    }
    
    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            jwtDecoder.decode(token); 
            final String username=getUsernameFromToken(token);
            return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
        } catch (JwtException | IllegalArgumentException ex) {
        	// Puedes loguear el error
            return false;
        }
        
    }*/
    

}