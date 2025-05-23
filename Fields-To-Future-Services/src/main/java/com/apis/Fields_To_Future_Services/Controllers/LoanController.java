package com.apis.Fields_To_Future_Services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.Fields_To_Future_Services.Entities.Loan;
import com.apis.Fields_To_Future_Services.Services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
    
    @Autowired
    private LoanService loanService;

    @PostMapping("/create")
    public String createLoan(@RequestBody Loan loan, @RequestHeader Long groupId, @RequestHeader Integer borrowerId, @RequestHeader Long guarantor1Id, @RequestHeader Long guarantor2Id) {
        return loanService.createLoan(loan, groupId, borrowerId, guarantor1Id, guarantor2Id);
    }
}
