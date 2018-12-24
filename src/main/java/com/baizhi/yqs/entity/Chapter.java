package com.baizhi.yqs.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter implements Serializable {
    @Id
    @Excel(name = "编号",width = 35)
    private String id;
    @Excel(name = "标题")
    private String title;
    @Excel(name = "大小",suffix = "MB")
    private Double size;
    @Excel(name = "描述")
    private String duration;
    @ExcelIgnore
    private String url;
    @Excel(name = "日期", format = "YYYY年MM月dd日", width = 20)
    @Column(name = "upload_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date uploadDate;
    @Column(name = "a_id")
    @ExcelIgnore
    private Integer Aid;
}
