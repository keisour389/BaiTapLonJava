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
import com.project.response.CommonResponse;
import com.project.service.AccountInfoService;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DELL
 */
public class AccountInfoServiceImpl implements AccountInfoService{
    @Autowired
    AccountInfoRepository accountInfoRepository;

    @Override
    public Object getAllAccountInfo(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = accountInfoRepository.getAllAccountInfo();
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
    public AccountInfoRequest createAccountInfo(AccountInfoRequest accountInfo) {
        AccountInfo newAccountInfo = new AccountInfo();
        String passwordHash = Hashing.sha256().hashString(accountInfo.getPassword(), StandardCharsets.UTF_8).toString();
        newAccountInfo.setPassword(passwordHash);
        newAccountInfo.setType(accountInfo.getType());
        newAccountInfo.setStatus(accountInfo.getStatus());
        newAccountInfo.setCreatedOn(accountInfo.getCreatedOn());
        newAccountInfo.setUpdatedOn(accountInfo.getUpdatedOn());
        newAccountInfo.setNote(accountInfo.getNote());
        
        if(accountInfoRepository.createAccountInfo(newAccountInfo) != null)
            return accountInfo;
        else
            return null;
    }

    @Override
    public AccountInfoRequest updateAccountInfoById(String id, AccountInfoRequest accountInfo) {
        AccountInfo newAccountInfo = new AccountInfo();
        newAccountInfo.setPassword(accountInfo.getPassword());
        newAccountInfo.setType(accountInfo.getType());
        newAccountInfo.setStatus(accountInfo.getStatus());
        newAccountInfo.setCreatedOn(accountInfo.getCreatedOn());
        newAccountInfo.setUpdatedOn(accountInfo.getUpdatedOn());
        newAccountInfo.setNote(accountInfo.getNote());
        
        if(accountInfoRepository.createAccountInfo(newAccountInfo) != null){
            accountInfoRepository.updateAccountInfoById(id, newAccountInfo);
            return accountInfo;
        }
        else
            return null;
    }

    @Override
    public boolean deleteAccountInfoById(String id) {
        if(accountInfoRepository.getAccountInfoById(id) != null){
            accountInfoRepository.deleteAccountInfoById(id);
            return true;
        }
        else
            return false;
    }
}
