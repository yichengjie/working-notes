package com.yicj.study.webmvc.web.controller;

import com.yicj.study.webmvc.web.request.UserSaveRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yicj
 * @date 2023/11/8 9:37
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/index")
    public String index(){

        return "hello index" ;
    }

    @PostMapping("/register")
    public String register(@Valid UserSaveRequest request){

        return "success" ;
    }
}
