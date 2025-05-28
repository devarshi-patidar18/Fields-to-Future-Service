package com.apis.Fields_To_Future_Services.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "groupdetail")

public class GroupDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupid;
    private String groupname;

    @ManyToOne
    @JoinColumn(name = "groupcreatedby", referencedColumnName = "userid")
    @JsonBackReference
    private User groupcreatedby;

    @OneToMany(mappedBy = "groupdetail", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("group-member")
    private List<GroupMember> members = new ArrayList<>();

    @OneToMany(mappedBy= "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();
    

    private String funddistributedinloans;
    private String groupaddress;
    private String groupdescription;
    private String groupstatus;
    private String grouptype;
    private boolean isactive;

    /** Total Contributions made by Group Members */
    private double totalcontribution;

    /** Total Current Fund Balance of the Group  */
    private double totalcurrentfundbalance;

    /** Total Fund of the Group includes all contributions, loans, Interest and penalties */
    private double totalfundofgroup;

    private double totalpenaltychargescollected;


    public String getFunddistributedinloans() {
        return funddistributedinloans;
    }
    public void setFunddistributedinloans(String funddistributedinloans) {
        this.funddistributedinloans = funddistributedinloans;
    }
    public String getGroupaddress() {
        return groupaddress;
    }
    public void setGroupaddress(String groupaddress) {
        this.groupaddress = groupaddress;
    }
    public String getGroupdescription() {
        return groupdescription;
    }
    public void setGroupdescription(String groupdescription) {
        this.groupdescription = groupdescription;
    }
    public String getGroupstatus() {
        return groupstatus;
    }
    public void setGroupstatus(String groupstatus) {
        this.groupstatus = groupstatus;
    }
    public String getGrouptype() {
        return grouptype;
    }
    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }
    public boolean isIsactive() {
        return isactive;
    }
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
    public double getTotalcontribution() {
        return totalcontribution;
    }
    public void setTotalcontribution(double totalcontribution) {
        this.totalcontribution = totalcontribution;
    }
    public double getTotalcurrentfundbalance() {
        return totalcurrentfundbalance;
    }
    public void setTotalcurrentfundbalance(double totalcurrentfundbalance) {
        this.totalcurrentfundbalance = totalcurrentfundbalance;
    }
    public double getTotalfundofgroup() {
        return totalfundofgroup;
    }
    public void setTotalfundofgroup(double totalfundofgroup) {
        this.totalfundofgroup = totalfundofgroup;
    }
    public double getTotalpenaltychargescollected() {
        return totalpenaltychargescollected;
    }
    public void setTotalpenaltychargescollected(double totalpenaltychargescollected) {
        this.totalpenaltychargescollected = totalpenaltychargescollected;
    }
    public GroupDetail() {
    }
    public GroupDetail(String groupname, User groupcreatedby) {
        this.groupname = groupname;
        this.groupcreatedby = groupcreatedby;
    }
    public Integer getGroupid() {
        return groupid;
    }
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
    public String getGroupname() {
        return groupname;
    }
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    public User getGroupcreatedby() {
        return groupcreatedby;
    }
    public void setGroupcreatedby(User groupcreatedby) {
        this.groupcreatedby = groupcreatedby;
    }
    public List<GroupMember> getMembers() {
        return members;
    }
    public void setMembers(List<GroupMember> members) {
        this.members = members;
    }
    public GroupDetail(Integer groupid, String groupname, User groupcreatedby, List<GroupMember> members,
            String funddistributedinloans, String groupaddress, String groupdescription, String groupstatus,
            String grouptype, boolean isactive, double totalcontribution, double totalcurrentfundbalance,
            double totalfundofgroup, double totalpenaltychargescollected) {
        this.groupid = groupid;
        this.groupname = groupname;
        this.groupcreatedby = groupcreatedby;
        this.members = members;
        this.funddistributedinloans = funddistributedinloans;
        this.groupaddress = groupaddress;
        this.groupdescription = groupdescription;
        this.groupstatus = groupstatus;
        this.grouptype = grouptype;
        this.isactive = isactive;
        this.totalcontribution = totalcontribution;
        this.totalcurrentfundbalance = totalcurrentfundbalance;
        this.totalfundofgroup = totalfundofgroup;
        this.totalpenaltychargescollected = totalpenaltychargescollected;
    }
    public List<Loan> getLoans() {
        return loans;
    }
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    
    
}
