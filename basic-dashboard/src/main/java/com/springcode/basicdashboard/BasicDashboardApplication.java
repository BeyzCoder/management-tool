package com.springcode.basicdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@RestController
public class BasicDashboardApplication {

	@GetMapping
	public String getMethodName() {
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BasicDashboardApplication.class, args);
	}

}
