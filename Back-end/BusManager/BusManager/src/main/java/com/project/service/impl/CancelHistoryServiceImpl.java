/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.CancelHistory;
import com.project.repository.CancelHistoryRepository;
import com.project.request.CancelHistoryRequest;
import com.project.response.CancelHistoryResponse;
import com.project.response.CommonResponse;
import com.project.service.CancelHistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class CancelHistoryServiceImpl implements CancelHistoryService{
    @Autowired
    private CancelHistoryRepository cancelHistoryRepository;

    @Override
    public Object getAllCancelHistory(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = cancelHistoryRepository.getAllCancelHistory();
        int offset = (page - 1) * size;
        int total = result.size();
        int totalPage = (total % size) == 0 ? (int)(total / size) : (int)((total / size) + 1);
        Object[] data = result.stream().skip(offset).limit(size).toArray();
        commonResponse.setData(data);
        commonResponse.setTotalPage(totalPage);
        commonResponse.setTotalRecord(total);
        commonResponse.setPage(page);
        commonResponse.setSize(size);
        
        return  commonResponse;
    }

    @Override
    public CancelHistoryRequest createCancelHistory(CancelHistoryRequest cancelHistory) {
        CancelHistory newCancelHistory = new CancelHistory();
        newCancelHistory.setCancelId(cancelHistory.getCancelId());
        newCancelHistory.setReason(cancelHistory.getReason());
        newCancelHistory.setNote(cancelHistory.getNote());
        newCancelHistory.setCusId(cancelHistory.getCusId());
        newCancelHistory.setEmpId(cancelHistory.getEmpId());
        newCancelHistory.setTicketId(cancelHistory.getTicketId());
        
        if(cancelHistoryRepository.createCancelHistory(newCancelHistory) != null)
            return cancelHistory;
        else
            return null;
    }

    @Override
    public CancelHistoryRequest updateCancelHistoryById(String id, CancelHistoryRequest cancelHistory) {
        CancelHistory newCancelHistory = new CancelHistory();
        newCancelHistory.setCancelId(cancelHistory.getCancelId());
        newCancelHistory.setReason(cancelHistory.getReason());
        newCancelHistory.setNote(cancelHistory.getNote());
        newCancelHistory.setCusId(cancelHistory.getCusId());
        newCancelHistory.setEmpId(cancelHistory.getEmpId());
        newCancelHistory.setTicketId(cancelHistory.getTicketId());
        
        if(cancelHistoryRepository.createCancelHistory(newCancelHistory) != null){
            cancelHistoryRepository.updateCancelHistoryById(id, newCancelHistory);
            return cancelHistory;
        }
        else
            return null;
    }

    @Override
    public boolean deleteCancelHistoryById(String id) {
        if(cancelHistoryRepository.getCancelHistoryById(id) != null){
            cancelHistoryRepository.deleteCancelHistoryById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public CancelHistoryResponse getCancelHistoryById(String id) {
        CancelHistory result = cancelHistoryRepository.getCancelHistoryById(id);
        if(result != null){
            CancelHistoryResponse cancelHistoryResponse = new CancelHistoryResponse();
            cancelHistoryResponse.setCancelId(result.getCancelId());
            cancelHistoryResponse.setReason(result.getReason());
            cancelHistoryResponse.setCusId(result.getCusId().toString());
            cancelHistoryResponse.setEmpId(result.getEmpId().toString());
            cancelHistoryResponse.setTicketId(result.getTicketId().toString());
            
            return cancelHistoryResponse;
        }
        else
            return null;
    }
}
