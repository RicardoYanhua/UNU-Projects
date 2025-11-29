package com.unu.WebApplication.beans;

public class Profesion {
	
	private int idProfesion;
	private String nombreProfesion;

	public Profesion () {
		this(0,"");
	}

	public Profesion(int idProfesion, String nombreProfesion) {
		super();
		this.idProfesion = idProfesion;
		this.nombreProfesion = nombreProfesion;
	}
	
	public Object[] getObject () {
		return new Object[] {
				this.idProfesion,this.nombreProfesion
		};
	}

	public int getIdProfesion() {
		return idProfesion;
	}

	public void setIdProfesion(int idProfesion) {
		this.idProfesion = idProfesion;
	}

	public String getNombreProfesion() {
		return nombreProfesion;
	}

	public void setNombreProfesion(String nombreProfesion) {
		this.nombreProfesion = nombreProfesion;
	}
	
	
}
