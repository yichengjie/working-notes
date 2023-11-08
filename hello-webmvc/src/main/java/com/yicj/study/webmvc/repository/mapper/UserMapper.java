package com.yicj.study.webmvc.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author yicj
 * @date 2023/11/8 11:42
 */
@Mapper
public interface UserMapper {

    long count() ;
}
