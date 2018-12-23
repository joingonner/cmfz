package com.baizhi.yqs.controller;

import com.baizhi.yqs.entity.Chapter;
import com.baizhi.yqs.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.math.BigDecimal;
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
        //名称
        String filename = path.getOriginalFilename();
        //目标文件
        File file = new File(realPath,path.getOriginalFilename());

        //计算音频时长大小
        long length = 0L;
        Encoder encoder = new Encoder();
        try {
            //getInfo()的参数是一个File,不能用MultipartFile
            //getDuration()获取得到的文件时长是一个以毫秒为单位的long类型的数值
            length = encoder.getInfo(file).getDuration();

        } catch (Exception e) {
            //如果这里有异常也定义返回的map为失败
        }
        //打印一下文件时长
        System.out.println(length/1000/60+"分"+length/1000%60+"秒");
        String time =length/1000/60+"分"+length/1000%60+"秒";
        //得到音频内存大小，是一个以字节为单位的long类型的数值
        //在此我用BigDecimal将其保留两位小数
        BigDecimal size = new BigDecimal(path.getSize());
        BigDecimal mod = new BigDecimal(1024);
        //除两个1024，保留两位小数，进行四舍五入
        size = size.divide(mod).divide(mod).setScale(2, BigDecimal.ROUND_HALF_UP);
        double doubleValue = size.doubleValue();


        //调用image工具类开始文件上传
        try {
            path.transferTo(file);
            //2.插入Chapter到数据库（url的名字寻到Chapter）

            String id = UUID.randomUUID().toString().replace("-","");
            chapter.setId(id);
            chapter.setUrl(filename);
            chapter.setSize(doubleValue);
            chapter.setDuration(time);
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
    @RequestMapping("download")
    public void downloadChapter(HttpServletRequest request,HttpServletResponse response,String musicName) throws Exception {
        //首先为了保险起见，打印一接收的文件名

        System.out.println(musicName);
        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/music");
        //new一个文件
        File file = new File(realPath, musicName);
        //设置响应头
        //Content-disposition 是 MIME 协议的扩展它会激活文件下载对话框
        //attachment是下载文件，如果需要在线预览的话修改成inline	filename就是文件下载时保存的文件名
        //new String(musicName.getBytes("UTF-8"),"ISO8859-1")如果不加这个的话下载后的文件名有中文的话会出现乱码，文件下载的时候默认使用的ISO8859-1编码格式，需要手动改成UTF-8的格式
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(musicName.getBytes("UTF-8"), "ISO8859-1"));
        //声明一个输出流
        ServletOutputStream os = null;
        try {
            //初始化刚才定义的输出流
            os = response.getOutputStream();
            //文件拷贝，也是文件下载
            FileUtils.copyFile(file, os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //输出流使用完毕之后将其关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
