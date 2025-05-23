package com.apis.Fields_To_Future_Services.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleid;
    private String rolename;
    private String roledescription;
    private String created_at; // Changed to String for simplicity, can be Date if needed

    public Role(String created_at, String roledescription, Long roleid, String rolename) {
        this.created_at = created_at;
        this.roledescription = roledescription;
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public Role() {
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledescription() {
        return roledescription;
    }

    public void setRoledescription(String roledescription) {
        this.roledescription = roledescription;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
}
