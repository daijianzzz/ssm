package com.test.controller;

import com.test.domain.Code;
import com.test.domain.Result;
import com.test.exception.BusinessException;
import com.test.exception.SystemException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice
public class ExceptionControllerAdvice {

    // 业务异常
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result doBusinessException(BusinessException e) {
        return new Result(Code.OPERATOR_EXCEPTION, e.getMessage());
    }

    // 系统异常系列
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public Result doSystemException(SystemException e) {
        return new Result(Code.SYSTEM_EXCEPTION, e.getMessage());
    }

    // 未知异常系列
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception em) {
        return new Result(Code.OTHER_EXCEPTION, "未知异常");
    }
}
