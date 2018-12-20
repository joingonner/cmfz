package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> queryByPage(int curPage,int pageSize);
    int queryCount();
}
