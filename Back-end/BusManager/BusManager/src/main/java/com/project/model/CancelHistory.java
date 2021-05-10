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
@Table(name="cancel_history")
public class CancelHistory implements Serializable {
    @Id
    @Column(name = "CANCEL_ID", length = 20, nullable = false)
    private String cancelId;
    
    @JsonProperty("reason")
    @Column(name="REASON", length = 100, nullable = false)
    private String reason;
    
    @Column(name="NOTE", length = 200, nullable = true)
    private String note;
    
    @JsonProperty("cusId")
    @ManyToOne
//    fetch = FetchType.LAZY
    @JoinColumn(name="CUS_ID", nullable = true)
    private CusInfo cusId;
    
    @JsonProperty("empId")
    @ManyToOne
//    fetch = FetchType.LAZY
    @JoinColumn(name="EMP_ID", nullable = true)
    private EmpInfo empId;
    
    @JsonProperty("ticketId")
    @ManyToOne
//    fetch = FetchType.LAZY
    @JoinColumn(name="TICKET_ID", nullable = true)
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
  
    /**
     * @param cusId the cusId to set
     */
    public void setCusId(CusInfo cusId) {
        this.cusId = cusId;
    }
    
//     /**
//     * @param cusId to set
//     */
//    public void setCusId(String cusId) {
//        CusInfo newCusInfo = new CusInfo();
//        newCusInfo.setUserId(cusId);
//        this.setCusId(newCusInfo);
//    }

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
  
    /**
     * @param empId the empId to set
     */
    public void setEmpId(EmpInfo empId) {
        this.empId = empId;
    }
    
//    /**
//     * @param empId to set
//     */
//    public void setEmpId(String empId) {
//        EmpInfo newEmpInfo = new EmpInfo();
//        newEmpInfo.setUserId(empId);
//        this.setEmpId(newEmpInfo);
//    }

//    /**
//     * @return the ticketId
//     */
//    public TicketManagement getTicketId() {
//        return ticketId;
//    }
    
    /**
     * @return the ticketId
     */
    public String getTicketId() {
        return ticketId.getTicketId();
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(TicketManagement ticketId) {
        this.ticketId = ticketId;
    }
    
//    /**
//     * @param ticketId to set
//     */
//    public void setTicketId(String ticketId) {
//        TicketManagement newTicketManagement = new TicketManagement();
//        newTicketManagement.setTicketId(ticketId);
//        this.setTicketId(newTicketManagement);
//    }
}
