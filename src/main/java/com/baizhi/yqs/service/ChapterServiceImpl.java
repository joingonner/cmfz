package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Chapter;
import com.baizhi.yqs.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    ChapterMapper chapterMapper;
    @Override
    public void addOneChapter(Chapter chapter) {
        chapterMapper.insertSelective(chapter);
    }
}
