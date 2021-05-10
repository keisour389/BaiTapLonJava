/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.AccountInfo;
import com.project.request.AccountInfoRequest;
import com.project.request.LoginRequest;
import com.project.response.AccountInfoResponse;

/**
 *
 * @author DELL
 */
public interface AccountInfoService {
    Object getAllAccountInfo(int page, int size);
    AccountInfoResponse getAccountInfoByUserIdPassword(LoginRequest loginRequest);
    
    //Using getAccountInfoById in Repository
    AccountInfo getAccountInfoById(String id);
    AccountInfoRequest createAccountInfo(AccountInfoRequest accountInfo);
    AccountInfo updateAccountInfoById(AccountInfoRequest accountInfo);
    boolean deleteAccountInfoById(String id);
}
