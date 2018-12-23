package com.baizhi.yqs.controller;

import com.baizhi.yqs.entity.Chapter;
import com.baizhi.yqs.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("addFile")
public class ChapterController {
    @Autowired
    ChapterService chapterService;
    @RequestMapping("addChapter")
    public void addChapter(Chapter chapter, MultipartFile path, HttpServletRequest request){
        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/music");
        //图片名称
        String filename = path.getOriginalFilename();
        //目标文件
        File file = new File(realPath + "/" + filename);
        //调用image工具类开始文件上传
        try {
            path.transferTo(file);
            //2.插入Chapter到数据库（url的名字寻到Chapter）

            String id = UUID.randomUUID().toString().replace("-","");
            chapter.setId(id);
            chapter.setUrl(filename);
            System.out.println(chapter);
            chapterService.addOneChapter(chapter);
        } catch (IOException e) {
            e.printStackTrace();


        }

    }
    @RequestMapping("addq1")
    public void addChapter(Chapter chapter){


            String id = UUID.randomUUID().toString().replace("-","");
            chapter.setId(id);
            System.out.println(chapter);
            chapterService.addOneChapter(chapter);

    }
}
