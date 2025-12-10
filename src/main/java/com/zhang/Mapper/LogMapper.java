package com.zhang.Mapper;

import com.zhang.pojo.LogQueryParam;
import com.zhang.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("select o.*,e.name empName from operatelog o left join emp e on o.operateEmpId=e.id order by o.operateTime desc")
    List<OperateLog> page(LogQueryParam  param);
}
