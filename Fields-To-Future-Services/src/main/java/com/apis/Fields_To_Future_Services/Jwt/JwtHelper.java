package com.apis.Fields_To_Future_Services.Jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JwtHelper is a filter that processes JWT tokens in incoming HTTP requests.
 * This class verfies the JWT token and sets the authentication in the security
 * context.
 *
 * @author Devarshi Patidar
 */
@Component
public class JwtHelper extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtHelper(JwtService jwtService, UserDetailsService userDetailsService) {
        System.out.println("JwtHelper initialized ------------------------- in constructor");
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    /**
     * doFilterInternal is called for every HTTP request to process JWT tokens.
     * It checks the request for a JWT token, validates it, and sets the
     * authentication in the security context. If the token is valid, it allows
     * the request to proceed; otherwise, it rejects the request.
     *
     * @param req the HttpServletRequest object containing the request data
     * @throws java.io.IOException and jakarta.servlet.ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) 
    throws ServletException, IOException {
        System.out.println("JwtHelper filter processing request ------------------------- in doFilterInternal method");

        String header = req.getHeader("Authorization");
        String token = null;
        String username = null; // username is phone number in this case

        if(header != null && header.startsWith("Bearer ")){
            token = header.substring(7);
            username = jwtService.extractUsername(token);
        }

        if(username !=null && SecurityContextHolder.getContext().getAuthentication() ==null ){
            /**
             * If the username is not null and there is no authentication in the security context,
             * we need to create an authentication token and set it in the security context.
             */
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(jwtService.validateToken(token,userDetails)){
                /**
                 * If the token is valid, we create a new UsernamePasswordAuthenticationToken
                 * with the user details and set it in the security context.
                 */
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,
                userDetails.getAuthorities());
                authToken.setDetails(userDetails);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        chain.doFilter(req, res);
        System.out.println("JwtHelper filter ## completed ## processing request ------------------------- in doFilterInternal method");

    }

}
