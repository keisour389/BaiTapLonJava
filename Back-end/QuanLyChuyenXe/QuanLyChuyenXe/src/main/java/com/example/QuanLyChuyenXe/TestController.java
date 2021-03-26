/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.QuanLyChuyenXe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Keisour
 */
@RestController
public class TestController {
     @RequestMapping(method = RequestMethod.GET, path="/test")
    public String Test(){
        return "Test";
    }
}
