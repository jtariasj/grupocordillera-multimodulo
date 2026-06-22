package com.grupocordillera.atencion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AtencionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtencionServiceApplication.class, args);
	}

}
