package com.zhang.Service;

import com.zhang.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    //统计职位数据
    JobOption getEmpJobData();
    //统计性别数据
    List<Map<String, Object>> getEmpGenderData();
}
