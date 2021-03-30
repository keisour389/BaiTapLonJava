/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.model.AccountInfo;
import com.project.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public AccountInfo loadUserbyUserId(String userId){
        return accountRepository.findByUserId(userId);
    }
    
}
