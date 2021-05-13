/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository;

import com.project.model.CancelHistory;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface CancelHistoryRepository{
    List getAllCancelHistory();
    CancelHistory getCancelHistoryById(String id);
    CancelHistory createCancelHistory(CancelHistory cancelHistory);
    boolean cancelHistoryIsExist(String id);
    void updateCancelHistoryById(CancelHistory cancelHistory);
    void deleteCancelHistoryById(String id);
}
