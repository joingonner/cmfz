package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Album;
import com.baizhi.yqs.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;
    @Override
    public List<Album> queryByPage(Integer curPage, Integer pageSize) {
        List<Album> albumList1 = albumMapper.selectByPage(curPage, pageSize);
        return albumList1;
    }
    @Override
    public int queryCount(Album album){
        int i = albumMapper.selectCount(album);
        return i;
    }

    @Override
    public void changeOne(Album album) {
        albumMapper.updateByPrimaryKey(album);
    }

    @Override
    public Album getOne(Integer id) {
        Album a = new Album();
        a.setId(id);
        Album album = albumMapper.selectOne(a);
        return album;
    }

    @Override
    public void addOne(Album album) {
        albumMapper.insert(album);
    }

    @Override
    public List<Album> queryAllAlbum() {
        List<Album> albumList = albumMapper.selectAll();
        return albumList;
    }

    @Override
    public List<Album> getAll() {

        List<Album> list = albumMapper.selectAll1();

        return list;
    }

}
