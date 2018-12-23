package com.baizhi.yqs.dto;

import com.baizhi.yqs.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Integer total;
    private List<Album> rows;

}
