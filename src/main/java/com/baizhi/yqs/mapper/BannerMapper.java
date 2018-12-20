package com.baizhi.yqs.mapper;

import com.baizhi.yqs.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    List<Banner> selectByPage(@Param("curPage" )Integer curPage,@Param("pageSize")Integer pageSize);
    int selectCount();
}
