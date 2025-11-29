package com.unu.web.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "administrador")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admCodigo", nullable = false)
	private Integer admCodigo;

	@NotBlank(message = "El nombre de usuario no puede estar vacío")
	@Size(max = 50, message = "El nombre de usuario no debe exceder 50 caracteres")
	@Column(name = "admNombreUsuario", nullable = false, unique = true, length = 50)
	private String admNombreUsuario;

	@Size(min = 8, max = 255, message = "La contraseña debe tener entre 8 y 255 caracteres")
	@Column(name = "admContrasenia", nullable = false, length = 255)
	private String admContrasenia;

	@NotBlank(message = "El nombre completo no puede estar vacío")
	@Size(max = 100, message = "El nombre completo no debe exceder 100 caracteres")
	@Column(name = "admNombreCompleto", length = 100)
	private String admNombreCompleto;

	@Column(name = "admState", nullable = false)
	private boolean admState;

	public Administrador() {
		this.admCodigo = 0;
		this.admNombreUsuario = "";
		this.admContrasenia = "";
		this.admNombreCompleto = "";
	}

	public Administrador(Integer admCodigo, String admNombreUsuario, String admContrasenia, String admNombreCompleto,
			Boolean admActivo) {
		super();
		this.admCodigo = admCodigo;
		this.admNombreUsuario = admNombreUsuario;
		this.admContrasenia = admContrasenia;
		this.admNombreCompleto = admNombreCompleto;
	}

	public Integer getAdmCodigo() {
		return admCodigo;
	}

	public void setAdmCodigo(Integer admCodigo) {
		this.admCodigo = admCodigo;
	}

	public String getAdmNombreUsuario() {
		return admNombreUsuario;
	}

	public void setAdmNombreUsuario(String admNombreUsuario) {
		this.admNombreUsuario = admNombreUsuario;
	}

	public String getAdmContrasenia() {
		return admContrasenia;
	}

	public void setAdmContrasenia(String admContrasenia) {
		this.admContrasenia = admContrasenia;
	}

	public String getAdmNombreCompleto() {
		return admNombreCompleto;
	}

	public void setAdmNombreCompleto(String admNombreCompleto) {
		this.admNombreCompleto = admNombreCompleto;
	}

	public boolean isAdmState() {
		return admState;
	}

	public void setAdmState(boolean admState) {
		this.admState = admState;
	}


}