package com.baizhi.yqs.dto;

import com.baizhi.yqs.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerDto {
    private Integer total;
    private List<Banner> rows;
}
