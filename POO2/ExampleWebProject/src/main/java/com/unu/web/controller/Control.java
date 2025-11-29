package com.unu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Control {
	
	@GetMapping("/Inicio")
	public ModelAndView Inicio() {
		ModelAndView modelAndView = new ModelAndView("WebPages/Inicio");
		return modelAndView;
	}
	
    @GetMapping("/")
    public String LocalRedirect() {
        return "redirect:/Inicio";
    }

}