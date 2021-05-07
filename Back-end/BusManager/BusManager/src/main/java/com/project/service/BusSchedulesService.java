/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.request.BusSchedulesRequest;
import com.project.response.BusSchedulesResponse;

/**
 *
 * @author DELL
 */
public interface BusSchedulesService {
    Object getAllBusSchedules(int page, int size);
    
    //Using getBusSchedulesById in Repository
    BusSchedulesResponse getBusSchedulesById(String id);
    
    BusSchedulesRequest createBusSchedules(BusSchedulesRequest busSchedules);
    BusSchedulesRequest updateBusSchedulesById(String id, BusSchedulesRequest busSchedules);
    boolean deleteBusSchedulesById(String id);
}
