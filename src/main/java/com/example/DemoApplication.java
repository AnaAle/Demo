package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

/**
 * https://medium.com/@gustavo.ponce.ch/spring-boot-restful-tutorial-7f0e314242ef
 */

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(EmployeeRepository empleadoRepository) {
		return (args) -> {
			empleadoRepository.save(new Employee("Gustavo","Ponce", true));
			empleadoRepository.save(new Employee("John", "Smith", true));
			empleadoRepository.save(new Employee("Jim ", "Morrison", false));
			empleadoRepository.save(new Employee("David", "Gilmour", true));
		};
	}
}

