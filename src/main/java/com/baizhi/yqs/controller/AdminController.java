package com.baizhi.yqs.controller;

import com.baizhi.yqs.entity.Admin;
import com.baizhi.yqs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller

public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("login")
    public String login(Admin admin, HttpSession session){
        boolean b = adminService.login(admin);
        if (b){
            session.setAttribute("admin",admin);
            return "redirect:main/main.jsp";
        }
        else return "redirect:login.jsp";
    }
}
