package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuario;

public interface UsuarioService {
	public abstract List<Usuario> ListaUsuarios();
	public abstract Usuario InsertarUsuario(Usuario usuario);
	public abstract void EliminarUsuario(int id);

}
