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
@Table(name = "changerequestresponses")
public class ChangeRequestResponse  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "change_request_id")
    private ChangeRequest changeRequest;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private GroupMember member;

    private String response;

    private Date respondedAt;

    private String comments;

    public ChangeRequestResponse(ChangeRequest changeRequest, GroupMember member) {
        this.changeRequest = changeRequest;
        this.member = member;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChangeRequest getChangeRequest() {
        return changeRequest;
    }

    public void setChangeRequest(ChangeRequest changeRequest) {
        this.changeRequest = changeRequest;
    }

    public GroupMember getMember() {
        return member;
    }

    public void setMember(GroupMember member) {
        this.member = member;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getRespondedAt() {
        return respondedAt;
    }

    public void setRespondedAt(Date respondedAt) {
        this.respondedAt = respondedAt;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ChangeRequestResponse() {
    }

    public ChangeRequestResponse(Integer id, ChangeRequest changeRequest, GroupMember member, String response,
            Date respondedAt, String comments) {
        this.id = id;
        this.changeRequest = changeRequest;
        this.member = member;
        this.response = response;
        this.respondedAt = respondedAt;
        this.comments = comments;
    }
    
    
}
