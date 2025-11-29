package com.unu.WebApplication.beans;

public class Area {
	
	private int idArea;
	private String nombreArea;
	
	public Area () {
		this(0,"");
	}
	public Area(int idArea, String nombreArea) {
		super();
		this.idArea = idArea;
		this.nombreArea = nombreArea;
	}
	
	public Object[] getObject () {
		return new Object[] {
				this.idArea,this.nombreArea
		};
	}
	public int getIdArea() {
		return idArea;
	}
	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
	public String getNombreArea() {
		return nombreArea;
	}
	public void setNombreArea(String nombreArea) {
		nombreArea = nombreArea;
	}
	
	

}
