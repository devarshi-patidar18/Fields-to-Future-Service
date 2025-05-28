package com.apis.Fields_To_Future_Services.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apis.Fields_To_Future_Services.DTOs.GroupDto;
import com.apis.Fields_To_Future_Services.Entities.ChangeRequest;
import com.apis.Fields_To_Future_Services.Entities.ChangeRequestResponse;
import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.GroupMember;
import com.apis.Fields_To_Future_Services.Repositories.ChangeRequestRepo;
import com.apis.Fields_To_Future_Services.Repositories.ChangeRequestResponseRepo;
import com.apis.Fields_To_Future_Services.Repositories.GroupMemberRepo;
import com.apis.Fields_To_Future_Services.Repositories.GroupRepo;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepo groupRepository;

    @Autowired
    private GroupMemberRepo groupMemberRepository;

    @Autowired
    private ChangeRequestRepo changeRequestRepository;

    @Autowired
    private ChangeRequestResponseRepo changeRequestResponseRepository;

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
        GroupDetail savedDetail = groupRepository.save(groupDetail);

        /**
         * Add the group creator as a member of the group This role of ADMIN
         * will automatically converted to MEMBER after 6 months This member
         * will have to raise separate request to become admin
         */
        GroupMember groupMember = new GroupMember();
        groupMember.setGroupdetail(groupDetail);
        groupMember.setUser(savedDetail.getGroupcreatedby());
        // groupMember.setRole("ADMIN");
        addMemberToGroup(groupMember, "ADMIN");
        return savedDetail;
    }

    @Override
    public ResponseEntity<GroupMember> addMemberToGroup(GroupMember groupMember) {
        if (groupMemberRepository.findByGroupdetail_GroupidAndUser_Userid(groupMember.getGroupdetail().getGroupid(), groupMember.getUser().getUserid()) != null) {
            return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
        }
        List<GroupMember> existingMembers = groupMemberRepository.findByGroupdetail_Groupid(groupMember.getGroupdetail().getGroupid()).stream().toList();
        // Integer maxMemberId = existingMembers.stream().map(member -> member.getGroupdetail().getGroupid()).max(Integer::compareTo).orElse(0);
        Integer maxMemberId = existingMembers.size();
        groupMember.setMemberNumber("M" + (maxMemberId + 1) + "G" + groupMember.getGroupdetail().getGroupid());
        groupMember.setRole("MEMBER");
        return new ResponseEntity<>(groupMemberRepository.save(groupMember), HttpStatus.CREATED);
    }

    public ResponseEntity<GroupMember> addMemberToGroup(GroupMember groupMember, String role) {
        List<GroupMember> existingMembers = groupMemberRepository.findByGroupdetail_Groupid(groupMember.getGroupdetail().getGroupid()).stream().toList();
        // Integer maxMemberId = existingMembers.stream().map(member -> member.getGroupdetail().getGroupid()).max(Integer::compareTo).orElse(0);
        Integer maxMemberId = existingMembers.size();
        groupMember.setMemberNumber("M" + (maxMemberId + 1) + "G" + groupMember.getGroupdetail().getGroupid());
        groupMember.setRole(role);
        return new ResponseEntity<>(groupMemberRepository.save(groupMember), HttpStatus.CREATED);
    }

    /**
     * Raise a request for admin - This request can only be raised once per six
     * months or in any exceptional case Minimum 50% approval is mandatory from
     * the group members Access: MEMBER
     *
     * @param groupMember
     * @return GroupMember
     */
    @Override
    public String requestForAdmin(ChangeRequest changeRequest) {
        if (changeRequestRepository.findByGroupAndRequestedby(changeRequest.getGroup(), changeRequest.getRequestedby()) != null) {
            return ("Request already exists");
        }
        List<GroupMember> groupMembers = groupMemberRepository.findByGroupdetail_Groupid(changeRequest.getGroup().getGroupid());
        Integer minimumApproval = groupMembers.size() / 2;

        changeRequest.setMinimumapprovalsrequired(minimumApproval);
        changeRequest.setStatus("PENDING");
        ChangeRequest savedChangeRequest = changeRequestRepository.save(changeRequest);
        groupMembers.forEach(gm -> {
            changeRequestResponseRepository.save(new ChangeRequestResponse(savedChangeRequest, gm));
        });
        return "Request for admin raised successfully";
    }

    /**
     * Approve or reject the request for admin Access: MEMBER
     *
     * @param changeRequestResponse
     * @return ChangeRequestResponse
     */
    @Override
    public ResponseEntity<ChangeRequestResponse> actionOnRequest(ChangeRequestResponse changeRequestResponse) {
        ChangeRequestResponse existingResponse = 
        changeRequestResponseRepository.findByChangeRequest_IdAndMember_Id(changeRequestResponse.getChangeRequest().getId(), changeRequestResponse.getMember().getId());
        
        ChangeRequest changeRequest = changeRequestRepository.findById(changeRequestResponse.getChangeRequest().getId()).orElse(null);
        if (changeRequest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(changeRequestResponse.getResponse().equals("APPROVED")){
            existingResponse.setResponse("APPROVED");
            changeRequest.setTotalapprovals((changeRequest.getTotalapprovals() == null ? 0 : changeRequest.getTotalapprovals()) + 1);
        }
        if(changeRequestResponse.getResponse().equals("REJECTED")){
            existingResponse.setResponse("REJECTED");
        }
        if (changeRequest.getTotalapprovals() >= changeRequest.getMinimumapprovalsrequired()) {
            changeRequest.setStatus("APPROVED");
            GroupMember groupMember = groupMemberRepository.findByGroupdetail_GroupidAndUser_Userid(changeRequest.getGroup().getGroupid(), changeRequest.getRequestedby().getUserid());
            groupMember.setRole("ADMIN");
            groupMemberRepository.save(groupMember);
        } else {
            changeRequest.setStatus("PENDING");
        }
        ChangeRequestResponse savedResponse = changeRequestResponseRepository.save(existingResponse);
        changeRequestRepository.save(changeRequest);
        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
    }
}
