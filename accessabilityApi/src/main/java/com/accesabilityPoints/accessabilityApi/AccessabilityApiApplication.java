package com.accesabilityPoints.accessabilityApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.accesabilityPoints.accessabilityApi", "com.accesabilityPoints.model"})
@EnableJpaRepositories(basePackages = "com.accesabilityPoints.model")
@EntityScan(basePackages = "com.accesabilityPoints.model")
public class AccessabilityApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessabilityApiApplication.class, args);
	}

}
