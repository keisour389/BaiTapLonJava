/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.google.common.hash.Hashing;
import com.project.model.AccountInfo;
import com.project.repository.AccountInfoRepository;
import com.project.request.AccountInfoRequest;
import com.project.request.LoginRequest;
import com.project.response.AccountInfoResponse;
import com.project.response.CommonResponse;
import com.project.service.AccountInfoService;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    @Override
    public Object getAllAccountInfo(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = accountInfoRepository.getAllAccountInfo();
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
    public AccountInfoResponse getAccountInfoByUserIdPassword(LoginRequest loginRequest) {
        String passwordHash = Hashing.sha256().hashString(loginRequest.getPassword(), StandardCharsets.UTF_8).toString();
        AccountInfo result = accountInfoRepository.getAccountInfoByUserIdPassword(loginRequest.getUserId(), passwordHash);
        if(result != null){
            AccountInfoResponse accountInfoResponse = new AccountInfoResponse();
            
            accountInfoResponse.setUserId(result.getUserId());
            accountInfoResponse.setPassword(passwordHash);
            accountInfoResponse.setType(result.getType());
            accountInfoResponse.setStatus(result.getStatus());
            accountInfoResponse.setCreatedOn(result.getCreatedOn());
            accountInfoResponse.setUpdatedOn(result.getUpdatedOn());
            accountInfoResponse.setNote(result.getNote());

            return accountInfoResponse;
        }
        else{
            return null;
        }
    }

    @Override
    public AccountInfoRequest createAccountInfo(AccountInfoRequest accountInfo) {
        AccountInfo newAccountInfo = new AccountInfo();
        String passwordHash = Hashing.sha256().hashString(accountInfo.getPassword(), StandardCharsets.UTF_8).toString();
        
        newAccountInfo.setUserId(accountInfo.getUserId());
        newAccountInfo.setPassword(passwordHash);
        newAccountInfo.setType(accountInfo.getType());
        newAccountInfo.setStatus(accountInfo.getStatus());
        newAccountInfo.setCreatedOn(accountInfo.getCreatedOn());
        newAccountInfo.setUpdatedOn(accountInfo.getUpdatedOn());
        newAccountInfo.setNote(accountInfo.getNote());

        if (accountInfoRepository.createAccountInfo(newAccountInfo) != null) {
            return accountInfo;
        } else {
            return null;
        }
    }

    //Need to return the data of account to show the password after hashing
    @Override
    public AccountInfo updateAccountInfoById(AccountInfoRequest accountInfo) {
        //Hash password before udpating
        String passwordHash = Hashing.sha256().hashString(accountInfo.getPassword(), StandardCharsets.UTF_8).toString();
        AccountInfo newAccountInfo = new AccountInfo();
        
//        newAccountInfo.setUserId(accountInfo.getUserId());
        newAccountInfo.setPassword(passwordHash);
        newAccountInfo.setType(accountInfo.getType());
        newAccountInfo.setStatus(accountInfo.getStatus());
        newAccountInfo.setCreatedOn(accountInfo.getCreatedOn());
        newAccountInfo.setUpdatedOn(accountInfo.getUpdatedOn());
        newAccountInfo.setNote(accountInfo.getNote());

        if (accountInfo.getUserId() != null) {
            accountInfoRepository.updateAccountInfoById(newAccountInfo);
            return newAccountInfo;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAccountInfoById(String id) {
        if (accountInfoRepository.getAccountInfoById(id) != null) {
            accountInfoRepository.deleteAccountInfoById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AccountInfoResponse getAccountInfoById(String id) {
        AccountInfo result = accountInfoRepository.getAccountInfoById(id);
            
        if (result != null) {
            AccountInfoResponse accountInfoResponse = new AccountInfoResponse();
            
            accountInfoResponse.setUserId(result.getUserId());
            accountInfoResponse.setPassword(result.getPassword());
            accountInfoResponse.setType(result.getType());
            accountInfoResponse.setStatus(result.getStatus());
            accountInfoResponse.setCreatedOn(result.getCreatedOn());
            accountInfoResponse.setUpdatedOn(result.getUpdatedOn());
            accountInfoResponse.setNote(result.getNote());

            return accountInfoResponse;
        } else {
            return null;
        }
    }
}
