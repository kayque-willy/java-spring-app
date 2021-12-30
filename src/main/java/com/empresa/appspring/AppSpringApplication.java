package com.empresa.appspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSpringApplication.class, args);
		System.out.println("App startard at http://localhost:8080/app-spring/");
	}

}
