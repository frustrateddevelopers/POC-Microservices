package com.example.POCMicroserviceTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class PocMicroserviceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocMicroserviceTwoApplication.class, args);
	}

}
