package com.apis.Fields_To_Future_Services.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.Fields_To_Future_Services.DTOs.LoanDto;
import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.Loan;
import com.apis.Fields_To_Future_Services.Entities.Transaction;
import com.apis.Fields_To_Future_Services.Entities.User;
import com.apis.Fields_To_Future_Services.Repositories.GroupRepo;
import com.apis.Fields_To_Future_Services.Repositories.LoanRepo;
import com.apis.Fields_To_Future_Services.Repositories.TransactionRepo;

enum TransactionType {
    LOAN,
    LOAN_REPAYMENT,
    INTEREST,
    PENALTY,
    GROUP_DEPOSIT,
    WITHDRAWAL,
    FORECLOSURE,
    GROUP_FUND_SETTLEMENT
}

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private GroupRepo groupDetailRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public String createLoan(LoanDto loanDto) {
        if(loanDto == null || loanDto.getGroupId() == null || loanDto.getBorrowerId() == null ||
           loanDto.getAmount() == null ||
           loanDto.getIssuedBy() == null || loanDto.getGuarantor1Id() == null ||
           loanDto.getGuarantor2Id() == null) {
            return "Please provide all required fields to create a loan";
        }
        // Implementation of loan creation logic
        // Convert LoanDto to Loan entity
        Loan loan = new Loan();

        GroupDetail group = new GroupDetail();
        group.setGroupid(loanDto.getGroupId());
        loan.setGroup(group);

        User user = new User();
        user.setUserid(loanDto.getIssuedBy());
        loan.setIssuedby(user);

        User user1 = new User();
        user1.setUserid(loanDto.getBorrowerId());
        loan.setLoanborrowedby(user1);

        // Set guarantors
        User guarantor1 = new User();
        guarantor1.setUserid(loanDto.getGuarantor1Id());

        User guarantor2 = new User();
        guarantor2.setUserid(loanDto.getGuarantor2Id());
        loan.setGuarantor1(guarantor1);
        loan.setGuarantor2(guarantor2);

        GroupDetail existingGroupDetail = groupDetailRepo.findById(loanDto.getGroupId()).orElse(null);

        if (existingGroupDetail.getTotalcurrentfundbalance() < loanDto.getAmount()) {
            return "Insufficient funds in the group to issue this loan";
        }
        loan.setAmount(loanDto.getAmount());
        existingGroupDetail.setTotalcurrentfundbalance(existingGroupDetail.getTotalcurrentfundbalance() - loanDto.getAmount());


        loan.setInterestRate(loanDto.getInterestRate() == null ? 12.0 : loanDto.getInterestRate());
        loan.setTenureMonths(loanDto.getTenureMonths() == null ? 12 : loanDto.getTenureMonths());
        loan.setRemainingEmis(loan.getTenureMonths());
        loan.setEmi((loanDto.getAmount() + (loanDto.getAmount() * loan.getInterestRate() / 100)) / loan.getTenureMonths());
        loan.setRemainingEmis(loanDto.getTenureMonths() == null ? 12 : loanDto.getTenureMonths());
        loan.setStatus("ACTIVE");
        loan.setIssuedAt(new Date());
        // loan.setUpdatedAt(new Date());
        Loan l = loanRepo.save(loan);

        Transaction transaction = new Transaction();
        transaction.setAmount(loanDto.getAmount());
        transaction.setType("LOAN");
        transaction.setTransactionDate(new Date());
        transaction.setUserid(loan.getLoanborrowedby());
        transaction.setGroupid(loanDto.getGroupId());
        transaction.setLoanid(l.getLoanId());
        transaction.setTransactionNumber(
                "TXN" + (transactionRepo.findAll() == null ? 0 : transactionRepo.findAll().size()+1) + "U" + loanDto.getBorrowerId() +  "G" + loanDto.getGroupId() + System.currentTimeMillis()
        );

        transactionRepo.save(transaction);
        return "Loan Sanctioned successfully and amount has been deducted from the group fund";
    }

    // Other methods related to loan management can be added here
}
