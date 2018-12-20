package com.baizhi.yqs.conf;

//@RequestMappimg()注解是做一个路径的映射

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("upload")
//@ResponseBody注解是将方法的返回值以特定的格式返回，在此我用的是json的数据格式，其配置在springmvc.xml的配置文件中，并且需要引入相关的jar
@ResponseBody
public class FileUp{
   /* public String  upload(MultipartFile image, HttpServletRequest request){


        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("cmzf/img");
        try {
            //定义一个新的文件名称，在这里我上传的是图片文件并且不需要下载，所以我直接把文件的后缀名写死成了.png格式
            String impPath = UUID.randomUUID().toString() + ".png";
            //new一个新的文件
            File file = new File(realPath, impPath);
            //调用image工具类开始文件上传
            image.transferTo(file);
            //文件上传成功，定义map的返回信息
           return impPath;
        } catch (IOException e) {
            //如果有异常，在此我是用的自定义异常用于返回至前端页面，如果需要查看异常的信息的话可以e.printStackTrace();
            return null;
        }


    }*/
}
