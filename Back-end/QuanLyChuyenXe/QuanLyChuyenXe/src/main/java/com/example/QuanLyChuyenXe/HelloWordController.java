/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.QuanLyChuyenXe;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Keisour
 */

//Khởi tạo controller bằng annotation
@RestController
public class HelloWordController {
    //Get
    //URL = /hello-world
    @RequestMapping(method = RequestMethod.GET, path="/hello-world")
    public String HelloWorld(){
        return "Hello World";
    }
    
    //Get
    //URL = /hello-world-bean
    //Phương thức này trả về JSON
    //Mở CORS cho Angular
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, path="/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("Hello World");
    }
    
    //Get
    //URL = /hello-world-param
    //Phương thức này trả về JSON cùng với tham số trên URL
    @RequestMapping(method = RequestMethod.GET, path="/hello-world-param/{name}")
    //Tham số này nhận từ URL theo path đã định sẵn
    public HelloWorldBean HelloWorldParam(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
