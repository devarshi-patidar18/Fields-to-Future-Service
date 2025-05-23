package com.apis.Fields_To_Future_Services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apis.Fields_To_Future_Services.Services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestHeader String phone, @RequestHeader String password) {
        if(phone == null || phone.isEmpty()) {
            return "Phone number is required";
        }
        if(password == null || password.isEmpty()) {
            return "Password is required";
        }
        return "login";
    }

    
}
