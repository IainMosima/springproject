package com.javaproject.springproject;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringprojectApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(SpringprojectApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "test"));
		var ctx = app.run(args);
		// var ctx = SpringApplication.run(SpringprojectApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getCustomProperty());
		
		// System.out.println(myFirstService.getJavaVersion());
		// System.out.println(myFirstService.getOsName());
		// System.out.println(myFirstService.readProperty());
	}

}
