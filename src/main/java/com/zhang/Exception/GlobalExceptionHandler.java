package com.zhang.Exception;

import com.zhang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错啦~:{}",e.getMessage());
        return Result.error("服务器异常,请联系管理员");
    }
//    @ExceptionHandler
//    public Result handleDuplicateKeyException(DuplicateKeyException e){
//        log.error("程序出错啦~:{}",e);
//        String msg = e.getMessage();
//        int index = msg.indexOf("Duplicate entry");
//        String errMsg=msg.substring(index);
//        String[] split = errMsg.split(" ");
//        return Result.error(split[2] + "已存在");
//    }
}
