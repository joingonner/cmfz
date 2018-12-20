package com.baizhi.yqs.service;

import com.baizhi.yqs.entity.Admin;
import com.baizhi.yqs.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;
    @Override
    public boolean login(Admin admin) {
        final List<Admin> list = adminMapper.select(admin);
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }
}
