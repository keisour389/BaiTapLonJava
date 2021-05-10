/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.request.BusSchedulesRequest;
import com.project.response.BusSchedulesResponse;
import com.project.response.CommonResponse;

/**
 *
 * @author DELL
 */
public interface BusSchedulesService {
    CommonResponse getAllBusSchedules(int page, int size);
    
    //Using getBusSchedulesById in Repository
    BusSchedulesResponse getBusSchedulesById(String id);
    
    BusSchedulesRequest createBusSchedules(BusSchedulesRequest busSchedules);
    BusSchedulesRequest updateBusSchedulesById(BusSchedulesRequest busSchedules);
    boolean deleteBusSchedulesById(String id);
}
