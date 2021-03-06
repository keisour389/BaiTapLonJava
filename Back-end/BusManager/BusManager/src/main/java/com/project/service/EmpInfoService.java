/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.request.EmpInfoRequest;
import com.project.response.CommonResponse;
import com.project.response.EmpInfoResponse;

/**
 *
 * @author DELL
 */
public interface EmpInfoService {
    Object getAllEmpInfo(int page, int size);
    
    //Using getEmpInfoById in Repository
    EmpInfoResponse getEmpInfoById(String id);
    
    EmpInfoRequest createEmpInfo(EmpInfoRequest empInfo);
    EmpInfoRequest updateEmpInfoById(EmpInfoRequest empInfo);
    boolean deleteEmpInfoById(String id);
}
