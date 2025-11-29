package com.example.demo.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "idusuario")
		private int idusuario;
		
		@Column(name = "username")
		private String username;
		
		@Column(name = "password")
		private String password;
		
		public Usuario(int idusuario, String username, String password) {
			super();
			this.idusuario = idusuario;
			this.username = username;
			this.password = password;
		}

		public Usuario() {
			this(0,"","");
		}

		public int getIdusuario() {
			return idusuario;
		}

		public void setIdusuario(int idusuario) {
			this.idusuario = idusuario;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		
		
		
		
		
}
