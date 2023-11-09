package com.yicj.study.webmvc.web.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author yicj
 * @date 2023/11/9 9:09
 */
@Data
public class UserListResponse {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id ;
}
