package com.unu.WebApplication.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unu.WebApplication.beans.Area;
import com.unu.WebApplication.utils.Conexion;

public class AreaModel {

	Connection conexion = Conexion.getInstance().getConexion();
	PreparedStatement pst;
	ResultSet rs;
	
	public List<Object[]> listaArea(){
		
		try {
			
			String SQL = "SELECT * FROM area";
			List<Object[]> lista = new ArrayList<>();
			
			pst = conexion.prepareStatement(SQL);
			rs = pst.executeQuery();

			while(rs.next()) {
				lista.add(
						new Area(
								rs.getInt("idarea"),
								rs.getString("nombrearea")
								).getObject()
				);
			}
			return lista;
			
		} catch (Exception e) {
			System.out.println("Error en AreaModel.listaArea() \n" + e.getMessage().toString());
			return null;
		}finally {
			Conexion.getInstance().closeResources(pst, rs);
		}
	}

	public String getNameAreaById(int idArea) {
		try {
			String SQL = "SELECT nombrearea FROM area WHERE idarea = ?";
			String NombreArea = "";
			pst = conexion.prepareStatement(SQL);
			pst.setInt(1, idArea);
			rs = pst.executeQuery();
			if (rs.next()) {NombreArea =  rs.getString("nombrearea");}
			return NombreArea;
		} catch (SQLException e) {
			System.out.println("Error en AreaModel.getNameAreaById() \n" + e.getMessage().toString());
			return "";
		} finally {
			Conexion.getInstance().closeResources(pst, rs);
		}
	}

}
