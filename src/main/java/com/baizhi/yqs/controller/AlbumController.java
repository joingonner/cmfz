package com.baizhi.yqs.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.yqs.dto.AlbumDto;
import com.baizhi.yqs.entity.Album;
import com.baizhi.yqs.service.AlbumService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    AlbumService albumService;
    @RequestMapping("albumpage")
    public AlbumDto queryByPageController(Integer page, Integer rows){
        System.out.println(page);
        System.out.println(rows);
        AlbumDto dto = new AlbumDto();
        List<Album> albumList = albumService.queryByPage(page, rows);
        dto.setRows(albumList);
        dto.setTotal(albumService.queryCount(null));
        //System.out.println(albumService.queryCount(new Album())+"lalalla");
        //System.out.println(dto);
        return  dto;
    }
    @RequestMapping("getOneAlbum")
    public Album getOneAlbum(Integer id){
        Album album = albumService.getOne(id);

        System.out.println(album);
        return album;
    }
    @RequestMapping("updateAlbum")
    public void updateAlbum(Album album){
        albumService.changeOne(album);
    }
    @RequestMapping("addAlbum")
    public void addAlbum(Album album, MultipartFile img, HttpServletRequest request) {

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
            album.setCoverImg(filename);

            albumService.addOne(album);
        } catch (IOException e) {
            e.printStackTrace();


        }

    }
    @RequestMapping("getAllAlbum")
    public List<Album> getAllAlbum(){
        List<Album> list = albumService.queryAllAlbum();
        return list;
    }
    @RequestMapping("export")
    public void export(HttpServletResponse response,HttpServletRequest request){
        List<Album> albumList = albumService.getAll();
        for (Album album : albumList) {
            String path ="/img/"+album.getCoverImg();
            String realPath = request.getSession().getServletContext().getRealPath(path);
            System.out.println(realPath);
            album.setCoverImg(realPath);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑和音频", "专辑表"),
                Album.class, albumList);
        try {
            String encode = URLEncoder.encode("Album.xls", "UTF-8");
            response.setHeader("content-disposition","attachment;filename="+encode);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
