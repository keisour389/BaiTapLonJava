/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.BusSchedules;
import com.project.model.CusInfo;
import com.project.model.TicketManagement;
import com.project.repository.BusSchedulesRepository;
import com.project.repository.CusInfoRepository;
import com.project.repository.TicketManagementRepository;
import com.project.request.TicketManagementRequest;
import com.project.response.CommonResponse;
import com.project.response.TicketManagementResponse;
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
    
    @Autowired
    private CusInfoRepository cusInfoRepository; 
    
    @Autowired
    private BusSchedulesRepository busSchedulesRepository; 

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
        commonResponse.setTotalRecord(total);
        commonResponse.setPage(page);
        commonResponse.setSize(size);
        
        return commonResponse;
    }

    @Override
    public TicketManagementRequest createTicketManagement(TicketManagementRequest ticketManagement) {
        BusSchedules trip = new BusSchedules();
        CusInfo cus = new CusInfo();

        TicketManagement newTicketManagement = new TicketManagement();
        
        trip = busSchedulesRepository.getBusSchedulesById(ticketManagement.getTripId());
        cus = cusInfoRepository.getCusInfoById(ticketManagement.getCusId());
        
        newTicketManagement.setTicketId(ticketManagement.getTicketId());
        newTicketManagement.setSeatId(ticketManagement.getSeatId());   
        newTicketManagement.setStatus(ticketManagement.getStatus());
        newTicketManagement.setPayment(ticketManagement.getPayment());
        newTicketManagement.setPaymentDate(ticketManagement.getPaymentDate());
        newTicketManagement.setBookingDate(ticketManagement.getBookingDate());
        newTicketManagement.setNote(ticketManagement.getNote());
        newTicketManagement.setTripId(trip);
        newTicketManagement.setCusId(cus);
        
        if(!ticketManagementRepository.ticketManagementIsExist(ticketManagement.getTicketId())){
            if(ticketManagementRepository.createTicketManagement(newTicketManagement) != null)
                return ticketManagement;
            else
                return null;
        }
        else
            return null;
    }

    @Override
    public TicketManagementRequest updateTicketManagementById(TicketManagementRequest ticketManagement) {
        BusSchedules trip = new BusSchedules();
        CusInfo cus = new CusInfo();

        TicketManagement newTicketManagement = new TicketManagement();
        
        trip = busSchedulesRepository.getBusSchedulesById(ticketManagement.getTripId());
        cus = cusInfoRepository.getCusInfoById(ticketManagement.getCusId());

//        newTicketManagement.setTicketId(ticketManagement.getTicketId());
        newTicketManagement.setSeatId(ticketManagement.getSeatId());
        newTicketManagement.setStatus(ticketManagement.getStatus());
        newTicketManagement.setPayment(ticketManagement.getPayment());
        newTicketManagement.setPaymentDate(ticketManagement.getPaymentDate());
        newTicketManagement.setBookingDate(ticketManagement.getBookingDate());
        newTicketManagement.setNote(ticketManagement.getNote());
        newTicketManagement.setTripId(trip);
        newTicketManagement.setCusId(cus);
        
        if(ticketManagementRepository.getTicketManagementById(newTicketManagement.getTicketId()) != null){
            ticketManagementRepository.updateTicketManagementById(newTicketManagement);
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

    @Override
    public TicketManagementResponse getTicketManagementById(String id) {
        TicketManagement result = ticketManagementRepository.getTicketManagementById(id);
        if(result != null){
            TicketManagementResponse ticketManagementResponse = new TicketManagementResponse();
            ticketManagementResponse.setTicketId(result.getTicketId());
            ticketManagementResponse.setSeatId(result.getSeatId());
            ticketManagementResponse.setStatus(result.getStatus());
            ticketManagementResponse.setPayment(result.getPayment());
            ticketManagementResponse.setPaymentDate(result.getPaymentDate());
            ticketManagementResponse.setBookingDate(result.getBookingDate());
            ticketManagementResponse.setNote(result.getNote());
            ticketManagementResponse.setTripId(result.getTripId());
            ticketManagementResponse.setCusId(result.getCusId());
            
            return ticketManagementResponse;
        }
        else
            return null;
    }
}
