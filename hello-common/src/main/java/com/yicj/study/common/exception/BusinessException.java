package com.yicj.study.common.exception;

import lombok.Getter;

import java.text.MessageFormat;

/**
 * @author yicj
 * @date 2023/11/8 14:55
 */
@Getter
public class BusinessException extends RuntimeException{
    private String code ;

    private String message ;


    public BusinessException(BusinessExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode() ;
        this.message = exceptionEnum.getMessage() ;
    }

    /**
     * 不写入堆栈信息，提高性能
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1}",this.getCode(),this.getMessage());
    }
}
