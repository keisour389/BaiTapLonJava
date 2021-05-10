/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ticket_management")
public class TicketManagement implements Serializable {
    @Id
    @Column(name = "TICKET_ID", length = 20, nullable = false)
    private String ticketId;
    
    @JsonProperty("seat_id")
    @Column(name = "SEAT_ID", length = 30, nullable = false)
    private String seatId;
    
    @JsonProperty("price")
    @Column(name = "PRICE", length = 45, nullable = false)
    private String price;
    
    @JsonProperty("status")
    @Column(name = "STATUS", nullable = false)
    private int status;
    
    @JsonProperty("payment")
    @Column(name = "PAYMENT", nullable = true)
    private int payment;
    
    @JsonProperty("payment_date")
    @Column(name = "PAYMENT_DATE", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date paymentDate;
    
    @JsonProperty("booking_date")
    @Column(name = "BOOKING_DATE", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bookingDate;
    
    @Column(name = "NOTE", length = 200, nullable = true)
    private String note;
    
    @ManyToOne
//    fetch = FetchType.LAZY
    @JoinColumn(name = "TRIP_ID", nullable = true)
    private BusSchedules tripId;
    
    @ManyToOne
//    fetch = FetchType.LAZY
    @JoinColumn(name = "CUS_ID", nullable = true)
    private CusInfo cusId;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ticketId")
//    fetch = FetchType.EAGER
    private List<CancelHistory> cancelHistory = new ArrayList<>();

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

    /**
     * @return the seatId
     */
    public String getSeatId() {
        return seatId;
    }

    /**
     * @param seatId the seatId to set
     */
    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
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
     * @return the payment
     */
    public int getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(int payment) {
        this.payment = payment;
    }

    /**
     * @return the paymentDate
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the bookingDate
     */
    public Date getBookingDate() {
        return bookingDate;
    }

    /**
     * @param bookingDate the bookingDate to set
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
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
//     * @return the tripId
//     */
//    public BusSchedules getTripId() {
//        return tripId;
//    }
    
    /**
     * @return the tripId
     */
    public String getTripId() {
        return tripId.getTripId();
    }
    
//    /**
//     * @param tripId to set
//     */
//    public void setTripId(String tripId) {
//        BusSchedules newBusSchedules = new BusSchedules();
//        newBusSchedules.setTripId(tripId);
//        this.setTripId(newBusSchedules);
//    }
    
    /**
     * @param tripId the tripId to set
     */
    public void setTripId(BusSchedules tripId) {
        this.tripId = tripId;
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
    
//    /**
//     * @param cusId to set
//     */
//    public void setCusId(String cusId) {
//        CusInfo newCusInfo = new CusInfo();
//        newCusInfo.setUserId(cusId);
//        this.setCusId(newCusInfo);
//    }
    
    /**
     * @param cusId the cusId to set
     */
    public void setCusId(CusInfo cusId) {
        this.cusId = cusId;
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
