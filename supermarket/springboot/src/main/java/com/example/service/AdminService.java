package com.example.service;

import com.example.entity.Admin;
import com.example.exception.CustomException;
import com.example.mapper.AdminMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;

    public void add(Admin admin) {
        if(ObjectUtils.isEmpty(admin.getPassword())) {
            admin.setPassword("123456");
        }
        adminMapper.insert(admin);
    }

    public PageInfo<Admin> selectPage(Integer pageNum, Integer pageSize, Admin admin) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin>list=adminMapper.selectAll(admin);
        return PageInfo.of(list);
    }

    public void update(Admin admin) {
        adminMapper.updateById(admin);
    }

    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    public Admin login(Admin admin) {
     Admin dbAdmin= adminMapper.selectByUsernameAndPassword(admin);
     if(ObjectUtils.isEmpty(dbAdmin)) {
         throw new CustomException("用户名或密码错误");
     }
     return dbAdmin;

    }

    public void updatePassword(Admin admin) {
        if(!admin.getNewPassword().equals(admin.getNew2Password())) {
            throw new CustomException("两次密码不一致");
        }
        admin.setPassword(admin.getNewPassword());
        adminMapper.updateById(admin);

    }
}
