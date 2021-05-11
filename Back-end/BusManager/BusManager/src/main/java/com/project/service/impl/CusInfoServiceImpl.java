/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.AccountInfo;
import com.project.model.CusInfo;
import com.project.repository.AccountInfoRepository;
import com.project.repository.CusInfoRepository;
import com.project.repository.impl.AccountInfoRepositoryImpl;
import com.project.request.CusInfoRequest;
import com.project.response.AccountInfoResponse;
import com.project.response.CommonResponse;
import com.project.response.CusInfoResponse;
import com.project.service.CusInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class CusInfoServiceImpl implements CusInfoService {

    @Autowired
    private CusInfoRepository cusInfoRepository;
    
    @Autowired
    private AccountInfoRepository accountInfoResitory;

    @Override
    public Object getAllCusInfo(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = cusInfoRepository.getAllCusInfo();
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
    public CusInfoRequest createCusInfo(CusInfoRequest cusInfo) {
        AccountInfo accountInfo = new AccountInfo();
        CusInfo newCusInfo = new CusInfo();
        accountInfo = accountInfoResitory.getAccountInfoById(cusInfo.getUsername());

        newCusInfo.setUserId(cusInfo.getUserId());
        newCusInfo.setFirstName(cusInfo.getFirstName());
        newCusInfo.setLastName(cusInfo.getLastName());
        newCusInfo.setDisplayName(cusInfo.getDisplayName());
        newCusInfo.setPhoneNumber(cusInfo.getPhoneNumber());
        newCusInfo.setBirthday(cusInfo.getBirthday());
        newCusInfo.setGender(cusInfo.getGender());
        newCusInfo.setCreatedOn(cusInfo.getCreatedOn());
        newCusInfo.setUpdatedOn(cusInfo.getUpdatedOn());
        newCusInfo.setNote(cusInfo.getNote());
        newCusInfo.setUsername(accountInfo);
        
        if(!cusInfoRepository.cusInfoIsExist(cusInfo.getUsername())){
            if (cusInfoRepository.createCusInfo(newCusInfo) != null) {
                return cusInfo;
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public CusInfoRequest updateCusInfoById(CusInfoRequest cusInfo) {
        AccountInfo accountInfo = new AccountInfo();
        CusInfo newCusInfo = new CusInfo();
        accountInfo = accountInfoResitory.getAccountInfoById(cusInfo.getUserId());
        
//        newCusInfo.setUserId(cusInfo.getUserId());
        newCusInfo.setFirstName(cusInfo.getFirstName());
        newCusInfo.setLastName(cusInfo.getLastName());
        newCusInfo.setDisplayName(cusInfo.getDisplayName());
        newCusInfo.setPhoneNumber(cusInfo.getPhoneNumber());
        newCusInfo.setBirthday(cusInfo.getBirthday());
        newCusInfo.setGender(cusInfo.getGender());
        newCusInfo.setCreatedOn(cusInfo.getCreatedOn());
        newCusInfo.setUpdatedOn(cusInfo.getUpdatedOn());
        newCusInfo.setNote(cusInfo.getNote());
//        newCusInfo.setUsername(accountInfo);

        if (cusInfo.getUserId() != null) {
            cusInfoRepository.updateCusInfoById(newCusInfo);
            return cusInfo;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCusInfoById(String id) {
        if (cusInfoRepository.getCusInfoById(id) != null) {
            cusInfoRepository.deleteCusInfoById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CusInfoResponse getCusInfoById(String id) {
        CusInfo result = cusInfoRepository.getCusInfoById(id);
        if (result != null) {
            CusInfoResponse cusInfoResponse = new CusInfoResponse();
            cusInfoResponse.setUserId(result.getUserId());
            cusInfoResponse.setFirstName(result.getFirstName());
            cusInfoResponse.setLastName(result.getLastName());
            cusInfoResponse.setDisplayName(result.getDisplayName());
            cusInfoResponse.setPhoneNumber(result.getPhoneNumber());
            cusInfoResponse.setBirthday(result.getBirthday());
            cusInfoResponse.setGender(result.getGender());
            cusInfoResponse.setCreatedOn(result.getCreatedOn());
            cusInfoResponse.setUpdatedOn(result.getUpdatedOn());
            cusInfoResponse.setNote(result.getNote());
            cusInfoResponse.setUsername(result.getUsername());

            return cusInfoResponse;
        } else {
            return null;
        }
    }
}
