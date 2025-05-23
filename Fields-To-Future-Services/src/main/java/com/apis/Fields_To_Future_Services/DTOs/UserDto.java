package com.apis.Fields_To_Future_Services.DTOs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apis.Fields_To_Future_Services.Entities.GroupDetail;
import com.apis.Fields_To_Future_Services.Entities.GroupMember;

public class UserDto {
    private Integer userid;
    private String name;
    private String email;
    private String phone;
    private Date createdat;
    private String password;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private List<GroupDetail> groupsCreatedByUser;
    private List<GroupMember> groupMemberships = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Date createdat, String email, List<GroupDetail> groupsCreatedByUser, String name, String phone, Integer userid) {
        this.createdat = createdat;
        this.email = email;
        this.groupsCreatedByUser = groupsCreatedByUser;
        this.name = name;
        this.phone = phone;
        this.userid = userid;
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
