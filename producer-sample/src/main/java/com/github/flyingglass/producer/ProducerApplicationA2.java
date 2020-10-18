package com.github.flyingglass.producer;

import com.spring4all.swagger.EnableSwagger2Doc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Administrator
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2Doc
@Slf4j
@EnableFeignClients
public class ProducerApplicationA2 {

	public static void main(String[] args) throws UnknownHostException {
		System.setProperty("spring.profiles.active", "a2");

		Environment env = SpringApplication.run(ProducerApplicationA2.class, args).getEnvironment();

		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://127.0.0.1:{}\n\t"
						+ "External: \thttp://{}:{}"
						+ "\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port")
		);
	}

}
