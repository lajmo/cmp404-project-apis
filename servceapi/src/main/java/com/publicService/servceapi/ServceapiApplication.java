package com.publicService.servceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.publicService.servceApi", "com.publicService.model"})
@EnableJpaRepositories(basePackages = "com.publicService.model")
@EntityScan(basePackages = "com.publicService.model")
public class ServceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServceapiApplication.class, args);
	}

}
