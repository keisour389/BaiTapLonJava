/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.response;

/**
 *
 * @author DELL
 */
public class FeedbackResponse {
    private String feedbackId;
    private String content;
    private Integer status;
    private String note;
    private String cusId;
    private String empId;
    
    public FeedbackResponse(){
    }
    
    public FeedbackResponse(String feedbackId, String content, Integer status, 
            String note, String cusId, String empId){
        this.feedbackId = feedbackId;
        this.content = content;
        this.status = status;
        this.note = note;
        this.cusId = cusId;
        this.empId = empId;
    }

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
    public String getCusId() {
        return cusId;
    }

    /**
     * @param cusId the cusId to set
     */
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
