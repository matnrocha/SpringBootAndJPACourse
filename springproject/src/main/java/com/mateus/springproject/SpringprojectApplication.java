package com.mateus.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringprojectApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringprojectApplication.class, args);
		var dk = ctx.getBean(AppService.class).getMyVar();
		System.out.println(dk);

	}


}
