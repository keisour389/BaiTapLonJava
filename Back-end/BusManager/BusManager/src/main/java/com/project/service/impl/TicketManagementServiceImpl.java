/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.TicketManagement;
import com.project.repository.TicketManagementRepository;
import com.project.request.TicketManagementRequest;
import com.project.response.CommonResponse;
import com.project.service.TicketManagementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class TicketManagementServiceImpl implements TicketManagementService{
    @Autowired
    private TicketManagementRepository ticketManagementRepository;

    @Override
    public Object getAllTicketManagement(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = ticketManagementRepository.getAllTicketManagement();
        int offset = (page - 1) * size;
        int total = result.size();
        int totalPage = (total % size) == 0 ? (int)(total / size) : (int)((total / size) + 1);
        Object[] data = result.stream().skip(offset).limit(size).toArray();
        commonResponse.setData(data);
        commonResponse.setTotalPage(totalPage);
        commonResponse.setTotalPage(total);
        commonResponse.setTotalPage(page);
        commonResponse.setTotalPage(size);
        
        return  commonResponse;
    }

    @Override
    public TicketManagementRequest createTicketManagement(TicketManagementRequest ticketManagement) {
        TicketManagement newTicketManagement = new TicketManagement();
        newTicketManagement.setTicketId(ticketManagement.getTicketId());
        newTicketManagement.setSeatId(ticketManagement.getSeatId());
        newTicketManagement.setPrice(ticketManagement.getPrice());
        newTicketManagement.setStatus(ticketManagement.getStatus());
        newTicketManagement.setPayment(ticketManagement.getPayment());
        newTicketManagement.setPaymentDate(ticketManagement.getPaymentDate());
        newTicketManagement.setBookingDate(ticketManagement.getBookingDate());
        newTicketManagement.setNote(ticketManagement.getNote());
        newTicketManagement.setTripId(ticketManagement.getTripId());
        newTicketManagement.setCusId(ticketManagement.getCusId());
        
        if(ticketManagementRepository.createTicketManagement(newTicketManagement) != null)
            return ticketManagement;
        else
            return null;
    }

    @Override
    public TicketManagementRequest updateTicketManagementById(String id, TicketManagementRequest ticketManagement) {
        TicketManagement newTicketManagement = new TicketManagement();
        newTicketManagement.setTicketId(ticketManagement.getTicketId());
        newTicketManagement.setSeatId(ticketManagement.getSeatId());
        newTicketManagement.setPrice(ticketManagement.getPrice());
        newTicketManagement.setStatus(ticketManagement.getStatus());
        newTicketManagement.setPayment(ticketManagement.getPayment());
        newTicketManagement.setPaymentDate(ticketManagement.getPaymentDate());
        newTicketManagement.setBookingDate(ticketManagement.getBookingDate());
        newTicketManagement.setNote(ticketManagement.getNote());
        newTicketManagement.setTripId(ticketManagement.getTripId());
        newTicketManagement.setCusId(ticketManagement.getCusId());
        
        if(ticketManagementRepository.createTicketManagement(newTicketManagement) != null){
            ticketManagementRepository.updateTicketManagementById(id, newTicketManagement);
            return ticketManagement;
        }
        else
            return null;
    }

    @Override
    public boolean deleteTicketManagementById(String id) {
        if(ticketManagementRepository.getTicketManagementById(id) != null){
            ticketManagementRepository.deleteTicketManagementById(id);
            return true;
        }
        else
            return false;
    }
}
