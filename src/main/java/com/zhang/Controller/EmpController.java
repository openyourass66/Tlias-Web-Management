package com.zhang.Controller;

import com.zhang.Service.EmpService;
import com.zhang.pojo.Emp;
import com.zhang.pojo.EmpQueryParam;
import com.zhang.pojo.PageResult;
import com.zhang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    //分页查询
    @GetMapping()
    public Result page(EmpQueryParam  param) {
        log.info("分页查询,参数:{}", param);
        PageResult<Emp> pageResult = empService.page(param);
        return Result.success(pageResult);
    }
    //添加员工
    @PostMapping
    public Result insert(@RequestBody Emp emp){
        log.info("添加员工,参数:{}", emp);
        empService.add(emp);
        return Result.success(emp);
    }
}
