/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author DELL
 */
@Entity
@Table(name="cus_info")
public class CusInfo implements Serializable {
    @Id
    @Column(name = "USER_ID", length = 20, nullable = false)
    private String userId;
    
    @JsonProperty("first_name")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;
    
    @JsonProperty("last_name")
    @Column(name = "LAST_NAME", length = 100, nullable = false)
    private String lastName;
    
    @JsonProperty("display_name")
    @Column(name = "DISPLAY_NAME", length = 200, nullable = false)
    private String displayName;
    
    @JsonProperty("phone_number")
    @Column(name = "PHONE_NUMBER", length = 20, nullable = false)
    private String phoneNumber;
    
    @JsonProperty("dob")
    @Column(name = "DOB", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthday;
    
    @JsonProperty("gender")
    @Column(name = "GENDER", length = 50, nullable = false)
    private String gender;
    
    @Column(name = "CREATED_ON", nullable = true)
    private LocalDateTime createdOn;
    
    @Column(name = "UPDATED_ON", nullable = true)
    private LocalDateTime updatedOn;
    
    @Column(name = "NOTE", length = 200, nullable = true)
    private String note;
    
    @JsonProperty("username")
    @OneToOne(cascade = CascadeType.ALL)
//    fetch = FetchType.EAGER
    @JoinColumn(name = "USERNAME", referencedColumnName = "USER_ID",
            nullable = true, updatable = false)
    private AccountInfo username;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cusId")
//    fetch = FetchType.LAZY
    private List<TicketManagement> ticketManagement;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cusId")
//    fetch = FetchType.LAZY
    private List<CancelHistory> cancelHistory;

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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
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

//    /**
//     * @return the username
//     */
//    public AccountInfo getUsername() {
//        return username;
//    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username.getUserId();
    }
    
    /**
     * @param username to set
     */
    public void setUsername(AccountInfo accountInfo) {
        this.username = accountInfo;
    }

    /**
     * @return the ticketManagement
     */
    public List<TicketManagement> getTicketManagement() {
        return ticketManagement;
    }

    /**
     * @param ticketManagement the ticketManagement to set
     */
    public void setTicketManagement(List<TicketManagement> ticketManagement) {
        this.ticketManagement = ticketManagement;
    }

    /**
     * @return the cancelHistory
     */
    public List<CancelHistory> getCancelHistory() {
        return cancelHistory;
    }

    /**
     * @param cancelHistory the cancelHistory to set
     */
    public void setCancelHistory(List<CancelHistory> cancelHistory) {
        this.cancelHistory = cancelHistory;
    }
}
