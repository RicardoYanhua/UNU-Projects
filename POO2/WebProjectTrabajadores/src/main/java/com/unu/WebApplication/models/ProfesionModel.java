package com.unu.WebApplication.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unu.WebApplication.beans.Profesion;
import com.unu.WebApplication.utils.Conexion;

public class ProfesionModel {


	Connection conexion = Conexion.getInstance().getConexion();
	PreparedStatement pst;
	ResultSet rs;
	
	public List<Object[]> listaProfesion(){
		
		try {
			
			String SQL = "SELECT * FROM profesion";
			List<Object[]> lista = new ArrayList<>();
			
			pst = conexion.prepareStatement(SQL);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				lista.add(
						new Profesion(
								rs.getInt("idprofesion"),
								rs.getString("nombreprofesion")
								).getObject()
				);
			}
			return lista;
			
		} catch (Exception e) {
			System.out.println("Error en ProfesionModel.listaProfesion() \n" + e.getMessage().toString());
			return null;
		}finally {
			Conexion.getInstance().closeResources(pst, rs);
		}
	}

	public String getNameProfesionById(int idProfesion) {
		try {
			String SQL = "SELECT nombreprofesion FROM profesion WHERE idprofesion = ?";
			String NombreProfesion = "";
			pst = conexion.prepareStatement(SQL);
			pst.setInt(1, idProfesion);
			rs = pst.executeQuery();
			if (rs.next()) {NombreProfesion =  rs.getString("nombreprofesion");}
			return NombreProfesion;
		} catch (SQLException e) {
			System.out.println("Error en ProfesionModel.getNameProfesionById() \n" + e.getMessage().toString());
			return "";
		} finally {
			Conexion.getInstance().closeResources(pst, rs);
		}
	}

}
