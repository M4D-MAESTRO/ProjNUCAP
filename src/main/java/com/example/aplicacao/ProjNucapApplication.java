package com.example.aplicacao;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.example"})
public class ProjNucapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjNucapApplication.class, args);
	}
}
