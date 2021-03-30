/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository;

import com.project.model.AccountInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Keisour
 */
@Repository
public interface AccountRepository extends CrudRepository<AccountInfo, String>{
    AccountInfo findByUserId(String userId);
    
    //Insert value vào table
    @Override
    AccountInfo save(AccountInfo accountInfo);
}
