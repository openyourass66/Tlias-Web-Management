package com.zhang.Service;

import com.zhang.pojo.Clazz;
import com.zhang.pojo.ClazzQueryParam;
import com.zhang.pojo.PageResult;

public interface ClazzService {
    //分页查询
    PageResult<Clazz> findAll(ClazzQueryParam param);
}
