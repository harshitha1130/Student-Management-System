package com.Project.Student_Mangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = {"dto", "entity", "repo", "service","controller","config","util"})

@EnableJpaRepositories(basePackages = "repo")
@EntityScan(basePackages = "entity")
public class StudentMangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMangementApplication.class, args);
	}

}
