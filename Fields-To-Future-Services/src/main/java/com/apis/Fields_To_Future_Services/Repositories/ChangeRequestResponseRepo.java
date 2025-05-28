package com.apis.Fields_To_Future_Services.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apis.Fields_To_Future_Services.Entities.ChangeRequestResponse;

@Repository
public interface ChangeRequestResponseRepo extends JpaRepository<ChangeRequestResponse, Integer> {

    ChangeRequestResponse findByChangeRequest_IdAndMember_Id(Integer id, Integer id2);
    // Custom query methods can be defined here if needed
    // For example, you can add methods to find responses by change request or member
    
}
