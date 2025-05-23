package com.apis.Fields_To_Future_Services.Services;

import com.apis.Fields_To_Future_Services.Entities.Loan;

public interface LoanService {

    public String createLoan(Loan loan, Long groupId, Integer borrowerId, Long guarantor1Id, Long guarantor2Id);

}
