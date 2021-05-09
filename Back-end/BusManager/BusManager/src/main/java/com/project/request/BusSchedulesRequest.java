/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.request;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class BusSchedulesRequest {
    private String tripId;
    private String licensePlates;
    private String mainDriver;
    private String subDriver;
    private String start;
    private String destination;
    private LocalDateTime departureDay;
    private int totalTime;
    private int status;
    private String vehicleType;
    private int totalSeats;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private String note;
    private String manager;
    
    public BusSchedulesRequest(){
    }
    
    public BusSchedulesRequest(String tripId, String licensePlates, String mainDriver,
                String subDriver, String start, String destination, LocalDateTime departureDay, int totalTime, 
                int status, String vehicleType, int totalSeats, LocalDateTime createdOn, 
                LocalDateTime updatedOn, String note, String manager){
        this.tripId = tripId;
        this.licensePlates = licensePlates;
        this.mainDriver = mainDriver;
        this.subDriver = subDriver;
        this.start = start;
        this.destination = destination;
        this.departureDay = departureDay;
        this.totalTime = totalTime;
        this.status = status;
        this.vehicleType = vehicleType;
        this.totalSeats = totalSeats;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.note = note;
        this.manager = manager;
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
     * @return the start
     */
    public String getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
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
     * @return the vehicleType
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * @param vehicleType the vehicleType to set
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
     * @return the mainDriver
     */
    public String getMainDriver() {
        return mainDriver;
    }

    /**
     * @param mainDriver the mainDriver to set
     */
    public void setMainDriver(String mainDriver) {
        this.mainDriver = mainDriver;
    }

    /**
     * @return the subDriver
     */
    public String getSubDriver() {
        return subDriver;
    }

    /**
     * @param subDriver the subDriver to set
     */
    public void setSubDriver(String subDriver) {
        this.subDriver = subDriver;
    }

    /**
     * @return the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(String manager) {
        this.manager = manager;
    }
}
