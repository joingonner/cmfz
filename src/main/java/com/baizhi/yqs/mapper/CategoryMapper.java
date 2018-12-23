package com.baizhi.yqs.mapper;

import com.baizhi.yqs.entity.Category;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {
    List<Category> queryAll();
    Category queryOne(@Param("id") Integer id);
}
