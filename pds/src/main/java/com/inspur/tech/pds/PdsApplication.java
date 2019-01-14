package com.inspur.tech.pds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.inspur.tech.pds.dao")
public class PdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdsApplication.class, args);
	}

}

