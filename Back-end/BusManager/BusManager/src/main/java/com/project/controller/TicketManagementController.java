/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.repository.TicketManagementRepository;
import com.project.request.TicketManagementRequest;
import com.project.service.TicketManagementService;

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
@Tag(name = "TicketManagement")
@RestController
@CrossOrigin("*")
@RequestMapping("api/ticketmanagement")
public class TicketManagementController {
    @Autowired
    TicketManagementService ticketManagementService;
    TicketManagementRepository ticketManagementRepository;
    
    @Operation(responses = @ApiResponse(responseCode = "200", 
            content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createTicketManagement", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCancelHistory(@RequestBody TicketManagementRequest ticketManagementRequest){
        TicketManagementRequest dataTicketManagement = ticketManagementService.createTicketManagement(ticketManagementRequest);
        if(dataTicketManagement != null){
            return new ResponseEntity<>(dataTicketManagement, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } 
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllTicketManagement/")
    public ResponseEntity<?> getAllTicketManagement(@RequestParam int page,
                                        @RequestParam int size){
        Object dataTicketManagement = ticketManagementService.getAllTicketManagement(page, size);
        return new ResponseEntity<>(dataTicketManagement, HttpStatus.OK);
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getTicketManagement/")
    public ResponseEntity<?> getTicketManagement(@RequestParam String id){
        Object dataTicketManagement = ticketManagementRepository.getTicketManagementById(id);
        if(dataTicketManagement != null){
            return new ResponseEntity<>(dataTicketManagement, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateTicketManagement/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTicketManagement(@RequestParam String id, @RequestBody TicketManagementRequest ticketManagementRequest){
        TicketManagementRequest dataTicketManagement = ticketManagementService.updateTicketManagementById(id, ticketManagementRequest);
        if(dataTicketManagement != null){
            return new ResponseEntity<>(dataTicketManagement, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteTicketManagement/")
    public ResponseEntity<?> deleteTicketManagement(@RequestParam String id){
        boolean dataTicketManagement = ticketManagementService.deleteTicketManagementById(id);
        if(dataTicketManagement){
            return new ResponseEntity<>(dataTicketManagement, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
