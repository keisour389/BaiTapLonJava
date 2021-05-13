/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository;

import com.project.model.TicketManagement;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface TicketManagementRepository{
    List getAllTicketManagement();
    TicketManagement getTicketManagementById(String id);
    TicketManagement createTicketManagement(TicketManagement ticketManagement);
    boolean ticketManagementIsExist(String id);
    void updateTicketManagementById(TicketManagement ticketManagement);
    void deleteTicketManagementById(String id);
}
