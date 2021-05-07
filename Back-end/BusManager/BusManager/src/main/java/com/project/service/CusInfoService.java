/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.request.CusInfoRequest;
import com.project.response.CusInfoResponse;

/**
 *
 * @author DELL
 */
public interface CusInfoService {
    Object getAllCusInfo(int page, int size);
    
    //Using getCusInfoById in Repository
    CusInfoResponse getCusInfoById(String id);
    
    CusInfoRequest createCusInfo(CusInfoRequest cusInfo);
    CusInfoRequest updateCusInfoById(String id, CusInfoRequest cusInfo);
    boolean deleteCusInfoById(String id);
}
