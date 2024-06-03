package com.cgsti.cgsti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CgstiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgstiApplication.class, args);
	}

}
