/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.request.CancelHistoryRequest;

/**
 *
 * @author DELL
 */
public interface CancelHistoryService {
    Object getAllCancelHistory(int page, int size);
    
    //Using getCancelHistoryById in Repository
    //CancelHistoryResponse getCancelHistoryById(String id);
    
    CancelHistoryRequest createCancelHistory(CancelHistoryRequest cancelHistory);
    CancelHistoryRequest updateCancelHistoryById(String id, CancelHistoryRequest cancelHistory);
    boolean deleteCancelHistoryById(String id);
}
