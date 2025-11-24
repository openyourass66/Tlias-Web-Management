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

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    //分页查询
    @Override
    public PageResult<Clazz> page(ClazzQueryParam param){
        PageHelper.startPage(param.getPage(),param.getPageSize());
        List<Clazz> list = clazzMapper.list(param);
        Page<Clazz> p =(Page<Clazz>) list;
        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }
    //添加班级
    @Override
    public void add(Clazz clazz){
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.add(clazz);
    }
    //删除班级
    @Override
    public void deleteById(Integer id){
        clazzMapper.deleteById(id);
    }

}
