package com.unu.WebSpringProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.unu.WebSpringProyect.models.*;

import lombok.experimental.PackagePrivate;


//  TAGS_CONTROLLER
@Controller
@RequestMapping("/MetodosController")
	
public class MetodosController {
	
	
		
	
		
		
		@GetMapping("/listarPersona")
		public ModelAndView ejecutarMetodo2() {
			
			// REDIRECCIONA A LA VISTA 2
			ModelAndView modelAndView = new ModelAndView("listaPersonas");
			// OBTENER INFORMACION EN UN PARAMETER
 			modelAndView.addObject("p",getPersonas());
 			
			return modelAndView;
		}
		
		@GetMapping("/metodo3")
		// OBTENER PARAMETER DEL HTML 
		public ModelAndView EjecutarMetodo3(@RequestParam(name="nombre") String nombre) {
			ModelAndView modelAndView = new ModelAndView("vista3");
			// OBTENER INFORMACION EN UN PARAMETER
 			modelAndView.addObject("nombre",nombre);
 			
			return modelAndView;
		}
		
		@GetMapping("/metodo4/{nombre}")
		// OBTENER PARAMETER DEL HTML 
		public ModelAndView EjecutarMetodo4(@PathVariable(name="nombre") String nombre) {
			ModelAndView modelAndView = new ModelAndView("vista4");
			// OBTENER INFORMACION EN UN PARAMETER
 			modelAndView.addObject("nombre",nombre);
 			
			return modelAndView;
		}
	
		// DATA TEST
		private List<Persona> getPersonas(){
			
			List<Persona> lista = new ArrayList<Persona>();
			
			lista.add(new Persona("Persona1" , "Telefono1"));
			lista.add(new Persona("Persona2" , "Telefono2"));
			lista.add(new Persona("Persona3" , "Telefono3"));
			lista.add(new Persona("Persona4" , "Telefono4"));
			lista.add(new Persona("Persona5" , "Telefono5"));
			
			return lista;
		}
		
	
		
		
		

}
