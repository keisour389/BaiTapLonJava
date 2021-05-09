/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

/**
 *
 * @author DELL
 */

@JsonPropertyOrder({
    "data",
    "totalRecord",
    "page",
    "size",
    "totalPage"
})

public class CommonResponse implements Serializable{
    private Object[] data;
    private int totalRecord;
    private int page;
    private int size;
    private int totalPage;
    
    public CommonResponse(){
    
    }
    
    public CommonResponse(Object[] data, int totalRecord, int page, int size, int totalPage){
        this.data = data;
        this.totalRecord = totalRecord;
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
    }

    /**
     * @return the data
     */
    public Object[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object[] data) {
        this.data = data;
    }

    /**
     * @return the totalRecord
     */
    public int getTotalRecord() {
        return totalRecord;
    }

    /**
     * @param totalRecord the totalRecord to set
     */
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the totalPage
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * @param totalPage the totalPage to set
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
