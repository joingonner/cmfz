package com.baizhi.yqs.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@RestController

public class ImageController {
    @RequestMapping("image")
    public void service(HttpSession session,HttpServletResponse response)
            throws ServletException, IOException {
        orm.CreateValidateCode vCode = new orm.CreateValidateCode(100, 30, 5, 10);
        session.setAttribute("code", vCode.getCode());
        //保存在Session作用域
        vCode.write(response.getOutputStream());
        session.setAttribute("image",vCode);
    }
}
