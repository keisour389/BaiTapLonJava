/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.BusSchedules;
import com.project.model.EmpInfo;
import com.project.repository.BusSchedulesRepository;
import com.project.repository.EmpInfoRepository;
import com.project.request.BusSchedulesRequest;
import com.project.response.BusSchedulesResponse;
import com.project.response.CommonResponse;
import com.project.service.BusSchedulesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BusSchedulesServiceImpl implements BusSchedulesService {

    @Autowired
    private BusSchedulesRepository busSchedulesRepository;

    @Autowired
    private EmpInfoRepository empInfoRepository;

    @Override
    public CommonResponse getAllBusSchedules(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = busSchedulesRepository.getAllBusSchedules();
        int offset = (page - 1) * size;
        int total = result.size();
        int totalPage = (total % size) == 0 ? (int) (total / size) : (int) ((total / size) + 1);
        Object[] data = result.stream().skip(offset).limit(size).toArray();
        commonResponse.setData(data);
        commonResponse.setTotalPage(totalPage);
        commonResponse.setTotalRecord(total);
        commonResponse.setPage(page);
        commonResponse.setSize(size);

        return commonResponse;
    }

    @Override
    public BusSchedulesRequest createBusSchedules(BusSchedulesRequest busSchedules) {
        EmpInfo driver = new EmpInfo();
        EmpInfo subDriver = new EmpInfo();
        EmpInfo manager = new EmpInfo();
        BusSchedules newBusSchedules = new BusSchedules();

        driver = empInfoRepository.getEmpInfoById(busSchedules.getMainDriver());
        subDriver = empInfoRepository.getEmpInfoById(busSchedules.getSubDriver());
        manager = empInfoRepository.getEmpInfoById(busSchedules.getManager());

        newBusSchedules.setTripId(busSchedules.getTripId());
        newBusSchedules.setLicensePlates(busSchedules.getLicensePlates());
        newBusSchedules.setMainDriver(driver);
        newBusSchedules.setSubDriver(subDriver);
        newBusSchedules.setStart(busSchedules.getStart());
        newBusSchedules.setDestination(busSchedules.getDestination());
        newBusSchedules.setDepartureDay(busSchedules.getDepartureDay());
        newBusSchedules.setTotalTime(busSchedules.getTotalTime());
        newBusSchedules.setStatus(busSchedules.getStatus());
        newBusSchedules.setVehicleType(busSchedules.getVehicleType());
        newBusSchedules.setTotalSeats(busSchedules.getTotalSeats());
        newBusSchedules.setCreatedOn(busSchedules.getCreatedOn());
        newBusSchedules.setUpdatedOn(busSchedules.getUpdatedOn());
        newBusSchedules.setNote(busSchedules.getNote());
        newBusSchedules.setManager(manager);
        
//        return busSchedulesRepository.createBusSchedules(newBusSchedules);

        if (busSchedulesRepository.createBusSchedules(newBusSchedules) != null) {
            return busSchedules;
        } else {
            return null;
        }
    }

    @Override
    public BusSchedulesRequest updateBusSchedulesById(BusSchedulesRequest busSchedules) {
        EmpInfo driver = new EmpInfo();
        EmpInfo subDriver = new EmpInfo();
        EmpInfo manager = new EmpInfo();
        BusSchedules newBusSchedules = new BusSchedules();

        driver = empInfoRepository.getEmpInfoById(busSchedules.getMainDriver());
        subDriver = empInfoRepository.getEmpInfoById(busSchedules.getMainDriver());
        manager = empInfoRepository.getEmpInfoById(busSchedules.getMainDriver());
        
        newBusSchedules.setTripId(busSchedules.getTripId());
        newBusSchedules.setLicensePlates(busSchedules.getLicensePlates());
        newBusSchedules.setMainDriver(driver);
        newBusSchedules.setSubDriver(subDriver);
        newBusSchedules.setStart(busSchedules.getStart());
        newBusSchedules.setDestination(busSchedules.getDestination());
        newBusSchedules.setDepartureDay(busSchedules.getDepartureDay());
        newBusSchedules.setTotalTime(busSchedules.getTotalTime());
        newBusSchedules.setStatus(busSchedules.getStatus());
        newBusSchedules.setVehicleType(busSchedules.getVehicleType());
        newBusSchedules.setTotalSeats(busSchedules.getTotalSeats());
        newBusSchedules.setCreatedOn(busSchedules.getCreatedOn());
        newBusSchedules.setUpdatedOn(busSchedules.getUpdatedOn());
        newBusSchedules.setNote(busSchedules.getNote());
        newBusSchedules.setManager(manager);

        if (busSchedulesRepository.createBusSchedules(newBusSchedules) != null) {
            busSchedulesRepository.updateBusSchedulesById(newBusSchedules);
            return busSchedules;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteBusSchedulesById(String id) {
        if (busSchedulesRepository.getBusSchedulesById(id) != null) {
            busSchedulesRepository.deleteBusSchedulesById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BusSchedulesResponse getBusSchedulesById(String id) {
        //Don't get the object, just get the id of the foreign key
        BusSchedulesResponse result = busSchedulesRepository.getBusSchedulesById(id);
        if (result != null) {
            return result;
        } else {
            return null;
        }
    }
}
