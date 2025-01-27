package com.Project.ComputerSeekho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages="com.example.*")
@EnableJpaRepositories(basePackages="com.example.*")
public class ComputerSeekhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerSeekhoApplication.class, args);
	}

}
