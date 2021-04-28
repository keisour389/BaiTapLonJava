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
public class CancelHistoryResponse {
    private String cancelId;
    private String reason;
    private String note;
    private String cusId;
    private String empId;
    private String ticketId;
    
    public CancelHistoryResponse(){
    }
    
    public CancelHistoryResponse(String cancelId, String reason, String note, 
            String cusId, String empId, String ticketId){
        this.cancelId = cancelId;
        this.reason = reason;
        this.note = note;
        this.cusId = cusId;
        this.empId = empId;
        this.ticketId = ticketId;
    }

    /**
     * @return the cancelId
     */
    public String getCancelId() {
        return cancelId;
    }

    /**
     * @param cancelId the cancelId to set
     */
    public void setCancelId(String cancelId) {
        this.cancelId = cancelId;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
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

    /**
     * @return the ticketId
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
