package com.apis.Fields_To_Future_Services.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.apis.Fields_To_Future_Services.Entities.GroupMember;
import com.apis.Fields_To_Future_Services.Entities.User;

public class GroupDto {

    private Integer groupid;
    private String groupname;
    private User groupcreatedby;
    private List<GroupMember> members = new ArrayList<>();
    private String funddistributedinloans;
    private String groupaddress;
    private String groupdescription;
    private String groupstatus;
    private String grouptype;
    private boolean isactive;
    private float totalcontribution;
    private float totalcurrentfundbalance;
    private float totalfundofgroup;
    private float totalpenaltychargescollected;


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

    public void setTotalcontribution(float totalcontribution) {
        this.totalcontribution = totalcontribution;
    }

    public float getTotalcurrentfundbalance() {
        return totalcurrentfundbalance;
    }

    public void setTotalcurrentfundbalance(float totalcurrentfundbalance) {
        this.totalcurrentfundbalance = totalcurrentfundbalance;
    }

    public float getTotalfundofgroup() {
        return totalfundofgroup;
    }

    public void setTotalfundofgroup(float totalfundofgroup) {
        this.totalfundofgroup = totalfundofgroup;
    }

    public float getTotalpenaltychargescollected() {
        return totalpenaltychargescollected;
    }

    public void setTotalpenaltychargescollected(float totalpenaltychargescollected) {
        this.totalpenaltychargescollected = totalpenaltychargescollected;
    }

    // Getters and Setters  
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

    public GroupDto(Integer groupid, String groupname, User groupcreatedby, List<GroupMember> members,
            String funddistributedinloans, String groupaddress, String groupdescription, String groupstatus,
            String grouptype, boolean isactive, float totalcontribution, float totalcurrentfundbalance,
            float totalfundofgroup, float totalpenaltychargescollected) {
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

    
    
}
