/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.repository.FeedbackRepository;
import com.project.request.FeedbackRequest;
import com.project.service.FeedbackService;

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
@Tag(name = "Feedback")
@RestController
@CrossOrigin("*")
@RequestMapping("api/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    FeedbackRepository feedbackRepository;
    
    @Operation(responses = @ApiResponse(responseCode = "200", 
            content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createFeedback", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCancelHistory(@RequestBody FeedbackRequest feedbackRequest){
        FeedbackRequest dataFeedback = feedbackService.createFeedback(feedbackRequest);
        if(dataFeedback != null){
            return new ResponseEntity<>(dataFeedback, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } 
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllFeedback/")
    public ResponseEntity<?> getAllFeedback(@RequestParam int page,
                                        @RequestParam int size){
        Object dataFeedback = feedbackService.getAllFeedback(page, size);
        return new ResponseEntity<>(dataFeedback, HttpStatus.OK);
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getFeedback/")
    public ResponseEntity<?> getCancelHistory(@RequestParam String id){
        Object dataFeedback = feedbackRepository.getFeedbackById(id);
        if(dataFeedback != null){
            return new ResponseEntity<>(dataFeedback, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateFeedback/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateFeedback(@RequestParam String id, @RequestBody FeedbackRequest feedbackRequest){
        FeedbackRequest dataFeedback = feedbackService.updateFeedbackById(id, feedbackRequest);
        if(dataFeedback != null){
            return new ResponseEntity<>(dataFeedback, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
    
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteFeedback/")
    public ResponseEntity<?> deleteFeedback(@RequestParam String id){
        boolean dataFeedback = feedbackService.deleteFeedbackById(id);
        if(dataFeedback){
            return new ResponseEntity<>(dataFeedback, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
