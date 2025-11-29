package com.unu.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.unu.app.service.ProductoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/Producto")
public class ProductoController {

	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;
	
	@GetMapping("/Listar")
	public ModelAndView Listar(
			@RequestParam(name = "sucessDelete", required = false) boolean sucessDelete
			) {
		ModelAndView modelAndView = new ModelAndView("Producto/lista");
		modelAndView.addObject("registros", productoService.Listar());
		modelAndView.addObject("EliminarRegistroSuccess", sucessDelete);
		return modelAndView;
	}

	@PostMapping("/Eliminar/{id}")
	public ModelAndView Eliminar(@PathVariable(name = "id") int id) {
		productoService.Eliminar(id);
		return new ModelAndView("redirect:/Producto/Listar?sucessDelete=true");
	}


}
