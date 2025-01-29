package com.Project.ComputerSeekho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.Project.*")
@EntityScan(basePackages="com.Project.*")
@EnableJpaRepositories(basePackages="com.Project.*")
public class ComputerSeekhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerSeekhoApplication.class, args);
	}
}