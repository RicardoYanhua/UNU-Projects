package com.unu.poo2.beans;

import java.time.LocalDate;

public class Entidad {
	
	private int VariablePrimaryKey;
	private int VariableTipoInt;
	private String VariableTipoString;
	private double VariableTipoDouble;
	private LocalDate VariableTipoDate;
	
	public Entidad() {
		this(0,0,"TestString",0.0,LocalDate.now());
	}
	
	public Entidad(int variablePrimaryKey,int variableTipoInt, String variableTipoString, double variableTipoDouble,
			LocalDate variableTipoDate) {
		super();
		VariablePrimaryKey = variablePrimaryKey;
		VariableTipoInt = variableTipoInt;
		VariableTipoString = variableTipoString;
		VariableTipoDouble = variableTipoDouble;
		VariableTipoDate = variableTipoDate;
	}

	// METODO PARA CONFIGURAR LA LISTA DE DATOS O VARIABLES DE LA ENTIDAD
	public Object[] get_CustomData(){
		return new Object[] {
				this.VariablePrimaryKey,
				this.VariableTipoInt,
				this.VariableTipoString,
				this.VariableTipoDouble,
				this.VariableTipoDate
		};
	}
	
	
	public int getVariablePrimaryKey() {
		return VariablePrimaryKey;
	}

	public void setVariablePrimaryKey(int variablePrimaryKey) {
		VariablePrimaryKey = variablePrimaryKey;
	}

	public int getVariableTipoInt() {
		return VariableTipoInt;
	}
	public void setVariableTipoInt(int variableTipoInt) {
		VariableTipoInt = variableTipoInt;
	}
	public String getVariableTipoString() {
		return VariableTipoString;
	}
	public void setVariableTipoString(String variableTipoString) {
		VariableTipoString = variableTipoString;
	}
	public double getVariableTipoDouble() {
		return VariableTipoDouble;
	}
	public void setVariableTipoDouble(double variableTipoDouble) {
		VariableTipoDouble = variableTipoDouble;
	}
	public LocalDate getVariableTipoDate() {
		return VariableTipoDate;
	}
	public void setVariableTipoDate(LocalDate variableTipoDate) {
		VariableTipoDate = variableTipoDate;
	}
	
	
	

}
