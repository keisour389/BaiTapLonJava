/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.response;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class BusSchedulesResponse {
    private String licensePlates;
    private String mainDriver;
    private String subDriver;
    private String from;
    private String to;
    private Date departureDay;
    private int totalTime;
    private int status;
    private String vehicalType;
    private int totalSeats;
    private String manager;
    
    public BusSchedulesResponse(){
    }
    
    public BusSchedulesResponse(String licensePlates, String mainDriver,
                String subDriver, String from, String to, Date departureDay, int totalTime, 
                int status, String vehicalType, int totalSeats, String manager){
        this.licensePlates = licensePlates;
        this.mainDriver = mainDriver;
        this.subDriver = subDriver;
        this.from = from;
        this.to = to;
        this.departureDay = departureDay;
        this.totalTime = totalTime;
        this.status = status;
        this.vehicalType = vehicalType;
        this.totalSeats = totalSeats;
        this.manager = manager;
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
