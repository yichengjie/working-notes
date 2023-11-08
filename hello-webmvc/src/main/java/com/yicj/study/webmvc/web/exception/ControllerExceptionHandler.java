package com.yicj.study.webmvc.web.exception;

import com.yicj.study.common.exception.BusinessException;
import com.yicj.study.common.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author yicj
 * @date 2023/11/8 15:48
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public CommonResponse<Void> runtimeHandle(RuntimeException ex){
        log.error("业务异常：", ex);
        return CommonResponse.fail("100000", "系统异常，请联系管理员!") ;
    }

    @ExceptionHandler(BusinessException.class)
    public CommonResponse<Void> businessHandle(BusinessException ex){
        log.error("业务异常：", ex);
        return CommonResponse.fail(ex.getCode(), ex.getMessage()) ;
    }

    @ExceptionHandler(BindException.class)
    public CommonResponse<Void> exceptionHandle(BindException ex){
        log.error("校验异常：{}", ex.getMessage());
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder builder = new StringBuilder() ;
        for (ObjectError error: allErrors){
            //String name = error.getObjectName();
            String defaultMessage = error.getDefaultMessage();
            builder.append("[");
            builder.append(defaultMessage) ;
            builder.append("] ") ;
        }
        return CommonResponse.fail("1000001", builder.toString()) ;
    }

}
