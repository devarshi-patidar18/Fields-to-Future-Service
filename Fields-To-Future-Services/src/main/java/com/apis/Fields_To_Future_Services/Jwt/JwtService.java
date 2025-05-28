package com.apis.Fields_To_Future_Services.Jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * JwtService is a service class that handles JWT operations such as token generation, validation, and parsing.
 * @author Devarshi Patidar
 */

@Service
public class JwtService {

    public static final String SECRET = "5367566859703373367639792F423F452848284D6251655468576D5A71347437";

    public String generateToken(String phone) {
        /**
         * Generates a JWT token for the given phone number.
         * The token includes claims such as the phone number and an expiration time.
         */
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, phone);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        /**
         * Creates a JWT token with the specified claims and subject.
         * The token is signed with the SECRET key.
         */
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(getSignKey(), SignatureAlgorithm.HS256)
            .compact();
        
    }

    /**
     * Retrieves the signing key used to sign the JWT tokens.
     * The key is derived from the SECRET constant using Base64 decoding.
     */
    private Key getSignKey(){
        byte[] key = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(key);

    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extracts all claims from the JWT token.
     * This method parses the token and retrieves the claims contained within it.
     * @param token
     * @return Claims
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }



    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }



    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


}
