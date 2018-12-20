package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Banner;
import com.baizhi.yqs.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BannerServiceImpl implements BannerService{
    @Autowired
    BannerMapper bannerMapper;
    @Override
    public List<Banner> queryByPage(int curPage,int pageSize) {
        List<Banner> bannerList = bannerMapper.selectByPage(curPage, pageSize);
        for (Banner banner : bannerList) {
            System.out.println(banner);
        }
        return bannerList;
    }

    @Override
    public int queryCount() {
        int i = bannerMapper.selectCount();
        return i;
    }
}
