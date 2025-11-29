package com.unu.WebApplication.beans;

import java.time.*;
import java.util.*;

public class Trabajador {
	private int idTrabajador;
	private String dni;
	private LocalDate fecha;
	private String nombres;
	private int idArea;
	private String nAfp;
	private String codEsalud;
	private double sueldo;
	private int idProfesion;
	
	public Trabajador() {
		this(0,"",LocalDate.now(),"",0,"","",0.0,0);
	}

	

	public Trabajador(int idTrabajador, String dni, LocalDate fecha, String nombres, int idArea, String nAfp,
			String codEsalud, double sueldo, int idProfesion) {
		super();
		this.idTrabajador = idTrabajador;
		this.dni = dni;
		this.fecha = fecha;
		this.nombres = nombres;
		this.idArea = idArea;
		this.nAfp = nAfp;
		this.codEsalud = codEsalud;
		this.sueldo = sueldo;
		this.idProfesion = idProfesion;
	}



	public Object[] getObject(){
		return new Object[] {
			this.idTrabajador,
			this.dni,
			this.fecha,
			this.nombres,
			this.idArea,
			this.nAfp,
			this.codEsalud,
			this.sueldo,
			this.idProfesion
		};
	}



	public int getIdTrabajador() {
		return idTrabajador;
	}



	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public int getIdArea() {
		return idArea;
	}



	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}



	public String getnAfp() {
		return nAfp;
	}



	public void setnAfp(String nAfp) {
		this.nAfp = nAfp;
	}



	public String getCodEsalud() {
		return codEsalud;
	}



	public void setCodEsalud(String codEsalud) {
		this.codEsalud = codEsalud;
	}



	public double getSueldo() {
		return sueldo;
	}



	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}



	public int getIdProfesion() {
		return idProfesion;
	}



	public void setIdProfesion(int idProfesion) {
		this.idProfesion = idProfesion;
	}
	
}
	
	