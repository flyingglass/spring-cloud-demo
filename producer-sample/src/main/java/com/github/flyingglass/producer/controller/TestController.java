package com.github.flyingglass.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fly
 * 服务提供者测试
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("/get")
    String get() {
        return "Get Method, Return Hello World!";
    }

}
