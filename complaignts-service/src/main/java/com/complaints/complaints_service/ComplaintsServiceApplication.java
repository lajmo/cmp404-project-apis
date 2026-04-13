package com.complaints.complaints_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.complaints.complaints_service", "com.complaints.model"})
@EnableJpaRepositories(basePackages = "com.complaints.model")
@EntityScan(basePackages = "com.complaints.model")
public class ComplaintsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintsServiceApplication.class, args);
	}

}
