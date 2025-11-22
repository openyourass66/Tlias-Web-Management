package com.zhang.Service.impl;

import com.zhang.Mapper.EmpMapper;
import com.zhang.Service.ReportService;
import com.zhang.pojo.JobOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    //统计员工职位
    @Override
    public JobOption getEmpJobData(){
        List<Map<String,Object>> list = empMapper.getEmpJobData();
        List<Object> jobList = list.stream().map(dataMap->dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap->dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }
    //统计性别数据
    @Override
    public List<Map<String,Object>> getEmpGenderData(){
        return empMapper.getEmpGenderData();
    }
}
