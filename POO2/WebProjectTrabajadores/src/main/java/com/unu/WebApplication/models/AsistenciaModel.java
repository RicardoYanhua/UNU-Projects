package com.unu.WebApplication.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.unu.WebApplication.beans.*;
import com.unu.WebApplication.utils.Conexion;

public class AsistenciaModel {
	
	PreparedStatement pst ;
	Connection conexion = Conexion.getInstance().getConexion();
	
public int registrarAsistencia(Asistencia nuevoAsistencia){
		
		try {
			String SQL = "INSERT INTO asistencia ("
					+ "idasistencia,"
					+ "idtrabajador,"
					+ "condicion,"
					+ "fecha,"
					+ "justificacion"
					+ ") VALUES (0,?,?,?,?)";
			int FilasAfectadas =0;
			pst = conexion.prepareStatement(SQL);
			
			pst.setInt(1,nuevoAsistencia.getIdTrabajador());
			pst.setString(2,nuevoAsistencia.getCondicion());
			pst.setDate(3,Date.valueOf(nuevoAsistencia.getFecha()));
			pst.setString(4,nuevoAsistencia.getJustificacion());
			
			FilasAfectadas = pst.executeUpdate();
			return FilasAfectadas;
			
		} catch (Exception e) {
			System.out.println("Error en AsistenciaModel.registrarTrabajador() \n" + e.getMessage().toString());
			return 0;
		}finally {
			Conexion.getInstance().closeResources(pst);
		}
	}

}
