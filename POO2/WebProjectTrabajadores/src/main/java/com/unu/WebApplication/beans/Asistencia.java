package com.unu.WebApplication.beans;

import java.time.LocalDate;

public class Asistencia {
	
	private int idAsistencia;
	private int idTrabajador;
	private String condicion;
	private LocalDate fecha;
	private String justificacion;
	
	public Asistencia() {
		this(0,0,"",LocalDate.now(),"");
	}
	
	public Asistencia(int idAsistencia, int idTrabajador, String condicion, LocalDate fecha, String justificacion) {
		super();
		this.idAsistencia = idAsistencia;
		this.idTrabajador = idTrabajador;
		this.condicion = condicion;
		this.fecha = fecha;
		this.justificacion = justificacion;
	}
	public int getIdAsistencia() {
		return idAsistencia;
	}
	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	public int getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	
	

}
