package com.zhang.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.Mapper.ClazzMapper;
import com.zhang.Service.ClazzService;
import com.zhang.pojo.Clazz;
import com.zhang.pojo.ClazzQueryParam;
import com.zhang.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    //分页查询
    @Override
    public PageResult<Clazz> findAll(ClazzQueryParam param){
        PageHelper.startPage(param.getPage(),param.getPageSize());
        List<Clazz> clazzList =clazzMapper.list(param);
        Page<Clazz> p =(Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }

}
