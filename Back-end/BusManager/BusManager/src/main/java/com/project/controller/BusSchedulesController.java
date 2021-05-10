/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.repository.BusSchedulesRepository;
import com.project.request.BusSchedulesRequest;
import com.project.response.CommonResponse;
import com.project.service.BusSchedulesService;

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
@Tag(name = "BusSchedules")
@RestController
@CrossOrigin("*")
@RequestMapping("api/busschedules")
public class BusSchedulesController {
    @Autowired
    BusSchedulesService busSchedulesService;
    
    @Operation(responses = @ApiResponse(responseCode = "200", 
            content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createBusSchedules", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createBusSchedules(@RequestBody BusSchedulesRequest busSchedulesRequest){
        BusSchedulesRequest dataBusSchedules = busSchedulesService.createBusSchedules(busSchedulesRequest);
        if(dataBusSchedules != null){
            return new ResponseEntity<>(dataBusSchedules, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } 
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllBusSchedules/")
    public ResponseEntity<?> getAllBusSchedules(@RequestParam int page,
                                        @RequestParam int size){
        CommonResponse dataBusSchedules = busSchedulesService.getAllBusSchedules(page, size);
        return new ResponseEntity<>(dataBusSchedules, HttpStatus.OK);
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getBusSchedules/")
    public ResponseEntity<?> getBusSchedulesById(@RequestParam String id){
        Object dataBusSchedules = busSchedulesService.getBusSchedulesById(id);
        if(dataBusSchedules != null){
            return new ResponseEntity<>(dataBusSchedules, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateBusSchedules/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateBusSchedules(@RequestParam String id, @RequestBody BusSchedulesRequest busSchedulesRequest){
        BusSchedulesRequest dataBusSchedules = busSchedulesService.updateBusSchedulesById(id, busSchedulesRequest);
        if(dataBusSchedules != null){
            return new ResponseEntity<>(dataBusSchedules, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteBusSchedules/")
    public ResponseEntity<?> deleteBusSchedules(@RequestParam String id){
        boolean dataBusSchedules = busSchedulesService.deleteBusSchedulesById(id);
        if(dataBusSchedules){
            return new ResponseEntity<>(dataBusSchedules, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
