package com.medfusion.medfusion_auth_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MedfusionAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedfusionAuthServerApplication.class, args);
	}

}
