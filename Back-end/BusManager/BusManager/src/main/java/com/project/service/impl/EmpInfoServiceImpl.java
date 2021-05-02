/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.EmpInfo;
import com.project.repository.EmpInfoRepository;
import com.project.request.EmpInfoRequest;
import com.project.response.CommonResponse;
import com.project.service.EmpInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class EmpInfoServiceImpl implements EmpInfoService{
    @Autowired
    private EmpInfoRepository empInfoRepository;

    @Override
    public Object getAllEmpInfo(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = empInfoRepository.getAllEmpInfo();
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
    public EmpInfoRequest createEmpInfo(EmpInfoRequest empInfo) {
        EmpInfo newEmpInfo = new EmpInfo();
        newEmpInfo.setFirstName(empInfo.getFirstName());
        newEmpInfo.setLastName(empInfo.getLastName());
        newEmpInfo.setDisplayName(empInfo.getDisplayName());
        newEmpInfo.setPhoneNumber(empInfo.getPhoneNumber());
        newEmpInfo.setBirthday(empInfo.getBirthday());
        newEmpInfo.setAddress(empInfo.getAddress());
        newEmpInfo.setId(empInfo.getId());
        newEmpInfo.setGender(empInfo.getGender());
        newEmpInfo.setType(empInfo.getType());
        newEmpInfo.setCreatedOn(empInfo.getCreatedOn());
        newEmpInfo.setUpdatedOn(empInfo.getUpdatedOn());
        newEmpInfo.setNote(empInfo.getNote());
        newEmpInfo.setUsername(empInfo.getUsername());
        
        if(empInfoRepository.createEmpInfo(newEmpInfo) != null)
            return empInfo;
        else
            return null;
    }

    @Override
    public EmpInfoRequest updateEmpInfoById(String id, EmpInfoRequest empInfo) {
        EmpInfo newEmpInfo = new EmpInfo();
        newEmpInfo.setFirstName(empInfo.getFirstName());
        newEmpInfo.setLastName(empInfo.getLastName());
        newEmpInfo.setDisplayName(empInfo.getDisplayName());
        newEmpInfo.setPhoneNumber(empInfo.getPhoneNumber());
        newEmpInfo.setBirthday(empInfo.getBirthday());
        newEmpInfo.setAddress(empInfo.getAddress());
        newEmpInfo.setId(empInfo.getId());
        newEmpInfo.setGender(empInfo.getGender());
        newEmpInfo.setType(empInfo.getType());
        newEmpInfo.setCreatedOn(empInfo.getCreatedOn());
        newEmpInfo.setUpdatedOn(empInfo.getUpdatedOn());
        newEmpInfo.setNote(empInfo.getNote());
        newEmpInfo.setUsername(empInfo.getUsername());
        
        if(empInfoRepository.createEmpInfo(newEmpInfo) != null){
            empInfoRepository.updateEmpInfoById(id, newEmpInfo);
            return empInfo;
        }
        else
            return null;
    }

    @Override
    public boolean deleteEmpInfoById(String id) {
        if(empInfoRepository.getEmpInfoById(id) != null){
            empInfoRepository.deleteEmpInfoById(id);
            return true;
        }
        else
            return false;
    }
}
