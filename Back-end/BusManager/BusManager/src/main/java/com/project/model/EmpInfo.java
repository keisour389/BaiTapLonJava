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
@Table(name = "emp_info")
public class EmpInfo implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "PHONE_NUMBER", length = 100, nullable = false)
    private String phoneNumber;
    
    @JsonProperty("dob")
    @Column(name = "DOB", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthday;
    
    @JsonProperty("address")
    @Column(name = "ADDRESS",length = 200, nullable = false)
    private String address;
    
    @JsonProperty("id")
    @Column(name = "ID", length = 30, nullable = true)
    private String id;
    
    @JsonProperty("gender")
    @Column(name = "GENDER", length = 50, nullable = false)
    private String gender;
    
    @JsonProperty("type")
    @Column(name = "TYPE", nullable = false)
    private Integer type;
    
    @Column(name = "CREATED_ON", nullable = true)
    private LocalDateTime createdOn;
    
    @Column(name = "UPDATED_ON", nullable = true)
    private LocalDateTime updatedOn;

    @Column(name = "NOTE", length = 200, nullable = true)
    private String note;
    
    @JsonProperty("username")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USERNAME", referencedColumnName = "USER_ID", nullable = false)
    private AccountInfo username;
    
    @JsonIgnore
    @OneToMany(mappedBy = "empId", fetch = FetchType.LAZY)
    private List<CancelHistory> CancelHistory;
    
    @JsonIgnore
    @OneToMany(mappedBy = "empId", fetch = FetchType.LAZY)
    private List<Feedback> feedback;
            
    @JsonIgnore
    @OneToMany(mappedBy = "mainDriver", fetch = FetchType.LAZY)
    private List<BusSchedules> mainDriver;
    
    @JsonIgnore
    @OneToMany(mappedBy = "subDriver", fetch = FetchType.LAZY)
    private List<BusSchedules> subDriver;
    
    @JsonIgnore
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<BusSchedules> manager;

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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return the username
     */
    public AccountInfo getUsername() {
        return username;
    }
    
    /**
     * @param username to set
     */
    public void setUsername(String username) {
        AccountInfo newAccountInfo = new AccountInfo();
        newAccountInfo.setUserId(username);
        this.username = newAccountInfo;
    }

    /**
     * @return the CancelHistory
     */
    public List<CancelHistory> getCancelHistory() {
        return CancelHistory;
    }

    /**
     * @param CancelHistory the CancelHistory to set
     */
    public void setCancelHistory(List<CancelHistory> CancelHistory) {
        this.CancelHistory = CancelHistory;
    }

    /**
     * @return the feedback
     */
    public List<Feedback> getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    /**
     * @return the mainDriver
     */
    public List<BusSchedules> getMainDriver() {
        return mainDriver;
    }

    /**
     * @param mainDriver the mainDriver to set
     */
    public void setMainDriver(List<BusSchedules> mainDriver) {
        this.mainDriver = mainDriver;
    }

    /**
     * @return the subDriver
     */
    public List<BusSchedules> getSubDriver() {
        return subDriver;
    }

    /**
     * @param subDriver the subDriver to set
     */
    public void setSubDriver(List<BusSchedules> subDriver) {
        this.subDriver = subDriver;
    }

    /**
     * @return the manager
     */
    public List<BusSchedules> getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(List<BusSchedules> manager) {
        this.manager = manager;
    }
}
