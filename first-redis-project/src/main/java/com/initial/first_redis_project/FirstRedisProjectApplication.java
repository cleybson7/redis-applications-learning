package com.initial.first_redis_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class FirstRedisProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRedisProjectApplication.class, args);
	}

}
