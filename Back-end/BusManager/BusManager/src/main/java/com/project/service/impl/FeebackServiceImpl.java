/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.Feedback;
import com.project.repository.FeedbackRepository;
import com.project.service.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class FeebackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepository feedbackRepository;
    
}
