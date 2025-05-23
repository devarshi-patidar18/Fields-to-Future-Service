package com.apis.Fields_To_Future_Services.Services;

import com.apis.Fields_To_Future_Services.DTOs.GroupDto;
import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.GroupMember;

public interface GroupService {
    
    GroupDetail createGroup(GroupDto groupdto);

    GroupMember addMemberToGroup(GroupMember groupMember);
}
