package com.apis.Fields_To_Future_Services.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apis.Fields_To_Future_Services.Entities.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {
    // Custom query methods can be defined here if needed
    // For example, to find loans by borrowerId:
    // List<Loan> findByBorrowerId(Integer borrowerId);
    
}
