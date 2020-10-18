package com.github.flyingglass.service.feign;

import com.github.flyingglass.service.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fly
 */
@FeignClient(
        value = "service-producer",
        configuration = {
                FeignConfig.class
        }
)
public interface IProducerService {
        /**
         * invoke
         * @param value
         * @return
         */
        @GetMapping(path = "/rest/{value}")
        String invoke(@PathVariable(value = "value") String value);
}
