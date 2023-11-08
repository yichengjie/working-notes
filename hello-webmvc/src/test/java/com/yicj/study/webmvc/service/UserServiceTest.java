package com.yicj.study.webmvc.service;

import com.yicj.study.webmvc.repository.mapper.UserMapper;
import com.yicj.study.webmvc.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.when;


//@SpringBootTest(classes = HelloWebMvcApplication.class)
@SpringJUnitConfig(UserServiceTest.Config.class)
class UserServiceTest {

    @Import(UserServiceImpl.class)
    @Configuration
    static class Config{

    }

    @MockBean
    private UserMapper userMapper ;

    @Autowired
    private UserService userService ;

    @Test
    public void register(){
        when(userMapper.count()).thenReturn(1L) ;
        userService.register(null) ;
    }
}