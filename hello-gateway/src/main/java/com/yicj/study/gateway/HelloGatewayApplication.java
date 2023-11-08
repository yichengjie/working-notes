package com.yicj.study.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yicj
 * @date 2023/11/8 10:30
 */
@Slf4j
@SpringBootApplication
public class HelloGatewayApplication {

    public static void main(String[] args) {
        ConfigurableEnvironment env =
                SpringApplication.run(HelloGatewayApplication.class, args).getEnvironment();
        log.info("启动成功：\thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
