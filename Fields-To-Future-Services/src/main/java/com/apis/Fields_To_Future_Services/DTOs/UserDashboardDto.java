package com.apis.Fields_To_Future_Services.DTOs;

import java.util.List;


public class UserDashboardDto {
    private Long userId;
    private String userName;
    private List<GroupDto> groups;
    private List<LoanDto> loans;
    private List<LoanTransactionDto> loanTransactions;
    private List<ContributionTransactionDto> contributionTransactions;
}
