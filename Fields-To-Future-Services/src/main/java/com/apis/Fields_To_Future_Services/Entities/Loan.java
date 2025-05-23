package com.apis.Fields_To_Future_Services.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan")   
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "groupid", referencedColumnName = "groupid")
    private GroupDetail group; 

    @ManyToOne 
    @JoinColumn(name = "borrowerid", referencedColumnName = "userid")
    private User loanborrowedby;
    
    private Double amount;
    private Double interestRate;
    private Integer tenureMonths;
    private String status;
    private Integer latePayments;
    private Long issuedBy;
    private Date issuedAt;
    private Double emi;
    private Integer remainingEmis;

    @ManyToOne
    @JoinColumn(name = "guarantorid1", referencedColumnName = "userid")
    private User guarantor1;

    @ManyToOne
    @JoinColumn(name = "guarantorid2", referencedColumnName = "userid")
    private User guarantor2;

    private String checkStatus;
    public Loan(String checkStatus) {
        this.checkStatus = checkStatus;
    }
    public Loan(Long loanId, GroupDetail group, User loanborrowedby, Double amount, Double interestRate,
            Integer tenureMonths, String status, Integer latePayments, Long issuedBy, Date issuedAt, Double emi,
            Integer remainingEmis, User guarantor1, User guarantor2, String checkStatus, Boolean active) {
        this.loanId = loanId;
        this.group = group;
        this.loanborrowedby = loanborrowedby;
        this.amount = amount;
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.status = status;
        this.latePayments = latePayments;
        this.issuedBy = issuedBy;
        this.issuedAt = issuedAt;
        this.emi = emi;
        this.remainingEmis = remainingEmis;
        this.guarantor1 = guarantor1;
        this.guarantor2 = guarantor2;
        this.checkStatus = checkStatus;
        this.active = active;
    }
    private Boolean active;
    public Long getLoanId() {
        return loanId;
    }
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }
    public GroupDetail getGroup() {
        return group;
    }
    public void setGroup(GroupDetail group) {
        this.group = group;
    }
    public User getLoanborrowedby() {
        return loanborrowedby;
    }
    public void setLoanborrowedby(User loanborrowedby) {
        this.loanborrowedby = loanborrowedby;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
    public Integer getTenureMonths() {
        return tenureMonths;
    }
    public void setTenureMonths(Integer tenureMonths) {
        this.tenureMonths = tenureMonths;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getLatePayments() {
        return latePayments;
    }
    public void setLatePayments(Integer latePayments) {
        this.latePayments = latePayments;
    }
    public Long getIssuedBy() {
        return issuedBy;
    }
    public void setIssuedBy(Long issuedBy) {
        this.issuedBy = issuedBy;
    }
    public Date getIssuedAt() {
        return issuedAt;
    }
    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }
    public Double getEmi() {
        return emi;
    }
    public void setEmi(Double emi) {
        this.emi = emi;
    }
    public Integer getRemainingEmis() {
        return remainingEmis;
    }
    public void setRemainingEmis(Integer remainingEmis) {
        this.remainingEmis = remainingEmis;
    }
    public User getGuarantor1() {
        return guarantor1;
    }
    public void setGuarantor1(User guarantor1) {
        this.guarantor1 = guarantor1;
    }
    public User getGuarantor2() {
        return guarantor2;
    }
    public void setGuarantor2(User guarantor2) {
        this.guarantor2 = guarantor2;
    }
    public String getCheckStatus() {
        return checkStatus;
    }
    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    // Getters and Setters
}