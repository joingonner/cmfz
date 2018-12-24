package com.baizhi.yqs.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ExcelIgnore
    private Integer id;
    @Excel(name = "标题" ,needMerge = true)
    private String title;
    @ExcelIgnore
    private Integer count;
    @Excel(name = "专辑图片", type = 2, width = 20, height = 20,needMerge =true)
    @Column(name = "cover_img")
    private String coverImg;

    private Integer score;
    @ExcelIgnore
    private String auther;
    @ExcelIgnore
    private String broadcast;
    @ExcelIgnore
    private String brief;
    @ExcelIgnore
    @Column(name = "pub_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date pubDate;
    @Transient
    @ExcelCollection(name = "音频详情")
    List<Chapter> children;
}
