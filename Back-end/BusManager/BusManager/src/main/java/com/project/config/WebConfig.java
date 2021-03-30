/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.config;

import com.project.model.AccountInfo;
import com.project.repository.AccountRepository;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Keisour
 */
@Configuration
@ComponentScan(basePackages = {"com.project.controller", "com.project.repository", "com.project.service"})
public class WebConfig {
    
}
