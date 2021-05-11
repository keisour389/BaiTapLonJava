///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.project.config;
//
////import com.project.service.JwtUserDetailsService;
//import io.jsonwebtoken.ExpiredJwtException;
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
///**
// *
// * @author Keisour
// */
////Class này để filter token khi có sử dụng token ở phía client
////@Component
////public class JwtRequestFilter extends OncePerRequestFilter {
////
////    //Gọi UserDetails để validate
////    @Autowired
////    private JwtUserDetailsService jwtUserDetailsService;
////
////    //Dùng để quản lí token như thêm token,...
////    @Autowired
////    private JwtTokenUtil jwtTokenUtil;
////
////    //Hàm dùng để filter
////    @Override
////    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
////            throws ServletException, IOException {
////
////        final String requestTokenHeader = request.getHeader("Authorization");
////
////        String username = null;
////        String jwtToken = null;   
////        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
////            // JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
////            jwtToken = requestTokenHeader.substring(7);
////            try {
////                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
////            } catch (IllegalArgumentException e) {
////                System.out.println("Unable to get JWT Token");
////            } catch (ExpiredJwtException e) {
////                System.out.println("JWT Token has expired");
////            }
////        } else {
////            logger.warn("JWT Token does not begin with Bearer String");
////        }
////
////        //Once we get the token validate it.
////        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
////
////            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
////
////            // if token is valid configure Spring Security to manually set authentication
////            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
////
////                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
////                        userDetails, null, userDetails.getAuthorities());
////                usernamePasswordAuthenticationToken
////                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////                // After setting the Authentication in the context, we specify
////                // that the current user is authenticated. So it passes the Spring Security Configurations successfully.
////                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
////            }
////        }
////        chain.doFilter(request, response);
////    }
////}
