package com.smarttask.taskplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TaskPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskPlatformApplication.class, args);
	}

}
