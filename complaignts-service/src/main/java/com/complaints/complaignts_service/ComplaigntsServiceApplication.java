package com.complaints.complaignts_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.complaingts.complaingts_service", "com.complaingts.model"})
@EnableJpaRepositories(basePackages = "com.complaingts.model")
@EntityScan(basePackages = "com.complaingts.model")
public class ComplaigntsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaigntsServiceApplication.class, args);
	}

}
