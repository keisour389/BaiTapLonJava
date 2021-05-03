/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository;

import com.project.model.Feedback;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface FeedbackRepository{
    List getAllFeedback();
    Feedback getFeedbackById(String id);
    Feedback createFeedback(Feedback feedback);
    void updateFeedbackById(String id, Feedback feedback);
    void deleteFeedbackById(String id);
}
