package com.ahmetarabaci.cacheservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ahmetarabaci.*"})
@EnableCaching
public class CacheApp {

	public static void main(String[] args) {
		SpringApplication.run(CacheApp.class, args);
	}
	
}

