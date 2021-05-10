/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.CancelHistory;
import com.project.model.CusInfo;
import com.project.model.EmpInfo;
import com.project.model.TicketManagement;
import com.project.repository.CancelHistoryRepository;
import com.project.repository.CusInfoRepository;
import com.project.repository.EmpInfoRepository;
import com.project.repository.TicketManagementRepository;
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
    
    @Autowired
    private CusInfoRepository cusInfoRepository; 
    
    @Autowired
    private EmpInfoRepository empInfoRepository; 
    
    @Autowired
    private TicketManagementRepository ticketManagementRepository; 

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
        CusInfo cus = new CusInfo();
        EmpInfo emp = new EmpInfo();
        TicketManagement ticket = new TicketManagement();
        
        CancelHistory newCancelHistory = new CancelHistory();
        
        cus = cusInfoRepository.getCusInfoById(cancelHistory.getCusId());
        emp = empInfoRepository.getEmpInfoById(cancelHistory.getEmpId());
        ticket = ticketManagementRepository.getTicketManagementById(cancelHistory.getTicketId());
        
        newCancelHistory.setCancelId(cancelHistory.getCancelId());
        newCancelHistory.setReason(cancelHistory.getReason());
        newCancelHistory.setNote(cancelHistory.getNote());
        newCancelHistory.setCusId(cus);
        newCancelHistory.setEmpId(emp);
        newCancelHistory.setTicketId(ticket);
        
        if(cancelHistoryRepository.createCancelHistory(newCancelHistory) != null)
            return cancelHistory;
        else
            return null;
    }

    @Override
    public CancelHistoryRequest updateCancelHistoryById(CancelHistoryRequest cancelHistory) {
        CusInfo cus = new CusInfo();
        EmpInfo emp = new EmpInfo();
        TicketManagement ticket = new TicketManagement();
        
        CancelHistory newCancelHistory = new CancelHistory();
        
        cus = cusInfoRepository.getCusInfoById(cancelHistory.getCusId());
        emp = empInfoRepository.getEmpInfoById(cancelHistory.getEmpId());
        ticket = ticketManagementRepository.getTicketManagementById(cancelHistory.getTicketId());
        
        newCancelHistory.setCancelId(cancelHistory.getCancelId());
        newCancelHistory.setReason(cancelHistory.getReason());
        newCancelHistory.setNote(cancelHistory.getNote());
        newCancelHistory.setCusId(cus);
        newCancelHistory.setEmpId(emp);
        newCancelHistory.setTicketId(ticket);
        
        if(cancelHistoryRepository.createCancelHistory(newCancelHistory) != null){
            cancelHistoryRepository.updateCancelHistoryById(newCancelHistory);
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
            cancelHistoryResponse.setCusId(result.getCusId());
            cancelHistoryResponse.setEmpId(result.getEmpId());
            cancelHistoryResponse.setTicketId(result.getTicketId());
            
            return cancelHistoryResponse;
        }
        else
            return null;
    }
}
