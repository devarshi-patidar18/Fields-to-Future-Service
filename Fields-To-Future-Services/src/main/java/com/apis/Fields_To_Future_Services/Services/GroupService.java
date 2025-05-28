package com.apis.Fields_To_Future_Services.Services;

import org.springframework.http.ResponseEntity;

import com.apis.Fields_To_Future_Services.DTOs.GroupDto;
import com.apis.Fields_To_Future_Services.Entities.ChangeRequest;
import com.apis.Fields_To_Future_Services.Entities.ChangeRequestResponse;
import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.GroupMember;

public interface GroupService {
    
    GroupDetail createGroup(GroupDto groupdto);

    ResponseEntity<GroupMember> addMemberToGroup(GroupMember groupMember);

    /**
     * Raise a request for admin - This request can only be raised once per six months or in any exceptional case
     * Minimum 50% approval is mandatory from the group members
     * Access: MEMBER
     * @param groupMember
     * @return GroupMember
     */
    String requestForAdmin(ChangeRequest groupMember);

    ResponseEntity<ChangeRequestResponse> actionOnRequest(ChangeRequestResponse changeRequestResponse);
}
