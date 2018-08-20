package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableWebMvc
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@MapperScan(basePackages = "com.example.demo.mapper")
public class SpringboApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboApplication.class, args);
	}
}
