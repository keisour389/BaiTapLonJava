/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.QuanLyChuyenXe;

/**
 *
 * @author Keisour
 */
public class HelloWorldBean {
    private String message;
    public HelloWorldBean(String message){
        this.message = message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
     /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    @Override
    public String toString() {
        return String.format("HelloBeanMessage [message=%s]", getMessage()); //To change body of generated methods, choose Tools | Templates.
    }
    
} 
