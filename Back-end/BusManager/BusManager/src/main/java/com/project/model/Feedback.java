/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {

    /**
     * @return the createdOn
     */
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Id
    @Column(name = "FEEDBACK_ID", length = 20, nullable = false)
    private String feedbackId;

    @JsonProperty("fullname")
    @Column(name = "FULLNAME", length = 100, nullable = false)
    private String fullname;

    @JsonProperty("phoneNumber")
    @Column(name = "PHONE_NUMBER", length = 20, nullable = false)
    private String phoneNumber;

    @JsonProperty("type")
    @Column(name = "TYPE", length = 50, nullable = false)
    private String type;

    @JsonProperty("content")
    @Column(name = "CONTENT", length = 1000, nullable = false)
    private String content;

    @JsonProperty("status")
    @Column(name = "STATUS", nullable = false)
    private int status;

    @JsonProperty("createdOn")
    @Column(name = "CREATED_ON", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "NOTE", length = 200, nullable = true)
    private String note;

    @JsonProperty("empId")
    @ManyToOne
//    fetch = FetchType.LAZY
    @JoinColumn(name = "EMP_ID", nullable = true)
    private EmpInfo empId;

    /**
     * @return the feedbackId
     */
    public String getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId the feedbackId to set
     */
    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the empId
     */
    public EmpInfo getEmpId() {
        return empId;
    }

    /**
     * @param empId to set
     */
    public void setEmpId(String empId) {
        EmpInfo newEmpInfo = new EmpInfo();
        newEmpInfo.setUserId(empId);
        this.empId = newEmpInfo;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
