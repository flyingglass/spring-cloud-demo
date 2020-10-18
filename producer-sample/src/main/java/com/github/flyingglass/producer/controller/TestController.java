package com.github.flyingglass.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fly
 * 服务提供者测试
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping(path = "/rest/{value}")
    public String rest(@PathVariable(value = "value") String value) {

        log.info("调用路径：{}", value);

        return value;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Get Method, Return Hello World!";
    }

}
