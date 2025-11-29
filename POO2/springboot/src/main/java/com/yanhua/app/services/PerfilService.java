package com.yanhua.app.services;

import com.yanhua.app.entities.Perfil;

public interface PerfilService {
	
	Perfil Insert(Perfil perfil);
	Perfil findByUsername(Integer username_id);

}
