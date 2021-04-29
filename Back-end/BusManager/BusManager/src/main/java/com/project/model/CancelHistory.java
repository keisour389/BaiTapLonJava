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
@Table(name="cancel_history")
public class CancelHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CANCEL_ID", length = 20)
    private String cancelId;
    
    @JsonProperty("reason")
    @Column(name="REASON", length = 100, nullable = false)
    private String reason;
    
    @Column(name="NOTE", length = 200, nullable = true)
    private String note;
    
    @ManyToOne
    @JoinColumn(name="CUS_ID")
    private CusInfo cusId;
    
    @ManyToOne
    @JoinColumn(name="EMP_ID")
    private EmpInfo empId;
    
    @ManyToOne
    @JoinColumn(name="TICKET_ID")
    private TicketManagement ticketId;

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
    public CusInfo getCusId() {
        return cusId;
    }
    
     /**
     * @param cusId to set
     */
    public void setCusId(String cusId) {
        CusInfo newCusInfo = new CusInfo();
        newCusInfo.setUserId(cusId);
        this.cusId = newCusInfo;
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
     * @return the ticketId
     */
    public TicketManagement getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId to set
     */
    public void setTicketId(String ticketId) {
        TicketManagement newTicketManagement = new TicketManagement();
        newTicketManagement.setTicketId(ticketId);
        this.ticketId = newTicketManagement;
    }
}
