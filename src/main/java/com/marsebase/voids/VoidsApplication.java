package com.marsebase.voids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class VoidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoidsApplication.class, args);
	}

}
