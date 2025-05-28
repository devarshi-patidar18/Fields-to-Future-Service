package com.apis.Fields_To_Future_Services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apis.Fields_To_Future_Services.DTOs.AuthRequestDto;
import com.apis.Fields_To_Future_Services.Jwt.JwtService;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public String generateToken(@RequestBody AuthRequestDto authRequest) {
        if(authRequest.getContact() == null || authRequest.getContact().isEmpty()) {
            throw new IllegalArgumentException("Contact is required");
        }
        if(authRequest.getPassword() == null || authRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getContact(), authRequest.getPassword())
        );
        
        if(authentication.isAuthenticated()){
            System.out.println("Authentication successful for user: " + authRequest.getContact());
            return jwtService.generateToken(authRequest.getContact());
        }

        throw new RuntimeException("Invalid credentials");
    }

    
}
