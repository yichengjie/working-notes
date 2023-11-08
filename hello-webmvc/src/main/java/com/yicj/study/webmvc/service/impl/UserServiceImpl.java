package com.yicj.study.webmvc.service.impl;

import com.yicj.study.common.exception.BusinessException;
import com.yicj.study.common.exception.BusinessExceptionEnum;
import com.yicj.study.webmvc.repository.entity.UserEntity;
import com.yicj.study.webmvc.repository.mapper.UserMapper;
import com.yicj.study.webmvc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author yicj
 * @date 2023/11/8 12:11
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper ;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public long count() {
        UserEntity entity = new UserEntity() ;
//        entity.setName();
//        entity.setJob();
//        entity.setCompany();
//        if (true){
//            throw new BusinessException(BusinessExceptionEnum.USERNAME_EXIST_ERROR) ;
//        }
        return userMapper.count();
    }

    @Override
    public String register(String username) {
        if (!StringUtils.hasText(username)){
            throw new BusinessException(BusinessExceptionEnum.USERNAME_NOT_NULL) ;
        }
        return username;
    }
}
