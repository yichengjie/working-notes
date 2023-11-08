package com.yicj.study.common.vo;

import lombok.Data;

/**
 * @author yicj
 * @date 2023/11/8 15:49
 */
@Data
public class CommonResponse<T> {

    private String code ;

    private String message ;

    private T data ;

    public static <T> CommonResponse<T> success(T data){
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode("00000");
        response.setMessage(null);
        response.setData(data);
        return response ;
    }


    public static <T> CommonResponse<T> fail(String code, String message){
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(null);
        return response ;
    }

}
