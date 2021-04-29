/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.request.AccountInfoRequest;

/**
 *
 * @author DELL
 */
public interface AccountInfoService {
    Object getAllAccountInfo(int page, int size);
    
    //Using getAccountInfoById in Repository
    //AccountInfoResponse getAccountInfoById(String id);
    
    AccountInfoRequest createAccountInfo(AccountInfoRequest accountInfo);
    AccountInfoRequest updateAccountInfoById(String id, AccountInfoRequest accountInfo);
    boolean deleteAccountInfoById(String id);
}
