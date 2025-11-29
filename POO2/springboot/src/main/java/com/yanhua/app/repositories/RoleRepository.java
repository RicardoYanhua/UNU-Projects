package com.yanhua.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yanhua.app.entities.Role;
import com.yanhua.app.entities.User;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Query("SELECT r FROM Role r WHERE r.authority = :role")
	Optional<Role> findByAutnRole(@Param("role") String role);
	
}



