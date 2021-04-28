/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEEDBACK_ID", length = 20)
    private String feedbackId;
    
    @JsonProperty("content")
    @Column(name = "CONTENT", length = 1000, nullable = false)
    private String content;
    
    @JsonProperty("status")
    @Column(name = "STATUS", nullable = false)
    private Integer status;
    
    @Column(name = "NOTE", length = 200, nullable = true)
    private String note;
    
    @ManyToOne
    @JoinColumn(name = "CUS_ID")
    private CusInfo cusId;
    
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
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
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
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
     * @return the cusId
     */
    public CusInfo getCusId() {
        return cusId;
    }

    /**
     * @param cusId the cusId to set
     */
    public void setCusId(CusInfo cusId) {
        this.cusId = cusId;
    }

    /**
     * @return the empId
     */
    public EmpInfo getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(EmpInfo empId) {
        this.empId = empId;
    }
}