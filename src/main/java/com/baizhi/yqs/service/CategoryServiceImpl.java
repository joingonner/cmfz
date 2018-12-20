package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Category;

import com.baizhi.yqs.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> queryAll() {
        return categoryMapper.queryAll();
    }

    @Override
    public Category queryOne(Integer id) {

        return categoryMapper.queryOne(id);
    }
}
