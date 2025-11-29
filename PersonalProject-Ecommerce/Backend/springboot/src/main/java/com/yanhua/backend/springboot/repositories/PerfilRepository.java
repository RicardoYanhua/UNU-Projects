package com.yanhua.backend.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yanhua.backend.springboot.entities.Perfil;

@Repository("perfilRepository")
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
	
	@Query("SELECT p FROM Perfil p WHERE p.usuario = :username")
	Perfil findByUsername(@Param("username") Integer username_id);
	
}



