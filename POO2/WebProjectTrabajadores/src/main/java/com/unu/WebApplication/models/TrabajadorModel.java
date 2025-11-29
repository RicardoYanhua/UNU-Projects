package com.unu.WebApplication.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.WebApplication.beans.Trabajador;
import com.unu.WebApplication.utils.Conexion;

public class TrabajadorModel {
	
	Connection conexion = Conexion.getInstance().getConexion();
	
	PreparedStatement pst ;
	ResultSet rs ;
	
	public List<Object[]> listarTrabajador(){
		
		try {
			
			String SQL = "SELECT idtrabajador,nombres,idarea,sueldo FROM trabajador";
			List<Object[]> lista = new ArrayList<>();
			
			pst = conexion.prepareStatement(SQL);
			rs = pst.executeQuery();
			
			AreaModel modelArea = new AreaModel();
			
			while(rs.next()) {
				lista.add(new Object[] {
						rs.getInt("idtrabajador"),
						rs.getString("nombres"),
						modelArea.getNameAreaById(rs.getInt("idarea")),
						rs.getDouble("sueldo")
				});
			}
			return lista;
			
		} catch (Exception e) {
			System.out.println("Error en TrabajadorModel.listarTrabajador() \n" + e.getMessage().toString());
			return null;
		}finally {
			Conexion.getInstance().closeResources(pst, rs);
		}
	}
	
	public Trabajador obtenerTrabajador(int idTrabajador){
		
		try {
			
			String SQL = "SELECT * FROM trabajador WHERE idtrabajador = ?";
			
			
			pst = conexion.prepareStatement(SQL);
			pst.setInt(1, idTrabajador);
			rs = pst.executeQuery();
			Trabajador trabajador = new Trabajador();
			if(rs.next()) {
				trabajador.setIdTrabajador(rs.getInt("idtrabajador"));
				trabajador.setDni(rs.getString("dni"));
				trabajador.setFecha(rs.getDate("fecha").toLocalDate());
				trabajador.setNombres(rs.getString("nombres"));
				trabajador.setIdArea(rs.getInt("idarea"));
				trabajador.setnAfp(rs.getString("n_afp"));
				trabajador.setCodEsalud(rs.getString("cod_esalud"));
				trabajador.setSueldo(rs.getDouble("sueldo"));
				trabajador.setIdProfesion(rs.getInt("idprofesion"));	
			}
			return trabajador;
			
		} catch (Exception e) {
			System.out.println("Error en TrabajadorModel.obtenerTrabajador() \n" + e.getMessage().toString());
			return null;
		}finally {
			Conexion.getInstance().closeResources(pst, rs);
		}
	}
	
	public int registrarTrabajador(Trabajador NuevoTrabajador){
		
		try {
			String SQL = "INSERT INTO trabajador ("
					+ "idtrabajador,"
					+ "dni,"
					+ "fecha,"
					+ "nombres,"
					+ "idarea,"
					+ "n_afp,"
					+ "cod_esalud,"
					+ "sueldo,"
					+ "idprofesion"
					+ ") VALUES (0,?,?,?,?,?,?,?,?)";
			int FilasAfectadas =0;
			pst = conexion.prepareStatement(SQL);
			
			pst.setString(1,NuevoTrabajador.getDni());
			pst.setDate(2,Date.valueOf(NuevoTrabajador.getFecha()));
			pst.setString(3,NuevoTrabajador.getNombres());
			pst.setInt(4,NuevoTrabajador.getIdArea());
			pst.setString(5,NuevoTrabajador.getnAfp());
			pst.setString(6,NuevoTrabajador.getCodEsalud());
			pst.setDouble(7,NuevoTrabajador.getSueldo());
			pst.setInt(8,NuevoTrabajador.getIdProfesion());
			
			FilasAfectadas = pst.executeUpdate();
			return FilasAfectadas;
			
		} catch (Exception e) {
			System.out.println("Error en TrabajadorModel.registrarTrabajador() \n" + e.getMessage().toString());
			return 0;
		}finally {
			Conexion.getInstance().closeResources(pst, rs);
		}
	}
	
public int modificarTrabajador(Trabajador modificarTrabajador){
		
		try {
			String SQL = "UPDATE trabajador SET "
					+ "dni = ?,"
					+ "fecha = ?,"
					+ "nombres = ?,"
					+ "idarea = ?,"
					+ "n_afp = ?,"
					+ "cod_esalud = ?,"
					+ "sueldo = ?,"
					+ "idprofesion = ? "
					+ "WHERE idtrabajador = ?";
			
			int FilasAfectadas =0;
			pst = conexion.prepareStatement(SQL);
			
			pst.setString(1,modificarTrabajador.getDni());
			pst.setDate(2,Date.valueOf(modificarTrabajador.getFecha()));
			pst.setString(3,modificarTrabajador.getNombres());
			pst.setInt(4,modificarTrabajador.getIdArea());
			pst.setString(5,modificarTrabajador.getnAfp());
			pst.setString(6,modificarTrabajador.getCodEsalud());
			pst.setDouble(7,modificarTrabajador.getSueldo());
			pst.setInt(8,modificarTrabajador.getIdProfesion());
			pst.setInt(9,modificarTrabajador.getIdTrabajador());
			
			FilasAfectadas = pst.executeUpdate();
			return FilasAfectadas;
			
		} catch (Exception e) {
			System.out.println("Error en TrabajadorModel.modificarTrabajador() \n" + e.getMessage().toString());
			return 0;
		}finally {
			Conexion.getInstance().closeResources(pst, rs);
		}
	}
public int eliminarTrabajador(int trabajadorEliminar){
	
	try {
		String SQL = "DELETE FROM trabajador "
				+ "WHERE idtrabajador = ?";
		
		int FilasAfectadas =0;
		pst = conexion.prepareStatement(SQL);
		pst.setInt(1, trabajadorEliminar);
		FilasAfectadas = pst.executeUpdate();
		return FilasAfectadas;
		
	} catch (Exception e) {
		System.out.println("Error en TrabajadorModel.eliminarTrabajador() \n" + e.getMessage().toString());
		return 0;
	}finally {
		Conexion.getInstance().closeResources(pst, rs);
	}
}

}
