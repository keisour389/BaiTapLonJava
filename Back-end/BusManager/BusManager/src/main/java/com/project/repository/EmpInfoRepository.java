/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository;

import com.project.model.EmpInfo;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface EmpInfoRepository{
    List getAllEmpInfo();
    EmpInfo getEmpInfoById(String id);
    EmpInfo createEmpInfo(EmpInfo empInfo);
    void updateEmpInfoById(EmpInfo empInfo);
    void deleteEmpInfoById(String id);
}
