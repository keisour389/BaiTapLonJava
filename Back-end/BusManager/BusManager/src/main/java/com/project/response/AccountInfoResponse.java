/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.response;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author DELL
 */
public class AccountInfoResponse implements Serializable{
    private String type;
    private String status;
    
    public AccountInfoResponse(){
    }
    
    public AccountInfoResponse(String type, String status){
        this.type = type;
        this.status = status;
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
}
