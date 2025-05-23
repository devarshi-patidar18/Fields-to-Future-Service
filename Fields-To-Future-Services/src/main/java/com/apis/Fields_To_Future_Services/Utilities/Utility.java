package com.apis.Fields_To_Future_Services.Utilities;

import com.apis.Fields_To_Future_Services.DTOs.UserDto;
import com.apis.Fields_To_Future_Services.Entities.User;

public class Utility {
    
    public static User convertToUser(UserDto userdto) {
        User user = new User();
        user.setUserid(userdto.getUserid());
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPhone(userdto.getPhone());
        user.setCreatedat(userdto.getCreatedat());
        user.setPassword(userdto.getPassword());
        return user;
    }
}
