package com.unu.poo2.utils;
import java.sql.*;

public class Conexion {
	
	//BD CONNECTION
	public Connection conexion;
	
	// BD ATRIBUTOS
	private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String DATABASE_NAME = "";
	private String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
	private String USER = "root";
	private String PASSWORD = "123456";// 
	
	// BD METODOS SINGLETON
	public static Conexion instance;
	
	public static Conexion getInstance() {
		
		if(instance == null) {
			instance = new Conexion();
		}
		return instance;
	}
	
	// ABRIR CONEXION BD
	public Conexion () {
		try {
			Class.forName(DRIVER);
			conexion = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
			System.err.println(conexion != null ? "Conexion Exitosa" : "ConexionFallida");
		} catch (Exception e) {
			System.out.println("ERROR EN " + this.getClass().getName()+".Conexion.Constructor() \n" + e.getMessage().toString());
		}
	}
	
	// OBTENER CONEXION BD
	public Connection getConection() {
		return conexion;
	}
	
	// CERRAR CONEXION BD
	public void desconectar() {
		try {
			if(conexion != null && !conexion.isClosed()) {
				cerrarRecursos(conexion);
			}
		} catch (Exception e) {
			System.out.println("ERROR EN " + this.getClass().getName()+ ".desconectar() \n" + e.getMessage().toString());
		}
	}
	
	// CERRAR RECURSOS RS, CST, PST, PCS, etc...
	public void cerrarRecursos(AutoCloseable...autoCloseables) {
		try {
			for	(AutoCloseable recurso : autoCloseables) {
				if(recurso != null){
					recurso.close();
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR EN " + this.getClass().getName()+ ".cerrarRecursos() \n" + e.getMessage().toString());
		}
	}

}
