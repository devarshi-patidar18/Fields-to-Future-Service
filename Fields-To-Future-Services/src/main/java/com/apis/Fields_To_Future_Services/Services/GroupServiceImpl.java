package com.apis.Fields_To_Future_Services.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.Fields_To_Future_Services.DTOs.GroupDto;
import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.GroupMember;
import com.apis.Fields_To_Future_Services.Repositories.GroupMemberRepo;
import com.apis.Fields_To_Future_Services.Repositories.GroupRepo;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepo groupRepository;

    @Autowired
    private GroupMemberRepo groupMemberRepository;

    @Override
    public GroupDetail createGroup(GroupDto groupdto) {
        // Implementation for creating a group
        GroupDetail groupDetail = new GroupDetail();
        groupDetail.setGroupid(groupdto.getGroupid());
        groupDetail.setGroupname(groupdto.getGroupname());
        groupDetail.setGroupcreatedby(groupdto.getGroupcreatedby());
        groupDetail.setMembers(groupdto.getMembers());
        groupDetail.setFunddistributedinloans(groupdto.getFunddistributedinloans());
        groupDetail.setGroupaddress(groupdto.getGroupaddress());
        groupDetail.setGroupdescription(groupdto.getGroupdescription());
        groupDetail.setGroupstatus(groupdto.getGroupstatus());
        groupDetail.setGrouptype(groupdto.getGrouptype());
        groupDetail.setIsactive(groupdto.isIsactive());
        // groupDetail.setTotalcontribution(groupdto.getTotalcontribution());
        groupDetail.setTotalcurrentfundbalance(groupdto.getTotalcurrentfundbalance());
        groupDetail.setTotalfundofgroup(groupdto.getTotalfundofgroup());
        return groupRepository.save(groupDetail);
    }

    @Override
    public GroupMember addMemberToGroup(GroupMember groupMember) {
        
        return groupMemberRepository.save(groupMember);
    }

    // Other methods and logic for the GroupServiceImpl can be added here

}
