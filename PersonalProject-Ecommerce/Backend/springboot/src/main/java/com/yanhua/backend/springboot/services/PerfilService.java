package com.yanhua.backend.springboot.services;

import com.yanhua.backend.springboot.entities.Perfil;

public interface PerfilService {
	
	Perfil Insert(Perfil perfil);
	Perfil findByUsername(Integer username_id);

}
