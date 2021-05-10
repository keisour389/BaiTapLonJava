/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.CusInfo;
import com.project.model.EmpInfo;
import com.project.model.Feedback;
import com.project.repository.CusInfoRepository;
import com.project.repository.EmpInfoRepository;
import com.project.repository.FeedbackRepository;
import com.project.request.FeedbackRequest;
import com.project.response.CommonResponse;
import com.project.response.FeedbackResponse;
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
    
    @Autowired
    private CusInfoRepository cusInfoRepository; 
    
    @Autowired
    private EmpInfoRepository empInfoRepository; 

    @Override
    public Object getAllFeedback(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = feedbackRepository.getAllFeedback();
        int offset = (page - 1) * size;
        int total = result.size();
        int totalPage = (total % size) == 0 ? (int)(total / size) : (int)((total / size) + 1);
        Object[] data = result.stream().skip(offset).limit(size).toArray();
        commonResponse.setData(data);
        commonResponse.setTotalPage(totalPage);
        commonResponse.setTotalRecord(total);
        commonResponse.setPage(page);
        commonResponse.setSize(size);
        
        return  commonResponse;
    }

    @Override
    public FeedbackRequest createFeedback(FeedbackRequest feedback) {
        CusInfo cus = new CusInfo();
        EmpInfo emp = new EmpInfo();
        
        Feedback newFeedback = new Feedback();
        
        cus = cusInfoRepository.getCusInfoById(feedback.getCusId());
        emp = empInfoRepository.getEmpInfoById(feedback.getEmpId());
        
        newFeedback.setFeedbackId(feedback.getFeedbackId());
        newFeedback.setContent(feedback.getContent());
        newFeedback.setStatus(feedback.getStatus());
        newFeedback.setNote(feedback.getNote());
        newFeedback.setCusId(cus);
        newFeedback.setEmpId(emp);
        
        if(feedbackRepository.createFeedback(newFeedback) != null)
            return feedback;
        else
            return null;
    }

    @Override
    public FeedbackRequest updateFeedbackById(FeedbackRequest feedback) {
        CusInfo cus = new CusInfo();
        EmpInfo emp = new EmpInfo();
        
        Feedback newFeedback = new Feedback();
        
        cus = cusInfoRepository.getCusInfoById(feedback.getCusId());
        emp = empInfoRepository.getEmpInfoById(feedback.getEmpId());

        newFeedback.setFeedbackId(feedback.getFeedbackId());
        newFeedback.setContent(feedback.getContent());
        newFeedback.setStatus(feedback.getStatus());
        newFeedback.setNote(feedback.getNote());
        newFeedback.setCusId(cus);
        newFeedback.setEmpId(emp);
        
        if(feedbackRepository.createFeedback(newFeedback) != null){
            feedbackRepository.updateFeedbackById(newFeedback);
            return feedback;
        }
        else
            return null;
    }

    @Override
    public boolean deleteFeedbackById(String id) {
        if(feedbackRepository.getFeedbackById(id) != null){
            feedbackRepository.deleteFeedbackById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public FeedbackResponse getFeedbackById(String id) {
        Feedback result = feedbackRepository.getFeedbackById(id);
        if(result != null){
            FeedbackResponse feedbackResponse = new FeedbackResponse();
            feedbackResponse.setFeedbackId(result.getFeedbackId());
            feedbackResponse.setContent(result.getContent());
            feedbackResponse.setStatus(result.getStatus());
            feedbackResponse.setCusId(result.getCusId().toString());
            feedbackResponse.setEmpId(result.getEmpId().toString());
            
            return feedbackResponse;
        }
        else
            return null;
    }
}
