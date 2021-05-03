/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.CusInfo;
import com.project.repository.CusInfoRepository;
import com.project.request.CusInfoRequest;
import com.project.response.CommonResponse;
import com.project.service.CusInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class CusInfoServiceImpl implements CusInfoService{
    @Autowired
    private CusInfoRepository cusInfoRepository;

    @Override
    public Object getAllCusInfo(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = cusInfoRepository.getAllCusInfo();
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
    public CusInfoRequest createCusInfo(CusInfoRequest cusInfo) {
        CusInfo newCusInfo = new CusInfo();
        newCusInfo.setFirstName(cusInfo.getFirstName());
        newCusInfo.setLastName(cusInfo.getLastName());
        newCusInfo.setDisplayName(cusInfo.getDisplayName());
        newCusInfo.setPhoneNumber(cusInfo.getPhoneNumber());
        newCusInfo.setBirthday(cusInfo.getBirthday());
        newCusInfo.setGender(cusInfo.getGender());
        newCusInfo.setCreatedOn(cusInfo.getCreatedOn());
        newCusInfo.setUpdatedOn(cusInfo.getUpdatedOn());
        newCusInfo.setNote(cusInfo.getNote());
        newCusInfo.setUsername(cusInfo.getUsername());
        
        if(cusInfoRepository.createCusInfo(newCusInfo) != null)
            return cusInfo;
        else
            return null;
    }

    @Override
    public CusInfoRequest updateCusInfoById(String id, CusInfoRequest cusInfo) {
        CusInfo newCusInfo = new CusInfo();
        newCusInfo.setFirstName(cusInfo.getFirstName());
        newCusInfo.setLastName(cusInfo.getLastName());
        newCusInfo.setDisplayName(cusInfo.getDisplayName());
        newCusInfo.setPhoneNumber(cusInfo.getPhoneNumber());
        newCusInfo.setBirthday(cusInfo.getBirthday());
        newCusInfo.setGender(cusInfo.getGender());
        newCusInfo.setCreatedOn(cusInfo.getCreatedOn());
        newCusInfo.setUpdatedOn(cusInfo.getUpdatedOn());
        newCusInfo.setNote(cusInfo.getNote());
        newCusInfo.setUsername(cusInfo.getUsername());
        
        if(cusInfoRepository.createCusInfo(newCusInfo) != null){
            cusInfoRepository.updateCusInfoById(id, newCusInfo);
            return cusInfo;
        }
        else
            return null;
    }

    @Override
    public boolean deleteCusInfoById(String id) {
        if(cusInfoRepository.getCusInfoById(id) != null){
            cusInfoRepository.deleteCusInfoById(id);
            return true;
        }
        else
            return false;
    }
}
