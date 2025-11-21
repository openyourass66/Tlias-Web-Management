package com.zhang.Mapper;

import com.zhang.pojo.Emp;
import com.zhang.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    //查询员工
    List<Emp> list(EmpQueryParam  param);
    //添加员工
//    @Options(useGeneratedKeys = true,keyColumn = "id")
    void add(Emp emp);

}
