package com.baizhi.yqs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="menu")
public class Category implements Serializable {
    private Integer id;
    private String title;
    private String url;
    private String iconcls;
    private Category category;
}
