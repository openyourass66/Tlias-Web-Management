package com.zhang.Mapper;

import com.zhang.pojo.Clazz;
import com.zhang.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> list(ClazzQueryParam param);
}
