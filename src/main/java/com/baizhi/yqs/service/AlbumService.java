package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> queryByPage(Integer curPage,Integer pageSize);
    int queryCount(Album album);
    void changeOne(Album album);
    Album getOne(Integer id);
    void addOne(Album album);
    List<Album>queryAllAlbum();
}
