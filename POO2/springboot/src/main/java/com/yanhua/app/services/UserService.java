package com.yanhua.app.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yanhua.app.entities.Perfil;
import com.yanhua.app.entities.User;
import com.yanhua.app.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Qualifier("userService")
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if (username == null || username.isEmpty()) {
			throw new UsernameNotFoundException("Nombre de usuario no proporcionado");
		}
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no fue encontrado"));

		
	}
	
	public Optional<User> findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User insertarUsuario(User usuario) {
		return userRepository.save(usuario);
	}
	

	

}