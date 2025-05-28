package com.apis.Fields_To_Future_Services.Entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "groupmember")
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String membernumber;

    public String getMembernumber() {
        return membernumber;
    }

    public void setMemberNumber(String membernumber) {
        this.membernumber = membernumber;
    }

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonBackReference("user-member")
    private User user;

    @Transient
    private Integer userid;

    public Integer getUserid() {
        return user != null ? user.getUserid() : null;
    }

    @Transient
    private String groupname;

    public String getGroupname() {
        return this.groupname = groupdetail != null ? groupdetail.getGroupname() : null;
    }

    @Transient
    private Integer groupid;
    public Integer getGroupid() {
        return groupid = groupdetail != null ? groupdetail.getGroupid() : null;
    }


    @ManyToOne
    @JoinColumn(name = "groupid")
    @JsonBackReference("group-member")
    private GroupDetail groupdetail;

    private String role;         // e.g. admin, member
    private LocalDate joinedAt;  // when the user joined the group
    private String membername;
    private String membercontact;
    private String memberaddress;
    private Double totalcontribution;
    private Double totalshareingroup;
    private Boolean active;

    public GroupMember() {
    }

    public GroupMember(Boolean active, GroupDetail groupdetail, Integer id, LocalDate joinedAt, String memberaddress, String membercontact, String membername, String role, Double totalcontribution, Double totalshareingroup, User user) {
        this.active = active;
        this.groupdetail = groupdetail;
        this.id = id;
        this.joinedAt = joinedAt;
        this.memberaddress = memberaddress;
        this.membercontact = membercontact;
        this.membername = membername;
        this.role = role;
        this.totalcontribution = totalcontribution;
        this.totalshareingroup = totalshareingroup;
        this.user = user;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public GroupDetail getGroupdetail() {
        return groupdetail;
    }
    public void setGroupdetail(GroupDetail groupdetail) {
        this.groupdetail = groupdetail;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public LocalDate getJoinedAt() {
        return joinedAt;
    }
    public void setJoinedAt(LocalDate joinedAt) {
        this.joinedAt = joinedAt;
    }
    public String getMembername() {
        return membername = user != null ? user.getName() : null;
    }
    public void setMembername(String membername) {
        this.membername = membername;
    }
    public String getMembercontact() {
        return membercontact=user != null ? user.getPhone() : null;
    }
    public void setMembercontact(String membercontact) {
        this.membercontact = membercontact;
    }
    public String getMemberaddress() {
        return memberaddress;
    }
    public void setMemberaddress(String memberaddress) {
        this.memberaddress = memberaddress;
    }
    public Double getTotalcontribution() {
        return totalcontribution;
    }
    public void setTotalcontribution(Double totalcontribution) {
        this.totalcontribution = totalcontribution;
    }
    public Double getTotalshareingroup() {
        return totalshareingroup;
    }
    public void setTotalshareingroup(Double totalshareingroup) {
        this.totalshareingroup = totalshareingroup;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

   
}
