package com.education;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@MapperScan(basePackages = "com.education.mapper")
public class MarkingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarkingsystemApplication.class, args);
	}
}
