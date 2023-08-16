package com.goorm.profileboxcomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.goorm")
public class ProfileBoxCommApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileBoxCommApplication.class, args);
	}

}
