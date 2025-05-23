package com.apis.Fields_To_Future_Services.Services;

import com.apis.Fields_To_Future_Services.DTOs.UserDto;

public interface UserService {
    /**
     * This method is used to get user details by userId.
     * @param userId
     * @return UserDto
     */
    UserDto fetchUserDetails(Integer userId); 

    /**
     * Create a new user
     * @param userdto
     * @return User
     */
    String createUser(UserDto userdto);

}
