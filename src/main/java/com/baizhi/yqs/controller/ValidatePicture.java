package com.baizhi.yqs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("validate")
public class ValidatePicture {
    @RequestMapping("pic")
    public void validate(HttpSession session) {

    }
}
