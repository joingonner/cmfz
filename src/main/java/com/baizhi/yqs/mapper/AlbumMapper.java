package com.baizhi.yqs.mapper;

import com.baizhi.yqs.entity.Album;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
    List<Album> selectByPage(@Param("curPage" )Integer curPage, @Param("pageSize")Integer pageSize);
}
