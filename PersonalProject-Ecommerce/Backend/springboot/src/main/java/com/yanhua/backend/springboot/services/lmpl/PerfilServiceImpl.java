package com.yanhua.backend.springboot.services.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.yanhua.backend.springboot.entities.Perfil;
import com.yanhua.backend.springboot.repositories.PerfilRepository;
import com.yanhua.backend.springboot.services.PerfilService;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	@Qualifier("perfilRepository")
	private PerfilRepository perfilRepository;

	@Override
	public Perfil Insert(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	@Override
	public Perfil findByUsername(Integer username_id) {
		return perfilRepository.findByUsername(username_id);
	}
	
	
	
}