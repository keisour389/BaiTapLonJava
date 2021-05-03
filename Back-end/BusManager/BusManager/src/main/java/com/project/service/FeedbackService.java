/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.request.FeedbackRequest;

/**
 *
 * @author DELL
 */
public interface FeedbackService {
    Object getAllFeedback(int page, int size);
    
    //Using getFeedbackById in Repository
    //FeedbackResponse getFeedbackById(String id);
    
    FeedbackRequest createFeedback(FeedbackRequest feedback);
    FeedbackRequest updateFeedbackById(String id, FeedbackRequest feedback);
    boolean deleteFeedbackById(String id);
}
