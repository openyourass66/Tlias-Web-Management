package com.zhang.Controller;

import com.zhang.Service.ReportService;
import com.zhang.pojo.JobOption;
import com.zhang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;
    //统计员工职位
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计职位数据");
        JobOption jobOption =reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    //统计性别
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计性别数据");
        List<Map<String,Object>> list = reportService.getEmpGenderData();
        return Result.success(list);
    }
}
