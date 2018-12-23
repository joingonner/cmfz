package com.baizhi.yqs.controller;

import com.baizhi.yqs.dto.BannerDto;
import com.baizhi.yqs.entity.Banner;
import com.baizhi.yqs.mapper.BannerMapper;
import com.baizhi.yqs.service.BannerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class BannerController {
    @Autowired
    BannerService bannerService;
    @Autowired
    BannerMapper bannerMapper;


    @RequestMapping("page")
    public BannerDto getPageController(Integer page, Integer rows) {
        System.out.println(page);
        System.out.println(rows);
        BannerDto dto = new BannerDto();
        /*PageHelper.startPage(page,rows);
        //查询全部，据就行，通用mapper不能用了？忘了继承Mapper
        List<Banner> bannerList = bannerMapper.selectAll();
        int m = bannerMapper.selectCount();*/

        dto.setRows(bannerService.queryByPage(page, rows));
        dto.setTotal(bannerService.queryCount());
        System.out.println(dto);
        return dto;
    }

    @RequestMapping("update")
    public void updateBan(Banner banner) {
        bannerService.changeOne(banner);
    }

    @RequestMapping("addBanner")
    public void AddBanerController(Banner banner) {
        bannerService.addOne(banner);
    }

    //文件上传
    @RequestMapping("upload")
    public void upload(Banner banner, MultipartFile img, HttpServletRequest request) {
        System.out.println(banner);
        //1.处理文件上传
        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/img");
        //图片名称
        String filename = img.getOriginalFilename();
        //目标文件
        File file = new File(realPath + "/" + filename);
        //调用image工具类开始文件上传
        try {
            img.transferTo(file);
            //2.插入banner到数据库（img的名字存到banner）
            banner.setImgPath(filename);

            bannerService.addOne(banner);
        } catch (IOException e) {
            e.printStackTrace();


        }

    }
    @RequestMapping("removeOne")
    public void removeOneCon(Integer id){
        bannerService.removeOne(id);
    }
}
