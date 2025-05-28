package com.apis.Fields_To_Future_Services.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apis.Fields_To_Future_Services.Entities.GroupMember;

@Repository
public interface GroupMemberRepo extends JpaRepository<GroupMember, Integer> {
    // Custom query methods (if needed) can be defined here

    List<GroupMember> findByGroupdetail_Groupid(Integer groupid);

    GroupMember findByGroupdetail_GroupidAndUser_Userid(Integer groupid, Integer userid);
}
