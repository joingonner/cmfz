package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Category;


import java.util.List;

public interface CategoryService {
    List<Category> queryAll();
    Category queryOne(Integer id);
}
