package com.apis.Fields_To_Future_Services.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.Fields_To_Future_Services.DTOs.TransactionDto;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    @PostMapping("/create")
    public String addTransaction(TransactionDto transactionDto) {
        // Logic to create a transaction
        return "Transaction created successfully";
    }
}
