/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.common.AccountDTO;
import com.project.model.AccountInfo;
import com.project.repository.AccountRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keisour
 */
//Class này lưu UserDetails của Spring
@Service
public class JwtUserDetailsService implements UserDetailsService {

    //Gọi repository để sử dụng các hàm tương tác dữ liệu
    @Autowired
    private AccountRepository accountRepository;

    //Hàm này có nhiệm vụ lưu user tìm được vào UserDetails để cross check với dữ liệu người dùng nhập vào
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        //Tìm user theo userId dưới database
        AccountInfo user = accountRepository.findByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with user id: " + userId);
        }
        //Lưu user vào UserDetails
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(),
                new ArrayList<>());
    }

}
