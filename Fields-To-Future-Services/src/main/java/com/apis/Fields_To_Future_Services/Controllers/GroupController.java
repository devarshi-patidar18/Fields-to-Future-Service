package com.apis.Fields_To_Future_Services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.Fields_To_Future_Services.DTOs.GroupDto;
import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.GroupMember;
import com.apis.Fields_To_Future_Services.Services.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    
    /**
     * Create a new group
     * @param groupdto
     * @return Group
     */
    @PostMapping(value = "/create")
    public GroupDetail createGroup(@RequestBody GroupDto groupdto) {
        return groupService.createGroup(groupdto);
    }

    /**
     * Add a member to a group
     * @param groupdto  
     * @return Group
     */
    @PostMapping(value = "/addmember")
    public GroupMember addMemberToGroup(@RequestBody GroupMember groupMember) {
        return groupService.addMemberToGroup(groupMember);
    }
}
