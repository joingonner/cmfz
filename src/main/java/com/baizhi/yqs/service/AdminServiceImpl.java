package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Admin;
import com.baizhi.yqs.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin getOne(Admin admin) {
        Admin admin1 = adminMapper.selectOne(admin);
        return admin1;
    }
}
