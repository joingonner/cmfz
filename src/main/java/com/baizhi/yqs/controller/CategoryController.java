package com.baizhi.yqs.controller;


import com.baizhi.yqs.entity.Category;
import com.baizhi.yqs.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("cate")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("queryAll")
    public List<Category> queryAll(HttpSession session){
        List<Category> categoryList = categoryService.queryAll();
        System.out.println(categoryList);
        session.setAttribute("catelist",categoryList);
        return categoryList;
    }

    @RequestMapping("queryOne")
    public Category queryOne(Integer id){
        System.out.println(id);
      return categoryService.queryOne(id);
    }

}
