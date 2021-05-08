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
    @Column(name="TRIP_ID", length = 20, nullable = false)
    private String tripId;
    
    @JsonProperty("license_plates")
    @Column(name="LICENSE_PLATES", length = 20, nullable = false)
    private String licensePlates;
    
    @JsonProperty("main_driver")
    @ManyToOne
//    fetch = FetchType.EAGER
    @JoinColumn(name="MAIN_DRIVER", nullable = false)
    private EmpInfo mainDriver;
    
    @JsonProperty("sub_driver")
    @ManyToOne
//    fetch = FetchType.EAGER
    @JoinColumn(name="SUB_DRIVER", nullable = false)
    private EmpInfo subDriver;
    
    @JsonProperty("start")
    @Column(name="START", length = 100, nullable = false)
    private String start;
    
    @JsonProperty("destination")
    @Column(name="DESTINATION", length = 100, nullable = false)
    private String destination;
    
    @JsonProperty("departure_day")
    @Column(name="DEPARTURE_DAY", nullable = false)
    private LocalDateTime departureDay;
    
    @JsonProperty("total_time")
    @Column(name="TOTAL_TIME", nullable = false)
    private int totalTime;
    
    @JsonProperty("status")
    @Column(name="STATUS", nullable = false)
    private int status;
     
    @JsonProperty("vehical_type")
    @Column(name="VEHICLE_TYPE", length = 100, nullable = false)
    private String vehicleType;
    
    @JsonProperty("total_seat")
    @Column(name="TOTAL_SEATS", nullable = false)
    private int totalSeats;
    
    @Column(name="CREATED_ON", nullable = true)
    private LocalDateTime createdOn;
    
    @Column(name="UPDATED_ON", nullable = true)
    private LocalDateTime updatedOn;
    
    @Column(name="NOTE", length = 200, nullable = true)
    private String note;
    
    @JsonProperty("manager")
    @ManyToOne
//    fetch = FetchType.EAGER
    @JoinColumn(name="MANAGER", nullable = false)
    private EmpInfo manager;
    
    @JsonIgnore
    @OneToMany(mappedBy = "tripId")
//    fetch = FetchType.EAGER
    private List<TicketManagement> ticketManagement;
    
    public BusSchedules(){
        
    }

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
     * @param mainDriver to set
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
     * @param subDriver to set
     */
    public void setSubDriver(EmpInfo subDriver) {
        this.subDriver = mainDriver;
    }

    /**
     * @return the from
     */
    public String getStart() {
        return start;
    }

    /**
     * @param start the from to set
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return the to
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the to to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the departureDay
     */
    public LocalDateTime getDepartureDay() {
        return departureDay;
    }

    /**
     * @param departureDay the departureDay to set
     */
    public void setDepartureDay(LocalDateTime departureDay) {
        this.departureDay = departureDay;
    }

    /**
     * @return the totalTime
     */
    public int getTotalTime() {
        return totalTime;
    }

    /**
     * @param totalTime the totalTime to set
     */
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
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
     * @return the vehicalType
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * @param vehicleType the vehicalType to set
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * @return the totalSeats
     */
    public int getTotalSeats() {
        return totalSeats;
    }

    /**
     * @param totalSeats the totalSeats to set
     */
    public void setTotalSeats(int totalSeats) {
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
     * @param manager to set
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
