/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.model.CancelHistory;
import com.project.repository.CancelHistoryRepository;
import com.project.service.CancelHistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class CancelHistoryServiceImpl implements CancelHistoryService{
    @Autowired
    private CancelHistoryRepository cancelHistoryRepository;

}
