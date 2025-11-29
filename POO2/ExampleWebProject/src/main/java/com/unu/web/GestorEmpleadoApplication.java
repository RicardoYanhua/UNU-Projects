package com.unu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.unu.web.service.ContratoService;

@SpringBootApplication
public class GestorEmpleadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorEmpleadoApplication.class, args);
	}

}

@Component
class InicializadorApp implements CommandLineRunner {
	
	@Autowired
	@Qualifier("contratoService")
	private ContratoService contratoService;

	@Override
	public void run(String... args) throws Exception {
		//contratoService.ActualizarEstadosContratos();
	}
}
