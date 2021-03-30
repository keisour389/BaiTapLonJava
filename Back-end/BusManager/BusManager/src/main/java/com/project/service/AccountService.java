/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.common.AccountDTO;
import com.project.model.AccountInfo;
import com.project.repository.AccountRepository;
import java.time.LocalDateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keisour
 */
//Nhớ phải có annnotation là Service
//Lớp Service sẽ gọi tới lớp Repository
@Service
public class AccountService {

    //Gọi repository phải dùng @Autowired, không sử dụng cú pháp khai báo new
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountInfo accountInfo;
    
        //Mã hóa mật khẩu
    @Autowired
    private PasswordEncoder bcryptEncoder;

    public AccountInfo loadUserbyUserId(String userId) {
        return accountRepository.findByUserId(userId);
    }

    public AccountInfo registerAccount(AccountDTO request) {
        //Gán dữ liệu cho account info để insert data xuống database
        accountInfo.setUserId(request.getUserId());
        //Mã hóa mật khẩu trước khi đưa xuống database
        accountInfo.setPassword(bcryptEncoder.encode(request.getPassword()));
        accountInfo.setStatus(request.getStatus());
        accountInfo.setType(request.getType());
        accountInfo.setCreatedOn(LocalDateTime.now());
        accountInfo.setUpdatedOn(LocalDateTime.now());
        accountInfo.setNote(request.getNote());
        //Gọi xuống DAL để insert            
        return accountRepository.save(accountInfo);
    }
}
