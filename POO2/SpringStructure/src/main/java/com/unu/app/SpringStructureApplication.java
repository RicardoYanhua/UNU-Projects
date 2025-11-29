package com.unu.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringStructureApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringStructureApplication.class, args);
	}
}

@Component
class InicializadorApp implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		// Metodos de arranque
	}
}