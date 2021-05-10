/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository;

import com.project.model.AccountInfo;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface AccountInfoRepository {
    List getAllAccountInfo();
    AccountInfo getAccountInfoById(String id);
    AccountInfo getAccountInfoByUserIdPassword(String userId, String password);
    AccountInfo createAccountInfo(AccountInfo accountInfo);
    void updateAccountInfoById(AccountInfo accountInfo);
    void deleteAccountInfoById(String id);
}
