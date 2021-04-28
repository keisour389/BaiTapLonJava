/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.common.AccountDTO;
import com.project.model.Account;
import com.project.model.AccountInfo;
import com.project.service.AccountService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Keisour
 */
@RestController //Controller gọi xuống lớp Service để lấy dữ liệu, Controller không được gọi trực tiếp xuống Repository
@CrossOrigin //Cái này cho phép bên ngoài gọi API này, có thể config
public class AccountController {
    //Luôn khai báo @Autowired để sử dụng các class theo chuẩn IoC, nếu không là bị trừ điểm =))
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private Account accountInfo;
    
    //Get
    //URL = /hello-world-param
    //Phương thức này trả về JSON cùng với tham số trên URL
    @RequestMapping(value = "/search-user/{userId}", method = RequestMethod.GET)
    //Tham số này nhận từ URL theo path đã định sẵn
    public ResponseEntity<?> loadUserByUserId(@PathVariable String userId){
        accountInfo = accountService.loadUserbyUserId(userId);
        return ResponseEntity.ok(accountInfo);
    }
    
    //Tài khoản
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    //Tham số này nhận từ URL theo path đã định sẵn
    public ResponseEntity<?> registerUser(@RequestBody AccountDTO request){
        accountInfo = accountService.registerAccount(request);
        return ResponseEntity.ok(accountInfo);
    }
}
