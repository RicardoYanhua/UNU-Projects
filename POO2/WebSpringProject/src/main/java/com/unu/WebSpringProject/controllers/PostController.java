package com.unu.WebSpringProject.controllers;

import org.apache.commons.logging.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unu.WebSpringProyect.models.Persona;


//TAGS_CONTROLLER
@Controller
@RequestMapping("/PostController")
public class PostController {

	
	
	/*
	// REDIRECCIONAR FORMA 1
	@GetMapping("/")
	public String redirect1() {
		return "redirect:/PostController/form";
	}
	*/
	
	// REDIRECCIONAR FORMA 2
	@GetMapping("/")
	public RedirectView redirect2() {
		return new RedirectView("/PostController/form");
	}
	
	@GetMapping("/form")
	public String Form(Model model) {
		model.addAttribute("Persona", new Persona());
		return "formulario";
	}
	
	@PostMapping("/addPersona")
	public ModelAndView Resultado(@ModelAttribute("Persona") Persona persona) {
		
		ModelAndView modelAndView = new ModelAndView("resultado");
		modelAndView.addObject("Persona",persona);
		return modelAndView;
	}
	
	
}
