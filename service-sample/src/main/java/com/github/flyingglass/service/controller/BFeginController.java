package com.github.flyingglass.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author fly
 * 作为例子自行探究
 * 1. 需要启动service-b
 * 2. 需要启动service-a
 */
@RestController
@Slf4j
@ConditionalOnProperty(name = "spring.application.name", havingValue = "service-b")
public class BFeginController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping(path = "/rest/{value}")
    public String rest(@PathVariable(value = "value") String value) {
        value = restTemplate.getForEntity("http://service-a/rest/" + value, String.class).getBody();

        log.info("调用路径：{}", value);

        return value;
    }

}
