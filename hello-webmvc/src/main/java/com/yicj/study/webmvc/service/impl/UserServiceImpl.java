package com.yicj.study.webmvc.service.impl;

import com.yicj.study.webmvc.repository.mapper.UserMapper;
import com.yicj.study.webmvc.service.UserService;
import org.springframework.stereotype.Service;

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
        return userMapper.count();
    }
}
