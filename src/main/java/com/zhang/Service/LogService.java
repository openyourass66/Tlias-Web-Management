package com.zhang.Service;

import com.zhang.pojo.LogQueryParam;
import com.zhang.pojo.OperateLog;
import com.zhang.pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> page(LogQueryParam param);
}
