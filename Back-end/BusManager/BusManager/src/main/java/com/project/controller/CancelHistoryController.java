/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.repository.CancelHistoryRepository;
import com.project.request.CancelHistoryRequest;
import com.project.service.CancelHistoryService;

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
@Tag(name = "CancelHistory")
@RestController
@CrossOrigin("*")
@RequestMapping("api/cancelhistory")
public class CancelHistoryController {
    @Autowired
    CancelHistoryService cancelHistoryService;
    
    @Operation(responses = @ApiResponse(responseCode = "200", 
            content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createCancelHistory", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCancelHistory(@RequestBody CancelHistoryRequest cancelHistoryRequest){
        CancelHistoryRequest dataCancelHistory = cancelHistoryService.createCancelHistory(cancelHistoryRequest);
        if(dataCancelHistory != null){
            return new ResponseEntity<>(dataCancelHistory, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } 
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllCancelHistory/")
    public ResponseEntity<?> getAllCancelHistory(@RequestParam int page,
                                        @RequestParam int size){
        Object dataCancelHistory = cancelHistoryService.getAllCancelHistory(page, size);
        return new ResponseEntity<>(dataCancelHistory, HttpStatus.OK);
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getCancelHistory/")
    public ResponseEntity<?> getCancelHistory(@RequestParam String id){
        Object dataCancelHistory = cancelHistoryService.getCancelHistoryById(id);
        if(dataCancelHistory != null){
            return new ResponseEntity<>(dataCancelHistory, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateCancelHistory/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCancelHistory(@RequestParam String id, @RequestBody CancelHistoryRequest cancelHistoryRequest){
        CancelHistoryRequest dataCancelHistory = cancelHistoryService.updateCancelHistoryById(id, cancelHistoryRequest);
        if(dataCancelHistory != null){
            return new ResponseEntity<>(dataCancelHistory, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteCancelHistory/")
    public ResponseEntity<?> deleteCancelHistory(@RequestParam String id){
        boolean dataCancelHistory = cancelHistoryService.deleteCancelHistoryById(id);
        if(dataCancelHistory){
            return new ResponseEntity<>(dataCancelHistory, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
