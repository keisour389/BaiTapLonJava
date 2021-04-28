/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service.impl;

import com.project.repository.AccountInfoRepository;
import com.project.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DELL
 */
public class AccountInfoServiceImpl implements AccountInfoService{
    @Autowired
    private AccountInfoRepository accountInfoRepository;
}
