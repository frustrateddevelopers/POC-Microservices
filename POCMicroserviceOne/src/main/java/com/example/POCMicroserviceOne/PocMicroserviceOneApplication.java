package com.example.POCMicroserviceOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PocMicroserviceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocMicroserviceOneApplication.class, args);
	}

}
