package com.yicj.study.webmvc.web.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author yicj
 * @date 2023/11/8 15:44
 */
@Data
public class UserSaveRequest {

    @NotBlank(message = "用户名不能为空!")
    private String username ;

    private String job ;

}
