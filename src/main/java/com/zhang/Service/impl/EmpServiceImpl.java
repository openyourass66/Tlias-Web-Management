package com.zhang.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.Mapper.EmpExprMapper;
import com.zhang.Mapper.EmpMapper;
import com.zhang.Service.EmpService;
import com.zhang.pojo.Emp;
import com.zhang.pojo.EmpExpr;
import com.zhang.pojo.EmpQueryParam;
import com.zhang.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    //分页查询
    @Override
    public PageResult<Emp> page(EmpQueryParam  param){
        PageHelper.startPage(param.getPage(),param.getPageSize());
        List<Emp> empList=empMapper.list(param);
        Page<Emp> p =(Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(),p.getResult());

    }
    //添加员工
    @Override
    public void add(Emp emp){
        //保存员工基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
        System.out.println("新增员工的id" + emp.getId());
        //保存员工工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            for (EmpExpr expr : exprList) {
                expr.setEmpId(emp.getId());
            }
            empExprMapper.addBatch(exprList);
        }
    }

}
