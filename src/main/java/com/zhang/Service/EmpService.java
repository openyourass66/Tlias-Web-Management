package com.zhang.Service;

import com.zhang.pojo.Emp;
import com.zhang.pojo.EmpQueryParam;
import com.zhang.pojo.PageResult;

public interface EmpService {
    //分页查询
    PageResult<Emp> page(EmpQueryParam  param);
    //添加员工
    void add(Emp emp);
}
