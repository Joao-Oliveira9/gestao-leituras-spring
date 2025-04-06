package com.exemplo.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoLeiturasApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestaoLeiturasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("salve");
	}
}
