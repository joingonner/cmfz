package com.baizhi.yqs.mapper;

import com.baizhi.yqs.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    List<Category> queryAll();
    Category queryOne(@Param("id") Integer id);
}
