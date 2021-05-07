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
    private int type;
    private int status;
    
    public AccountInfoResponse(){
    }
    
    public AccountInfoResponse(int type, int status){
        this.type = type;
        this.status = status;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
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
}
