package com.apis.Fields_To_Future_Services.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apis.Fields_To_Future_Services.DTOs.ResponseDto;
import com.apis.Fields_To_Future_Services.DTOs.UserDto;
import com.apis.Fields_To_Future_Services.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * * This method is used to get user details by userId.
     * @param userId
     * @return Object
     */
    @PostMapping("/getUserById")
    public ResponseEntity<ResponseDto<Map<String,Object>>> getUserDetailsById(@RequestHeader Integer userId) {
        Map<String,Object> userDetails = new HashMap<>();
        if(userId == null) {
            return new ResponseEntity<>(new ResponseDto<>(userDetails, "User Id is required!"), HttpStatus.BAD_REQUEST);
        }
        else{
            UserDto userdto = (UserDto)userService.fetchUserDetails(userId);
            if(userdto == null) {
                return new ResponseEntity<>(new ResponseDto<>(userDetails, "User not found!"), HttpStatus.NOT_FOUND);
            }
            userDetails.put("User Details", userdto);
            return ResponseEntity.ok().body(new ResponseDto<>(userDetails, "User Details fetched successfully"));
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@RequestBody UserDto userdto) {

        return userService.createUser(userdto);
    }
}
