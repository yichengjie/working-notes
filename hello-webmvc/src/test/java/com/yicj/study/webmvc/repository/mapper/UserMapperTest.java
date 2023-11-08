package com.yicj.study.webmvc.repository.mapper;

import com.yicj.study.webmvc.HelloWebMvcApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = HelloWebMvcApplication.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper ;

    @Test
    void count() {
        long count = userMapper.count();
        log.info("count : {}", count);
    }
}