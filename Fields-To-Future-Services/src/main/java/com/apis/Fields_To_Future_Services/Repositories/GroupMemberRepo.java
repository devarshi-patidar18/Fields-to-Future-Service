package com.apis.Fields_To_Future_Services.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apis.Fields_To_Future_Services.Entities.GroupMember;

@Repository
public interface GroupMemberRepo extends JpaRepository<GroupMember, Long> {
    // Custom query methods (if needed) can be defined here
}
