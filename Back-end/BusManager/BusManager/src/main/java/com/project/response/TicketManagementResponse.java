/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class TicketManagementResponse {
    private String seatId;
    private String price;
    private int status;
    private int payment;
    private Date paymentDate;
    private Date bookingDate;
    
    public TicketManagementResponse(){
    }
    
    public TicketManagementResponse(String seatId, String price, int status, 
            int payment, Date paymentDate, Date bookingDate){
        this.seatId = seatId;
        this.price = price;
        this.status = status;
        this.payment = payment;
        this.paymentDate = paymentDate;
        this.bookingDate = bookingDate;
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
}
