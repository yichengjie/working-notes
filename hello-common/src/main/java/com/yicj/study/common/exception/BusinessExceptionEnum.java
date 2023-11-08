package com.yicj.study.common.exception;

import lombok.Getter;

/**
 * @author yicj
 * @date 2023/11/8 14:55
 */
@Getter
public enum BusinessExceptionEnum {

    USERNAME_EXIST_ERROR("100101", "用户名已经存在!"),
    USERNAME_NOT_NULL("100102", "用户名不能为空!"),
    ;

    private final String code ;

    private final String message ;

    BusinessExceptionEnum(String code, String message){
        this.code = code ;
        this.message = message ;
    }

}
