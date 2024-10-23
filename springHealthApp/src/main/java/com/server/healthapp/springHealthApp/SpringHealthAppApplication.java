package com.server.healthapp.springHealthApp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan
public class SpringHealthAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHealthAppApplication.class, args);
	}

}
