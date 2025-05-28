package com.apis.Fields_To_Future_Services.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// enum TransactionType {
//     LOAN,
//     LOAN_REPAYMENT,
//     INTEREST,
//     PENALTY,
//     GROUP_DEPOSIT,
//     WITHDRAWAL,
//     FORECLOSURE,
//     GROUP_FUND_SETTLEMENT
// }

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String transactionNumber;
    private Date transactionDate;
    
    private Integer loanid;

    private Integer groupid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userid;

    private String type;
    private Double amount;
    private String comments;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTransactionNumber() {
        return transactionNumber;
    }
    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    
    public Integer getGroupid() {
        return groupid;
    }
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public Transaction() {
    }
    public Integer getLoanid() {
        return loanid;
    }
    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }
    public User getUserid() {
        return userid;
    }
    public void setUserid(User userid) {
        this.userid = userid;
    }
    public Transaction(Integer id, String transactionNumber, Date transactionDate, Integer loanid, Integer groupid,
            User userid, String type, Double amount, String comments) {
        this.id = id;
        this.transactionNumber = transactionNumber;
        this.transactionDate = transactionDate;
        this.loanid = loanid;
        this.groupid = groupid;
        this.userid = userid;
        this.type = type;
        this.amount = amount;
        this.comments = comments;
    }
   

    

}
