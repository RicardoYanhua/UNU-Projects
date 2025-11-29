package com.unu.WebSpringProject.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



//TAGS_CONTROLLER
@Controller
@RequestMapping("/LogController")
public class LogController {
	
	private static final Log LOG=LogFactory.getLog(LogController.class);
	
	@GetMapping("/Metodo1")
	public String EntrarVista1() {
		LOG.info("Ingresa al view 3");
		return  "vista3";
	}
	

}
