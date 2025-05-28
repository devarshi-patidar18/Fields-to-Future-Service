package com.apis.Fields_To_Future_Services.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date createdat;

    @OneToMany
    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
    private List<Role> roles;
    
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    @OneToMany(mappedBy = "groupcreatedby")
    @JsonManagedReference
    private List<GroupDetail> groupsCreatedByUser;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("user-member")
    private List<GroupMember> groupMemberships;

    @OneToMany(mappedBy = "loanborrowedby")
    private List<Loan> loansBorrowedByUser;

    public List<Loan> getLoansBorrowedByUser() {
        return loansBorrowedByUser;
    }

    public void setLoansBorrowedByUser(List<Loan> loansBorrowedByUser) {
        this.loansBorrowedByUser = loansBorrowedByUser;
    }

    public User() {
    }

    

    public User(Integer userid, String name, String email, String password, String phone, Date createdat,
            List<Role> roles, List<GroupDetail> groupsCreatedByUser, List<GroupMember> groupMemberships,
            List<Loan> loansBorrowedByUser) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.createdat = createdat;
        this.roles = roles;
        this.groupsCreatedByUser = groupsCreatedByUser;
        this.groupMemberships = groupMemberships;
        this.loansBorrowedByUser = loansBorrowedByUser;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public List<GroupDetail> getGroupsCreatedByUser() {
        return groupsCreatedByUser;
    }

    public void setGroupsCreatedByUser(List<GroupDetail> groupsCreatedByUser) {
        this.groupsCreatedByUser = groupsCreatedByUser;
    }

    public List<GroupMember> getGroupMemberships() {
        return groupMemberships;
    }

    public void setGroupMemberships(List<GroupMember> groupMemberships) {
        this.groupMemberships = groupMemberships;
    }

    
}
