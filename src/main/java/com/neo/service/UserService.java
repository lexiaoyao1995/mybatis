package com.neo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neo.mapper.UserMapper;
import com.neo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll(){
        return  userMapper.getAll();
    }

    public PageInfo findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.getAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

}
