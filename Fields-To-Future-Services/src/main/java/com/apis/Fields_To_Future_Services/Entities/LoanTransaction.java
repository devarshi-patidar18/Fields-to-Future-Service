package com.apis.Fields_To_Future_Services.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loantransaction")
public class LoanTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionNumber;
    @ManyToOne
    @JoinColumn(name = "loanid")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "groupid")
    private GroupDetail group;

    @ManyToOne
    @JoinColumn(name = "memberid")
    private GroupMember member;

    private String type;
    private Double amount;
    private String comments;

}
