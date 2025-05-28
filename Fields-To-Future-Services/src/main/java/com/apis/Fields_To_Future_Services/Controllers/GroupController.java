package com.apis.Fields_To_Future_Services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.Fields_To_Future_Services.DTOs.GroupDto;
import com.apis.Fields_To_Future_Services.Entities.ChangeRequest;
import com.apis.Fields_To_Future_Services.Entities.ChangeRequestResponse;
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
     * access: NORMAL
     * @param groupdto
     * @return Group
     */
    @PostMapping(value = "/create")
    public GroupDetail createGroup(@RequestBody GroupDto groupdto) {
        return groupService.createGroup(groupdto);
    }

    /**
     * Add a member to a group
     * Access: ADMIN
     * @param groupdto  
     * @return Group
     */
    @PostMapping(value = "/addmember")
    public ResponseEntity<GroupMember> addMemberToGroup(@RequestBody GroupMember groupMember) {
        return groupService.addMemberToGroup(groupMember);
    }

    /**
     * Raise a request for admin - This request can only be raised once per six months or in any exceptional case
     * Minimum 50% approval is mandatory from the group members
     * Access: MEMBER
     * @param groupMember
     * @return GroupMember
     */
    @PostMapping(value = "/requestforadmin")
    public String requestForAdmin(@RequestBody ChangeRequest changeRequest) {
        return groupService.requestForAdmin(changeRequest);
    }

    /**
     * Action on request - This request can only be raised once per six months or in any exceptional case
     * Minimum 50% approval is mandatory from the group members
     * Access: MEMBER
     * @param groupMember
     * @return GroupMember
     */
    @PostMapping(value = "/actiononrequest")
    public ResponseEntity<ChangeRequestResponse> actionOnRequest(@RequestBody ChangeRequestResponse changeRequestResponse) {
        return groupService.actionOnRequest(changeRequestResponse);
    }
}
