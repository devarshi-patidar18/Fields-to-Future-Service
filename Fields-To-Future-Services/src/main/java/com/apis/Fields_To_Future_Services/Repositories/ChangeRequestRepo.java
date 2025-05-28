package com.apis.Fields_To_Future_Services.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apis.Fields_To_Future_Services.Entities.ChangeRequest;
import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.User;

@Repository
public interface ChangeRequestRepo extends JpaRepository<ChangeRequest, Integer>{

    ChangeRequest findByGroupAndRequestedby(GroupDetail group, User requestedby);

}
