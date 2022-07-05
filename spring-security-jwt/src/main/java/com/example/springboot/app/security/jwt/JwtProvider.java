package com.example.springboot.app.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtProvider {


    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);


    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){

        String username = authentication.getName();
        System.out.println("Usuario autenticado: "+username);
        return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public String getNombreUsuarioDelToken(String token){

    	Claims claims = Jwts.parser()
    			.setSigningKey(secret)
    			.parseClaimsJws(token)
    			.getBody();
    	System.out.println("getNombreUsuarioFromToken: "+claims.getSubject());
    	return claims.getSubject();
    }


    public Boolean validateToken(String token){
        try {

            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("Token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("Token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("Token expirado");
        }catch (IllegalArgumentException e){
            logger.error("Token vacio");
        }catch (SignatureException e){
            logger.error("Fallo con la firma");
        }
        return false;
    }
}
