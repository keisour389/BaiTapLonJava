/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.response;

/**
 *
 * @author DELL
 */
public class CancelHistoryResponse {
    private String reason;
    
    public CancelHistoryResponse(){
    }
    
    public CancelHistoryResponse(String reason){
        this.reason = reason;
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
}
