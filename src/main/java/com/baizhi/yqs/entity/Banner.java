package com.baizhi.yqs.entity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    @Column(name="img_path")
    private String imgPath;
    private String status;
    @Column(name="pub_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date pubDate;
    private String description;
}
