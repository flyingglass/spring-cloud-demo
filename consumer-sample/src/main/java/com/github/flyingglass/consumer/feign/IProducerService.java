package com.github.flyingglass.consumer.feign;

import com.github.flyingglass.consumer.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        value = "service-user",
        configuration = {
                FeignConfig.class
        }
)

public interface IProducerService {
}
