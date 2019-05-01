package com.example.POCcloudeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PocCloudEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocCloudEurekaServerApplication.class, args);
	}

}
