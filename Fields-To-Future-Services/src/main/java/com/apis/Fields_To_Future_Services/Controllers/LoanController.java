package com.apis.Fields_To_Future_Services.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.Fields_To_Future_Services.Entities.Loan;
import com.apis.Fields_To_Future_Services.Services.LoanService;
import com.apis.Fields_To_Future_Services.DTOs.LoanDto;

@RestController
@RequestMapping("/loan")
public class LoanController {
    
    @Autowired
    private LoanService loanService;

    @PostMapping("/create")
    public String createLoan(@RequestBody LoanDto loanDto) {
        return loanService.createLoan(loanDto);
    }
}
