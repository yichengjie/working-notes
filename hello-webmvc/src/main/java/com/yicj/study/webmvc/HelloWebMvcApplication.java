package com.yicj.study.webmvc;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yicj
 * @date 2023/11/8 9:17
 */
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.yicj.study.webmvc.repository.mapper")
@ComponentScan(basePackages = "com.yicj.study")
public class HelloWebMvcApplication {
    public static void main(String[] args) {
        ConfigurableEnvironment env =
                SpringApplication.run(HelloWebMvcApplication.class, args).getEnvironment();
        log.info("启动成功：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
