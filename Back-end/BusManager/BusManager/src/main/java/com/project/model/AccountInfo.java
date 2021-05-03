/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Keisour
 */
@Entity
@Table(name = "account_info")
public class AccountInfo implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID", length = 20, nullable = false)
    private String userId;
    
    @Column(name="PASSWORD", length = 300, nullable = false)
    private String password;
    
    @Column(name="TYPE", nullable = false)
    private String type;
    
    @Column(name="STATUS", nullable = false)
    private String status;
    
    @Column(name="CREATED_ON", nullable = true)
    private LocalDateTime createdOn;
    
    @Column(name="UPDATED_ON", nullable = true)
    private LocalDateTime updatedOn;
    
    @Column(name="NOTE", length = 200, nullable = true)
    private String note;
    
    @JsonIgnore
    @OneToOne(mappedBy = "username", fetch = FetchType.EAGER)
    private CusInfo cusInfo;
    
    @JsonIgnore
    @OneToOne(mappedBy = "username", fetch = FetchType.EAGER)
    private EmpInfo empInfo;

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

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

    /**
     * @return the updatedOn
     */
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    /**
     * @param updatedOn the updatedOn to set
     */
    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
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
     * @return the cusInfo
     */
    public CusInfo getCusInfo() {
        return cusInfo;
    }

    /**
     * @param cusInfo the cusInfo to set
     */
    public void setCusInfo(CusInfo cusInfo) {
        this.cusInfo = cusInfo;
    }

    /**
     * @return the empInfo
     */
    public EmpInfo getEmpInfo() {
        return empInfo;
    }

    /**
     * @param empInfo the empInfo to set
     */
    public void setEmpInfo(EmpInfo empInfo) {
        this.empInfo = empInfo;
    }
}
