package com.apis.Fields_To_Future_Services.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.Fields_To_Future_Services.DTOs.UserDto;
import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.GroupMember;
import com.apis.Fields_To_Future_Services.Entities.User;
import com.apis.Fields_To_Future_Services.Repositories.UserRepo;
import com.apis.Fields_To_Future_Services.Utilities.Utility;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    /**
     * This method is used to get user details by userId.
     *
     * @param userId
     * @return UserDto
     */
    @Override
    public UserDto fetchUserDetails(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDto userDto = new UserDto();
            userDto.setUserid(user.getUserid());
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDto.setPhone(user.getPhone());
            userDto.setCreatedat(user.getCreatedat());
            List<GroupDetail> groupsCreatedByUser = user.getGroupsCreatedByUser();
            userDto.setGroupsCreatedByUser(groupsCreatedByUser);
            List<GroupMember> groupMemberships = user.getGroupMemberships();
            userDto.setGroupMemberships(groupMemberships);
            return userDto;
        }
        return null;
    }

    /**
     * Create a new user
     *
     * @param userdto
     * @return User
     */
    @Override
    public String createUser(UserDto userdto) {
        if (userdto.getPhone() == null || userdto.getPhone().isEmpty()) {
            return "Phone number is required";
        }
        if (userdto.getPassword() == null || userdto.getPassword().isEmpty()) {
            return "Password is required";
        }
        try {
            if (userdto.getUserid() != null) {
                
                userRepository.save(Utility.convertToUser(userdto));
                return "User updated successfully";
            } else {
                if (userRepository.findByPhone(userdto.getPhone()) != null) {
                    return "User already exists with this phone number";
                }
                userdto.setCreatedat(new Date());
                userRepository.save(Utility.convertToUser(userdto));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "User created successfully";
    }

}
