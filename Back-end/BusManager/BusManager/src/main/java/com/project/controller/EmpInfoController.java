/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.repository.EmpInfoRepository;
import com.project.request.EmpInfoRequest;
import com.project.service.EmpInfoService;

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
@Tag(name = "EmpInfo")
@RestController
@CrossOrigin("*")
@RequestMapping("api/empinfo")
public class EmpInfoController {
    @Autowired
    EmpInfoService empInfoService;
    
    @Operation(responses = @ApiResponse(responseCode = "200", 
            content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createEmpInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmpInfo(@RequestBody EmpInfoRequest empInfoRequest){
        EmpInfoRequest dataEmpInfo = empInfoService.createEmpInfo(empInfoRequest);
        if(dataEmpInfo != null){
            return new ResponseEntity<>(dataEmpInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } 
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllEmpInfo/")
    public ResponseEntity<?> getAllEmpInfo(@RequestParam int page,
                                        @RequestParam int size){
        Object dataEmpInfo = empInfoService.getAllEmpInfo(page, size);
        return new ResponseEntity<>(dataEmpInfo, HttpStatus.OK);
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getEmpInfo/")
    public ResponseEntity<?> getEmpInfoById(@RequestParam String id){
        Object dataEmpInfo = empInfoService.getEmpInfoById(id);
        if(dataEmpInfo != null){
            return new ResponseEntity<>(dataEmpInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateEmpInfo/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmpInfo(@RequestParam String id, @RequestBody EmpInfoRequest empInfoRequest){
        EmpInfoRequest dataEmpInfo = empInfoService.updateEmpInfoById(id, empInfoRequest);
        if(dataEmpInfo != null){
            return new ResponseEntity<>(dataEmpInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteEmpInfo/")
    public ResponseEntity<?> deleteEmpInfo(@RequestParam String id){
        boolean dataEmpInfo = empInfoService.deleteEmpInfoById(id);
        if(dataEmpInfo){
            return new ResponseEntity<>(dataEmpInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
