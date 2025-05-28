package com.apis.Fields_To_Future_Services.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "changerequests")
public class ChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "groupid")
    private GroupDetail group; // Group Entity

    private String status; // PENDING, APPROVED, REJECTED

    @ManyToOne
    @JoinColumn(name = "requestedby")
    private User requestedby; // User Entity

    private Integer totalapprovals;
    private String requestcomments;
    private Integer minimumapprovalsrequired;
    private String requesttype; // ADMIN, LOAN, Group updates, MEMBER



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public GroupDetail getGroup() {
        return group;
    }
    public void setGroup(GroupDetail group) {
        this.group = group;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public User getRequestedby() {
        return requestedby;
    }
    public void setRequestedby(User requestedby) {
        this.requestedby = requestedby;
    }

    public Integer getTotalapprovals() {
        return totalapprovals;
    }
    public void setTotalapprovals(Integer totalapprovals) {
        this.totalapprovals = totalapprovals;
    }
    public String getRequestcomments() {
        return requestcomments;
    }
    public void setRequestcomments(String requestcomments) {
        this.requestcomments = requestcomments;
    }
    public Integer getMinimumapprovalsrequired() {
        return minimumapprovalsrequired;
    }
    public void setMinimumapprovalsrequired(Integer minimumapprovalsrequired) {
        this.minimumapprovalsrequired = minimumapprovalsrequired;
    }
    public String getRequesttype() {
        return requesttype;
    }
    public void setRequesttype(String requesttype) {
        this.requesttype = requesttype;
    }
    public ChangeRequest() {
    }
    public ChangeRequest(Integer id, GroupDetail group, String status, User requestedby,
            Integer totalapprovals, String requestcomments, Integer minimumapprovalsrequired, String requesttype) {
        this.id = id;
        this.group = group;
        this.status = status;
        this.requestedby = requestedby;
        this.totalapprovals = totalapprovals;
        this.requestcomments = requestcomments;
        this.minimumapprovalsrequired = minimumapprovalsrequired;
        this.requesttype = requesttype;
    }

}
