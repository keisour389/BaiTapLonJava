/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.AccountInfo;
import com.project.model.EmpInfo;
import com.project.repository.AccountInfoRepository;
import com.project.repository.EmpInfoRepository;
import com.project.request.EmpInfoRequest;
import com.project.response.CommonResponse;
import com.project.response.EmpInfoResponse;
import com.project.service.EmpInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class EmpInfoServiceImpl implements EmpInfoService {

    @Autowired
    private EmpInfoRepository empInfoRepository;

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    @Override
    public Object getAllEmpInfo(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = empInfoRepository.getAllEmpInfo();
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
    public EmpInfoRequest createEmpInfo(EmpInfoRequest empInfo) {
        AccountInfo accountInfo = new AccountInfo();
        EmpInfo newEmpInfo = new EmpInfo();

        accountInfo = accountInfoRepository.getAccountInfoById(empInfo.getUsername());

        newEmpInfo.setUserId(empInfo.getUserId());
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
        newEmpInfo.setUsername(accountInfo);

        if(!empInfoRepository.empInfoIsExist(empInfo.getUsername())){
            if (empInfoRepository.createEmpInfo(newEmpInfo) != null) {
                return empInfo;
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public EmpInfoRequest updateEmpInfoById(EmpInfoRequest empInfo) {
        AccountInfo accountInfo = new AccountInfo();
        EmpInfo newEmpInfo = new EmpInfo();

        accountInfo = accountInfoRepository.getAccountInfoById(empInfo.getUsername());

//        newEmpInfo.setUserId(empInfo.getUserId());
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
//        newEmpInfo.setUsername(accountInfo);

//        if (empInfo.getUserId() != null) {
//            empInfoRepository.updateEmpInfoById(newEmpInfo);
//            return empInfo;
//        } else {
//            return null;
//        }

        if (empInfoRepository.getEmpInfoById(newEmpInfo.getUsername()) != null) {
            empInfoRepository.updateEmpInfoById(newEmpInfo);
            return empInfo;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteEmpInfoById(String id) {
        if (empInfoRepository.getEmpInfoById(id) != null) {
            empInfoRepository.deleteEmpInfoById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public EmpInfoResponse getEmpInfoById(String id) {
        EmpInfo result = empInfoRepository.getEmpInfoById(id);
        if (result != null) {
            EmpInfoResponse empInfoResponse = new EmpInfoResponse();
            empInfoResponse.setUserId(result.getUserId());
            empInfoResponse.setFirstName(result.getFirstName());
            empInfoResponse.setLastName(result.getLastName());
            empInfoResponse.setDisplayName(result.getDisplayName());
            empInfoResponse.setPhoneNumber(result.getPhoneNumber());
            empInfoResponse.setBirthday(result.getBirthday());
            empInfoResponse.setAddress(result.getAddress());
            empInfoResponse.setId(result.getId());
            empInfoResponse.setGender(result.getGender());
            empInfoResponse.setType(result.getType());
            empInfoResponse.setCreatedOn(result.getCreatedOn());
            empInfoResponse.setUpdatedOn(result.getUpdatedOn());
            empInfoResponse.setNote(result.getNote());
            empInfoResponse.setUsername(result.getUsername());

            return empInfoResponse;
        } else {
            return null;
        }
    }
}
