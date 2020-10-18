package com.github.flyingglass.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author fly
 */
@Component
@Slf4j
public class RestInfo {

    @Resource
    Environment env;

    public String info(String value) {
        return value;
    }
}
