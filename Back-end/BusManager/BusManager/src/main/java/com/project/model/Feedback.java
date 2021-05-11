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
    @Id
    @Column(name = "FEEDBACK_ID", length = 20, nullable = false)
    private String feedbackId;
    
    @JsonProperty("content")
    @Column(name = "CONTENT", length = 1000, nullable = false)
    private String content;
    
    @JsonProperty("status")
    @Column(name = "STATUS", nullable = false)
    private int status;
    
    @Column(name = "NOTE", length = 200, nullable = true)
    private String note;
    
    @JsonProperty("cusId")
    @ManyToOne
//    fetch = FetchType.LAZY
    @JoinColumn(name = "CUS_ID", nullable = false)
    private CusInfo cusId;
    
    @JsonProperty("empId")
    @ManyToOne
//    fetch = FetchType.LAZY
    @JoinColumn(name = "EMP_ID", nullable = false)
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

//    /**
//     * @return the cusId
//     */
//    public CusInfo getCusId() {
//        return cusId;
//    }
    
    /**
     * @return the cusId
     */
    public String getCusId() {
        return cusId.getUsername();
    }
    
//    /**
//     * @param cusId to set
//     */
//    public void setCusId(String cusId) {
//        CusInfo newCusInfo = new CusInfo();
//        newCusInfo.setUserId(cusId);
//        this.setCusId(newCusInfo);
//    }
    
    /**
     * @param cusId the cusId to set
     */
    public void setCusId(CusInfo cusId) {
        this.cusId = cusId;
    }

//    /**
//     * @return the empId
//     */
//    public EmpInfo getEmpId() {
//        return empId;
//    }
    
    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId.getUsername();
    }
    
//    /**
//     * @param empId to set
//     */
//    public void setEmpId(String empId) {
//        EmpInfo newEmpInfo = new EmpInfo();
//        newEmpInfo.setUserId(empId);
//        this.setEmpId(newEmpInfo);
//    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(EmpInfo empId) {
        this.empId = empId;
    }
}
