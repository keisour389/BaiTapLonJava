/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.request.TicketManagementRequest;
import com.project.response.TicketManagementResponse;

/**
 *
 * @author DELL
 */
public interface TicketManagementService {
    Object getAllTicketManagement(int page, int size);
    
    //Using getTicketManagementById in Repository
    TicketManagementResponse getTicketManagementById(String id);
    
    TicketManagementRequest createTicketManagement(TicketManagementRequest ticketManagement);
    TicketManagementRequest updateTicketManagementById(TicketManagementRequest ticketManagement);
    boolean deleteTicketManagementById(String id);
}
