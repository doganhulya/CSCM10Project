package com.iot.device;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableCaching
@ComponentScan("com.iot.*")
@EnableJpaRepositories(basePackages = { "com.iot" })
@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
@ImportResource("classpath:META-INF/camel-context.xml")
public class IotServiceApplication {

	protected static Logger logger = Logger.getLogger(IotServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(IotServiceApplication.class, args);
	}

}
