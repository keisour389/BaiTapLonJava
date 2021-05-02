/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.repository.CusInfoRepository;
import com.project.request.CusInfoRequest;
import com.project.service.CusInfoService;
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
@Tag(name = "CusInfo")
@RestController
@CrossOrigin("*")
@RequestMapping("api/cusinfo")
public class CusInfoController {
    @Autowired
    CusInfoService cusInfoService;
    CusInfoRepository cusInfoRepository;
    
    @Operation(responses = @ApiResponse(responseCode = "200", 
            content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createCusInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCusInfo(@RequestBody CusInfoRequest cusInfoRequest){
        CusInfoRequest dataCusInfo = cusInfoService.createCusInfo(cusInfoRequest);
        if(dataCusInfo != null){
            return new ResponseEntity<>(dataCusInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } 
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllCusInfo/")
    public ResponseEntity<?> getAllCusInfo(@RequestParam int page,
                                        @RequestParam int size){
        Object dataCusInfo = cusInfoService.getAllCusInfo(page, size);
        return new ResponseEntity<>(dataCusInfo, HttpStatus.OK);
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getCusInfo/")
    public ResponseEntity<?> getCusInfoById(@RequestParam String id){
        Object dataCusInfo = cusInfoRepository.getCusInfoById(id);
        if(dataCusInfo != null){
            return new ResponseEntity<>(dataCusInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateCusInfo/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCusInfo(@RequestParam String id, @RequestBody CusInfoRequest cusInfoRequest){
        CusInfoRequest dataCusInfo = cusInfoService.updateCusInfoById(id, cusInfoRequest);
        if(dataCusInfo != null){
            return new ResponseEntity<>(dataCusInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteCusInfo/")
    public ResponseEntity<?> deleteCusInfo(@RequestParam String id){
        boolean dataCusInfo = cusInfoService.deleteCusInfoById(id);
        if(dataCusInfo){
            return new ResponseEntity<>(dataCusInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
