package com.github.flyingglass.zuul;

import com.didispace.swagger.butler.EnableSwaggerButler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Administrator
 */
@SpringCloudApplication
@EnableZuulProxy
@EnableSwaggerButler
@Slf4j
public class ZuulApplication {

	public static void main(String[] args) throws UnknownHostException {
		Environment env = SpringApplication.run(ZuulApplication.class, args).getEnvironment();

		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://127.0.0.1:{}\n\t"
						+ "External: \thttp://{}:{}"
						+ "\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port")
		);

		log.info(env.getProperty("eureka.instance.ip-address"));


	}

}
