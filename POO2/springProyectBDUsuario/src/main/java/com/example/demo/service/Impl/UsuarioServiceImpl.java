package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@Service("usuarioservice")
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	@Qualifier("usuariorepository")
	private  UsuarioRepository usuariorepository;
	
	@Override
	public List<Usuario> ListaUsuarios() {
		return usuariorepository.findAll();
	}

	@Override
	public Usuario InsertarUsuario(Usuario usuario) {
		return usuariorepository.save(usuario);
	}

	@Override
	public void EliminarUsuario(int id) {
		if(usuariorepository.existsById(id)) {
			usuariorepository.deleteById(id);
		}
		
	}

}
