package com.apis.Fields_To_Future_Services.DTOs;

public class LoanDto {

    private Integer loanId;
    private Integer groupId;
    private Integer borrowerId;
    private Double amount;
    private Double interestRate;
    private Integer tenureMonths;
    private String status;
    private Integer latePayments;
    private Integer issuedBy;
    private String issuedAt;
    private Double emi;
    private Integer remainingEmis;
    private Integer guarantor1Id;
    private Integer guarantor2Id;
    public Integer getLoanId() {
        return loanId;
    }
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }
    public Integer getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public Integer getBorrowerId() {
        return borrowerId;
    }
    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
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
    public Integer getIssuedBy() {
        return issuedBy;
    }
    public void setIssuedBy(Integer issuedBy) {
        this.issuedBy = issuedBy;
    }
    public String getIssuedAt() {
        return issuedAt;
    }
    public void setIssuedAt(String issuedAt) {
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
    public Integer getGuarantor1Id() {
        return guarantor1Id;
    }
    public void setGuarantor1Id(Integer guarantor1Id) {
        this.guarantor1Id = guarantor1Id;
    }
    public Integer getGuarantor2Id() {
        return guarantor2Id;
    }
    public void setGuarantor2Id(Integer guarantor2Id) {
        this.guarantor2Id = guarantor2Id;
    }
    public LoanDto() {
    }
    public LoanDto(Integer loanId, Integer groupId, Integer borrowerId, Double amount, Double interestRate,
            Integer tenureMonths, String status, Integer latePayments, Integer issuedBy, String issuedAt, Double emi,
            Integer remainingEmis, Integer guarantor1Id, Integer guarantor2Id) {
        this.loanId = loanId;
        this.groupId = groupId;
        this.borrowerId = borrowerId;
        this.amount = amount;
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.status = status;
        this.latePayments = latePayments;
        this.issuedBy = issuedBy;
        this.issuedAt = issuedAt;
        this.emi = emi;
        this.remainingEmis = remainingEmis;
        this.guarantor1Id = guarantor1Id;
        this.guarantor2Id = guarantor2Id;
    }

    // Getters and Setters
}