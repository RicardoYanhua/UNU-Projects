package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;



@Controller
@RequestMapping("/user")

public class UsuarioController {

	@Autowired
	@Qualifier("usuarioservice")
	private UsuarioService usuarioService;

	@GetMapping("/list")
	public ModelAndView listaUsuarios() {
		
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("listaUsuarios", usuarioService.ListaUsuarios());
		mav.addObject("Usuario", new Usuario());
		return mav;
	}
	
	@PostMapping("/adduser")
    public String addUser(@ModelAttribute(name = "Usuario") Usuario usuario) {
        usuarioService.InsertarUsuario(usuario);
        return "redirect:/user/list";
    }
	
	@PostMapping("/delete/{id}")
	public String eliminarEntidad(@PathVariable(name = "id") int id) {
		usuarioService.EliminarUsuario(id);
		return "redirect:/user/list";
	}
	

}
