package com.apis.Fields_To_Future_Services.DTOs;

import java.util.Date;

public class TransactionDto {

    private Long id;
    private String transactionNumber;
    private Date transactionDate;

    private Integer loanid;

    private Integer groupid;

    private Integer userid;

    private String type;

    public TransactionDto(String type) {
        this.type = type;
    }
    private Double amount;

    public TransactionDto(Long id, String transactionNumber, Date transactionDate, Integer loanid, Integer groupid,
            Integer userid, String type, Double amount, String comments) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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
    private String comments;

}
