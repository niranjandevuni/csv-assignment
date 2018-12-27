package com.prokarma.csv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
public class CsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvApplication.class, args);
	}
}

