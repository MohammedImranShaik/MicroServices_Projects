package com.adminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class MicroServicesAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesAdminServerApplication.class, args);
	}

}
