package com.shibin.quizSerivice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizSeriviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizSeriviceApplication.class, args);
	}

}
