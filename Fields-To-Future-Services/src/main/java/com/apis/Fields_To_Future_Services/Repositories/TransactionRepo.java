package com.apis.Fields_To_Future_Services.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apis.Fields_To_Future_Services.Entities.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
    
    
}
