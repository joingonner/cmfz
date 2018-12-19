package com.baizhi.yqs.controller;

import com.baizhi.yqs.entity.Admin;
import com.baizhi.yqs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("getOneAd")
    public Admin getOneAd(){
       Admin admin1= adminService.getOne(new Admin(null,"wasd","123456"));
        System.out.println(admin1);
       return admin1;
    }
}
