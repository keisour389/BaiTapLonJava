/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository;

import com.project.model.BusSchedules;
import com.project.response.BusSchedulesResponse;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BusSchedulesRepository {
    List getAllBusSchedules();
    List getBusSchedulesByDestination(String dest);
    BusSchedules getBusSchedulesById(String id);
    BusSchedules createBusSchedules(BusSchedules busSchedules);
    boolean busSchedulesIsExist(String id);
    void updateBusSchedulesById(String id, BusSchedules busSchedules);
    void deleteBusSchedulesById(String id);
}
