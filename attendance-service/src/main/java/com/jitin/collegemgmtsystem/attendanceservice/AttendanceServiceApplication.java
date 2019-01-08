package com.jitin.collegemgmtsystem.attendanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AttendanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceServiceApplication.class, args);
	}

}

