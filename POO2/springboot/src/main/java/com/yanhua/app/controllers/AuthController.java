package com.yanhua.app.controllers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yanhua.app.entities.Perfil;
import com.yanhua.app.entities.Role;
import com.yanhua.app.entities.User;
import com.yanhua.app.models.GoogleLoginRequest;
import com.yanhua.app.models.LoginRequest;
import com.yanhua.app.models.UserGoogleRegister;
import com.yanhua.app.models.UserRegister;
import com.yanhua.app.repositories.RoleRepository;
import com.yanhua.app.services.PerfilService;
import com.yanhua.app.services.JwtService;
import com.yanhua.app.services.UserService;

import jakarta.validation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("perfilService")
	private PerfilService perfilService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest body, HttpServletResponse response) {
		try {
			Authentication auth = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword()));
			String token_jwt = jwtService.generateJwt(auth);
			return ResponseEntity.ok(Collections.singletonMap("jwt", token_jwt));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
		}

	}
	
	
	@PostMapping("/google")
	public ResponseEntity<?> loginConGoogle(@RequestBody GoogleLoginRequest request) {
	    try {
	        DecodedJWT decoded = JWT.decode(request.getIdToken());
	        String email = decoded.getClaim("email").asString();
	        Optional<User> usuario = userService.findUserByUsername(email);

	        
	        if (usuario.isPresent()) {
	            User user = usuario.get();
	            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
	                user, null, user.getAuthorities()
	            );
	            String jwt = jwtService.generateJwt(auth);
	            return ResponseEntity.ok(Collections.singletonMap("jwt", jwt));
	        } else {
	        	String picture = decoded.getClaim("picture").asString();
	            Map<String, String> data = new HashMap<>();
	            data.put("error", "USER_NOT_FOUND");
	            data.put("email", email);
	            data.put("picture", picture);

	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
	        }

	    }  catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Collections.singletonMap("error", "internal_error"));
	    }
	}
	/*
	public static String ObtenerFotoAleatorio() {
		Random random = new Random();
        List<String> nombres = Arrays.asList(
            "https://img.freepik.com/free-psd/3d-render-avatar-character_23-2150611737.jpg?ga=GA1.1.556517224.1750202172&semt=ais_items_boosted&w=200	",
            "https://img.freepik.com/premium-psd/3d-illustration-with-online-avatar_23-2151303107.jpg?ga=GA1.1.556517224.1750202172&semt=ais_items_boosted&w=200",
            "https://img.freepik.com/free-psd/3d-rendering-hair-style-avatar-design_23-2151869139.jpg?ga=GA1.1.556517224.1750202172&semt=ais_items_boosted&w=200",
            "https://img.freepik.com/free-psd/3d-rendering-avatar_23-2150833554.jpg?ga=GA1.1.556517224.1750202172&semt=ais_items_boosted&w=200",
            "https://img.freepik.com/premium-psd/3d-render-cartoon-avatar-isolated_570939-44.jpg?ga=GA1.1.556517224.1750202172&semt=ais_items_boosted&w=200",
            "https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436188.jpg?semt=ais_hybrid&w=200"
        );
        
        int indice = random.nextInt(nombres.size());
        return nombres.get(indice);
    }
    */
	
	@PostMapping("/registeruser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegister request, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
		}

		Role userRole = roleRepository.findByAutnRole("USER").get();
		Set<Role> authorities = new HashSet<>();
		authorities.add(userRole);
		
		User user = new User().builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.authorities(authorities)
				.isGoogle(false)
				.picture("https://www.svgrepo.com/show/525577/user-circle.svg")
				.build();
		
		Perfil perfil = new Perfil().builder()
				.perfilNombres(request.getPerfilNombres())
				.perfilPaterno(request.getPerfilPaterno())
				.perfilMaterno(request.getPerfilMaterno())
				.perfilDni(request.getPerfilDni())
				.perfilCelular(request.getPerfilCelular())
				.perfilRegisterDate(LocalDateTime.now())
				.usuario(user)
				.build();
		
		userService.insertarUsuario(user);
		perfilService.Insert(perfil);
		
		return ResponseEntity.ok(Collections.singletonMap("mensaje", "Registro de usuario exitoso."));
	}
	
	@PostMapping("/registergoogle")
	public ResponseEntity<?> registerUserGoogle(@Valid @RequestBody UserGoogleRegister request, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
		}

		Role userRole = roleRepository.findByAutnRole("USER").get();
		Set<Role> authorities = new HashSet<>();
		authorities.add(userRole);
		
		String password = UUID.randomUUID().toString();
		User user = new User()
				.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(password))
				.isGoogle(true)
				.authorities(authorities)
				.picture(request.getPicture())
				.build();
		
		
		Perfil perfil = new Perfil()
				.builder()
				.perfilNombres(request.getPerfilNombres())
				.perfilPaterno(request.getPerfilPaterno())
				.perfilMaterno(request.getPerfilMaterno())
				.perfilDni(request.getPerfilDni())
				.perfilCelular(request.getPerfilCelular())
				.perfilRegisterDate(LocalDateTime.now())
				.usuario(user)
				.build();
		
		userService.insertarUsuario(user);
		perfilService.Insert(perfil);
		
		return ResponseEntity.ok(Collections.singletonMap("mensaje", "Registro de usuario exitoso."));
	}
	
	

}






 
