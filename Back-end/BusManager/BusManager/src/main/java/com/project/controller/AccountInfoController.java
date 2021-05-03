/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.repository.AccountInfoRepository;
import com.project.request.AccountInfoRequest;
import com.project.request.LoginRequest;
import com.project.response.AccountInfoResponse;
import com.project.service.AccountInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@Tag(name = "AccountInfo")
@RestController
@CrossOrigin("*")
@RequestMapping("api/accountinfo")
public class AccountInfoController {
    @Autowired
    AccountInfoService accountInfoService;
    AccountInfoRepository accountInfoRepository;
    
    @Operation(responses = @ApiResponse(responseCode = "200", 
            content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createAccountInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAccountInfo(@RequestBody AccountInfoRequest accountInfoRequest){
        AccountInfoRequest dataAccountInfo = accountInfoService.createAccountInfo(accountInfoRequest);
        if(dataAccountInfo != null){
            return new ResponseEntity<>(dataAccountInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } 
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllAccountInfo/")
    public ResponseEntity<?> getAllAccountInfo(@RequestParam int page,
                                        @RequestParam int size){
        Object dataAccountInfo = accountInfoService.getAllAccountInfo(page, size);
        return new ResponseEntity<>(dataAccountInfo, HttpStatus.OK);
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAccountInfo/")
    public ResponseEntity<?> getAccountInfo(@RequestParam String id){
        Object dataAccountInfo = accountInfoRepository.getAccountInfoById(id);
        if(dataAccountInfo != null){
            return new ResponseEntity<>(dataAccountInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateAccountInfo/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateAccountInfo(@RequestParam String id, @RequestBody AccountInfoRequest accountInfoRequest){
        AccountInfoRequest dataAccountInfo = accountInfoService.updateAccountInfoById(id, accountInfoRequest);
        if(dataAccountInfo != null){
            return new ResponseEntity<>(dataAccountInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteAccountInfo/")
    public ResponseEntity<?> deleteAccountInfo(@RequestParam String id){
        boolean dataAccountInfo = accountInfoService.deleteAccountInfoById(id);
        if(dataAccountInfo){
            return new ResponseEntity<>(dataAccountInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "loginAccountInfo/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginAccountInfo(@RequestBody LoginRequest loginRequest){
        AccountInfoResponse dataAccountInfo = accountInfoService.getAccountInfoByUserIdPassword(loginRequest);
        return new ResponseEntity<>(dataAccountInfo, HttpStatus.OK);
    }
}
