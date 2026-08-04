package com.example.SecuritySociety;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
		//(exclude = {DataSourceAutoConfiguration.class})
public class SecuritySocietyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritySocietyApplication.class, args);
	}

}
