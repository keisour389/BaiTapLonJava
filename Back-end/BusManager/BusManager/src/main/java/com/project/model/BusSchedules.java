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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author DELL
 */
@Entity
@Table(name="bus_schedules")
public class BusSchedules implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TRIP_ID", length = 20)
    private String tripId;
    
    @JsonProperty("license_plates")
    @Column(name="LICENSE_PLATES", length = 20, nullable = false)
    private String licensePlates;
    
    @JsonProperty("main_driver")
    @ManyToOne
    @JoinColumn(name="MAIN_DRIVER")
    private EmpInfo mainDriver;
    
    @JsonProperty("sub_driver")
    @ManyToOne
    @JoinColumn(name="SUB_DRIVER")
    private EmpInfo subDriver;
    
    @JsonProperty("from")
    @Column(name="FROM", length = 100, nullable = false)
    private String from;
    
    @JsonProperty("to")
    @Column(name="TO", length = 100, nullable = false)
    private String to;
    
    @JsonProperty("departure_day")
    @Column(name="DEPARTURE_DAY", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDay;
    
    @JsonProperty("total_time")
    @Column(name="TOTAL_TIME", nullable = false)
    private Integer totalTime;
    
    @JsonProperty("status")
    @Column(name="STATUS", nullable = false)
    private Integer status;
     
    @JsonProperty("vehical_type")
    @Column(name="VEHICAL_TYPE", length = 100, nullable = false)
    private String vehicalType;
    
    @JsonProperty("total_seat")
    @Column(name="TOTAL_SEATS", nullable = false)
    private Integer totalSeats;
    
    @Column(name="CREATED_ON", nullable = true)
    private LocalDateTime createdOn;
    
    @Column(name="UPDATED_ON", nullable = true)
    private LocalDateTime updatedOn;
    
    @Column(name="NOTE", length = 200, nullable = true)
    private String note;
    
    @ManyToOne
    @JoinColumn(name="MANAGER")
    private EmpInfo manager;
    
    @JsonIgnore
    @OneToMany(mappedBy = "bus_schedules", fetch = FetchType.EAGER)
    private List<TicketManagement> ticketManagement = new ArrayList<>();

    /**
     * @return the tripId
     */
    public String getTripId() {
        return tripId;
    }

    /**
     * @param tripId the tripId to set
     */
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    /**
     * @return the licensePlates
     */
    public String getLicensePlates() {
        return licensePlates;
    }

    /**
     * @param licensePlates the licensePlates to set
     */
    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    /**
     * @return the mainDriver
     */
    public EmpInfo getMainDriver() {
        return mainDriver;
    }

    /**
     * @param mainDriver the mainDriver to set
     */
    public void setMainDriver(EmpInfo mainDriver) {
        this.mainDriver = mainDriver;
    }

    /**
     * @return the subDriver
     */
    public EmpInfo getSubDriver() {
        return subDriver;
    }

    /**
     * @param subDriver the subDriver to set
     */
    public void setSubDriver(EmpInfo subDriver) {
        this.subDriver = subDriver;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the departureDay
     */
    public Date getDepartureDay() {
        return departureDay;
    }

    /**
     * @param departureDay the departureDay to set
     */
    public void setDepartureDay(Date departureDay) {
        this.departureDay = departureDay;
    }

    /**
     * @return the totalTime
     */
    public Integer getTotalTime() {
        return totalTime;
    }

    /**
     * @param totalTime the totalTime to set
     */
    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
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
     * @return the vehicalType
     */
    public String getVehicalType() {
        return vehicalType;
    }

    /**
     * @param vehicalType the vehicalType to set
     */
    public void setVehicalType(String vehicalType) {
        this.vehicalType = vehicalType;
    }

    /**
     * @return the totalSeats
     */
    public Integer getTotalSeats() {
        return totalSeats;
    }

    /**
     * @param totalSeats the totalSeats to set
     */
    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
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
     * @return the manager
     */
    public EmpInfo getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(EmpInfo manager) {
        this.manager = manager;
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

    
}
