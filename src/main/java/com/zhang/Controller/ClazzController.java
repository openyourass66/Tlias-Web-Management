package com.zhang.Controller;

import com.zhang.Service.ClazzService;
import com.zhang.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    //分页查询
    @GetMapping()
    public Result  page(ClazzQueryParam param){
        log.info("分页查询,参数:{}", param);
        PageResult<Clazz> pageResult = clazzService.findAll(param);
        return Result.success(pageResult);
    }
}
