///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.project.controller;
//
////import com.project.common.JwtRequest;
////import com.project.common.JwtResponse;
////import com.project.common.AccountDTO;
////import com.project.config.JwtTokenUtil;
////import com.project.service.JwtUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author Keisour
// */
////@RestController
////@CrossOrigin
////public class AuthenticationController {
////    @Autowired
////	private AuthenticationManager authenticationManager;
////
////	@Autowired
////	private JwtTokenUtil jwtTokenUtil;
////
////	@Autowired
////	private JwtUserDetailsService userDetailsService;
////
////	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
////	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
////
////		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
////
////		final UserDetails userDetails = userDetailsService
////				.loadUserByUsername(authenticationRequest.getUsername());
////
////		final String token = jwtTokenUtil.generateToken(userDetails);
////
////		return ResponseEntity.ok(new JwtResponse(token));
////	}
////
////        //Hàm này dùng để xác thực tài khoản và mật khẩu từ người dùng với UserDetails
////	private void authenticate(String username, String password) throws Exception {
////		try {
////			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
////		} catch (DisabledException e) {
////			throw new Exception("USER_DISABLED", e);
////		} catch (BadCredentialsException e) {
////			throw new Exception("INVALID_CREDENTIALS", e);
////		}
////	}
////}
