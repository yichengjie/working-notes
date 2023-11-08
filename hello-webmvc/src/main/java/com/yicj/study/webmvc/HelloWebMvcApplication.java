package com.yicj.study.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yicj
 * @date 2023/11/8 9:17
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.yicj.study")
public class HelloWebMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWebMvcApplication.class, args) ;
    }
}
