/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository;

import com.project.model.CusInfo;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface CusInfoRepository {
    List getAllCusInfo();
    CusInfo getCusInfoById(String id);
    CusInfo createCusInfo(CusInfo cusInfo);
    boolean cusInfoIsExist(String username);
    void updateCusInfoById(CusInfo cusInfo);
    void deleteCusInfoById(String id);
            
            
            
            
            
            
            
            
            
            
            
            
}
