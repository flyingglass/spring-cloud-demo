package com.github.flyingglass.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author fly
 */
@Component
@Slf4j
public class RestInfo {

    @Resource
    Environment env;

    public String info(String value) {
        try {
            value = String.format(
                    "[%s:%s]/%s/%s",
                    InetAddress.getLocalHost().getHostAddress(),
                    env.getProperty("server.port"),
                    env.getProperty("spring.application.name"),
                    value
            );
        } catch (UnknownHostException ignore) {
            ignore.printStackTrace();
        }
        return value;
    }
}
