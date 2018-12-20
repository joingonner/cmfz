package com.baizhi.yqs.controller;

import com.baizhi.yqs.dto.BannerDto;
import com.baizhi.yqs.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BannerController {
    @Autowired
    BannerService bannerService;
    @RequestMapping("page")
    public BannerDto getPageController(Integer page,Integer rows){
        System.out.println(page);
        System.out.println(rows);
        BannerDto dto =new BannerDto();
        dto.setRows(bannerService.queryByPage(page,rows));
        dto.setTotal(bannerService.queryCount());
        System.out.println(dto);
        return dto;
    }
}
