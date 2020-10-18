package com.github.flyingglass.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fly
 * 服务提供者测试
 */
@RestController
@Slf4j
@ConditionalOnProperty(name = "spring.application.name", havingValue = "service-a")
public class AFeginController {

    @Resource
    RestInfo restInfo;

    @GetMapping(path = "/rest/{value}")
    public String rest(@PathVariable(value = "value") String value) {

        value = restInfo.info(value);
        log.info("调用路径：{}", value);

        return value;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Get Method, Return Hello World!";
    }

}
