package com.unu.poo2.models;

import com.unu.poo2.utils.Conexion;
import com.unu.poo2.beans.Entidad;
import java.sql.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StructureModel {
	
	Connection conexion = Conexion.getInstance().getConection();
	
	CallableStatement cst;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	
	DecimalFormat decimalFormat = new DecimalFormat("#.00");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// METODO PARA LISTAR UNA TABLA DE LA BD
	public List<Entidad> listar() {
		try {
			
			// METODO 1
			cst = conexion.prepareCall(""/*CALL sp_ProcedureName(?,?,?,...)*/);
			rs = cst.executeQuery();
			
			// METODO 2
			pst = conexion.prepareStatement(SQL_LISTAR);
			rs = pst.executeQuery();
			
			List<Entidad> lista = new ArrayList<>();
			
			while(rs.next()) {
				lista.add(new Entidad(
						rs.getInt("VarNameBD_typeInt"),
						rs.getInt("VarNameBD_typeInt"),
						rs.getString("VarNameBD_typeString"),
						rs.getDouble("VarNameBD_typeDouble"),
						rs.getDate("VarNameBD_typeDate").toLocalDate()
						));
			}
			return lista;
			
		} catch (SQLException e) {
			System.out.println("ERROR EN " + this.getClass().getName() + ".listar() \n" + e.getMessage().toString());
			return null;
		}finally {
			Conexion.getInstance().cerrarRecursos(cst,st,pst,rs);
		}
	}
	
	// METODO PARA OBETNER UN REGISTRO DE LA BD
	public Entidad obtener(int primaryKeyRecord) {
		try {
			// METODO 1
			cst = conexion.prepareCall(""/*CALL sp_ProcedureName(?,?,?,...)*/);
			cst.setInt(1, primaryKeyRecord);
			rs = cst.executeQuery();
						
			// METODO 2
			pst = conexion.prepareStatement(SQL_OBTENER_REGISTRO);
			pst.setInt(1, primaryKeyRecord);
			rs = pst.executeQuery();
			
			
			if(rs.next()) {
				// OBTENER REGISTRO
				return new Entidad(
						rs.getInt("VarNameBD_typeInt"),
						rs.getInt("VarNameBD_typeInt"),
						rs.getString("VarNameBD_typeString"),
						rs.getDouble("VarNameBD_typeDouble"),
						rs.getDate("VarNameBD_typeDate").toLocalDate()
						);
			}else {
				// RETORNAR VACIO
				return null;
			}
		} catch (SQLException e) {
			System.out.println("ERROR EN " + this.getClass().getName() + ".obtener() \n" + e.getMessage().toString());
			return null;
		}finally {
			Conexion.getInstance().cerrarRecursos(cst,st,pst,rs);
		}
	}

	// METODO PARA MODIFICAR UN REGISTRO DE LA BD
	public int modificar (Entidad ObjetoEditable) {
		try {
			int filasAfectadas = 0;
			
			// METODO 1
			cst = conexion.prepareCall(""/*CALL sp_ProcedureName(?,?,?,...)*/);
			cst.setInt(1, ObjetoEditable.getVariableTipoInt());
			cst.setString(2, ObjetoEditable.getVariableTipoString());
			cst.setDouble(3, ObjetoEditable.getVariableTipoDouble());
			cst.setDate(4, Date.valueOf(ObjetoEditable.getVariableTipoDate()));
			// ...
			filasAfectadas = cst.executeUpdate();
			
			// METODO 2
			pst = conexion.prepareStatement(SQL_MODIFICAR/*INSERTAR LLAMADA EN SQL*/);
			pst.setInt(1, ObjetoEditable.getVariableTipoInt());
			pst.setString(2, ObjetoEditable.getVariableTipoString());
			pst.setDouble(3, ObjetoEditable.getVariableTipoDouble());
			pst.setDate(4, Date.valueOf(ObjetoEditable.getVariableTipoDate()));
			// ...
			filasAfectadas = pst.executeUpdate();
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("ERROR EN " + this.getClass().getName() + ".modificar() \n" + e.getMessage().toString());
			return 0;
		}finally {
			Conexion.getInstance().cerrarRecursos(cst,st,pst,rs);
		}
	}
	
	// METODO PARA INSERTAR UN NUEVO REGISTRO
	public int insertar (Entidad ObjetoNuevo) {
		try {
			int filasAfectadas = 0;
			// METODO 1
			cst = conexion.prepareCall(""/*CALL sp_ProcedureName(?,?,?,...)*/);
			cst.setInt(1, ObjetoNuevo.getVariableTipoInt());
			cst.setString(2, ObjetoNuevo.getVariableTipoString());
			cst.setDouble(3, ObjetoNuevo.getVariableTipoDouble());
			cst.setDate(4, Date.valueOf(ObjetoNuevo.getVariableTipoDate()));
			// ...
			filasAfectadas = cst.executeUpdate();
						
						
			// METODO 2
			pst = conexion.prepareStatement(SQL_INSERTAR/*INSERTAR LLAMADA EN SQL*/);
			pst.setInt(1, ObjetoNuevo.getVariableTipoInt());
			pst.setString(2, ObjetoNuevo.getVariableTipoString());
			pst.setDouble(3, ObjetoNuevo.getVariableTipoDouble());
			pst.setDate(4, Date.valueOf(ObjetoNuevo.getVariableTipoDate()));
			// ...
			filasAfectadas = pst.executeUpdate();
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("ERROR EN " + this.getClass().getName() + ".insertar() \n" + e.getMessage().toString());
			return 0;
		}finally {
			Conexion.getInstance().cerrarRecursos(cst,st,pst,rs);
		}
	}
	
	// METODO PARA ELIMNAR UN REGISTRO
	public int eliminar (int primaryKeyRecord) {
		try {
			int filasAfectadas = 0;
			
			// METODO 1 
			cst = conexion.prepareCall(""/*CALL sp_ProcedureName(?,?,?,...)*/);
			cst.setInt(1, primaryKeyRecord);
			// ... other conditions
			filasAfectadas = cst.executeUpdate();
			
			// METODO 2
			pst = conexion.prepareStatement(SQL_ELIMINAR/*INSERTAR LLAMADA EN SQL*/);
			pst.setInt(1, primaryKeyRecord);
			// ... other conditions
			filasAfectadas = pst.executeUpdate();
			
			return filasAfectadas;
			
		} catch (SQLException e) {
			System.out.println("ERROR EN " + this.getClass().getName() + ".eliminar() \n" + e.getMessage().toString());
			return 0;
		}finally {
			Conexion.getInstance().cerrarRecursos(cst,st,pst,rs);
		}
	}

	// METODO PARA BUSCAR
	public List<Entidad> buscar(String SearchCondition){
		try {
			
			// METODO 1
			cst = conexion.prepareCall(""/*CALL sp_ProcedureName(?,?,?,...)*/);
			cst.setString(1, /*'%' + */SearchCondition/* + '%'*/);
			// ... other conditions
			rs = cst.executeQuery();
			
			// METODO 2
			pst = conexion.prepareStatement(SQL_BUSCAR/*INSERTAR LLAMADA EN SQL*/);
			pst.setString(1, /*'%' + */SearchCondition/* + '%'*/);
			// ... other conditions
			rs = pst.executeQuery();
			
			// LISTA DEL REGISTRO DE BUSQUEDA DE LA BD
			List<Entidad> lista = new ArrayList<>();
			
			while(rs.next()) {
				
				// OBTENER Y GUARADAR REGISTRO BD
				lista.add(new Entidad(
						rs.getInt(""),
						rs.getInt(""),
						rs.getString(""),
						rs.getDouble(""),
						rs.getDate("").toLocalDate()
						));
			}
			return lista;
			
		} catch (SQLException e) {
			System.out.println("ERROR EN " + this.getClass().getName() + ".buscar() \n" + e.getMessage().toString());
			return null;
		}finally {
			Conexion.getInstance().cerrarRecursos(cst,st,pst,rs);
		}
	}
	
	// METODO PARA LISTAR UNA TABLA DE LA BD
	public List<Object[]> listCustom() {
		try {
				
			// METODO 1
			cst = conexion.prepareCall(""/*CALL sp_ProcedureName(?,?,?,...)*/);
			rs = cst.executeQuery();
				
			// METODO 2
			pst = conexion.prepareStatement(SQL_LISTAR_CUSTOM/*INSERTAR LLAMADA EN SQL*/);
			rs = pst.executeQuery();
				
			// LISTA DEL REGISTRO COMPLETO DE LA BD
			List<Object[]> listaCustom = new ArrayList<>();
				
			while(rs.next()) {
					
				// OBTENER Y GUARADAR REGISTRO BD
				listaCustom.add(new Object[] {
						rs.getInt("VarNameBD_ofCustom_typeInt"),
						rs.getInt("VarNameBD_ofCustom_typeInt"),
						rs.getString("VarNameBD_ofCustom_typeString"),
						rs.getDouble("VarNameBD_ofCustom_typeDouble"),
						rs.getDate("VarNameBD_ofCustom_typeDate").toLocalDate()
						/*...*/
				});
			}
			return listaCustom;
	
		} catch (SQLException e) {
			System.out.println("ERROR EN " + this.getClass().getName() + ".listCustom() \n" + e.getMessage().toString());
			return null;
		}finally {
			Conexion.getInstance().cerrarRecursos(cst,st,pst,rs);
		}
	}
	
	// METODO PARA CONTAR REGISTROS TOTALES
	public int contarRegistrosTotal() {
		try {
				
			// METODO 1
			cst = conexion.prepareCall(""/*CALL sp_ProcedureName(?,?,?,...)*/);
			rs = cst.executeQuery();
				
			// METODO 2
			pst = conexion.prepareStatement(SQL_COUNT_RECORD/*INSERTAR LLAMADA EN SQL*/);
			rs = pst.executeQuery();
				
			if(rs.next()) {
				return rs.getInt("total"); // NOMBRE DEFINIDO POR EL 'AS'
			}else {
				return 0;
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR EN " + this.getClass().getName() + ".contarRegistrosTotal() \n" + e.getMessage().toString());
			return 0;
		}finally {
			Conexion.getInstance().cerrarRecursos(cst,st,pst,rs);
		}
	}
	
	
	String SQL_TABLA = "";
	String SQL_PRIMARY_KEY = "";
	
	String SQL_COUNT_RECORD = "SELECT COUNT(*) AS total FROM " + SQL_TABLA;
	String SQL_LISTAR = "SELECT * FROM " + SQL_TABLA;
	String SQL_LISTAR_CUSTOM = "SELECT var1_custom,var2_custom,var3_custom,... FROM " + SQL_TABLA;
	String SQL_OBTENER_REGISTRO = "SELECT * FROM " + SQL_TABLA + " WHERE " + SQL_PRIMARY_KEY + " = ?" ;
	String SQL_ELIMINAR = "DELETE FROM " + SQL_TABLA + " WHERE " + SQL_PRIMARY_KEY + " = ?";
	String SQL_INSERTAR = "INSERT INTO " + SQL_TABLA + " ("
			+ "var,"
			+ "var,"
			+ "var,"
			+ "var"
			+ ") VALUES (?,?,?,...)";
	String SQL_MODIFICAR = "UPDATE " + SQL_TABLA + " SET "
			+ " var = ? ,"
			+ " var = ? ,"
			+ " var = ? ,"
			+ " var = ? ,"
			+ " var = ?  "
			+ " WHERE " + SQL_PRIMARY_KEY + " = ?";
	String SQL_SEARCH_CONDITION = "";
	String SQL_BUSCAR = "SELECT * FROM " + SQL_TABLA + " WHERE " + SQL_SEARCH_CONDITION +" like ?";
	/*
	 * ORDER BY column_name ASC;
	 * 
	 * Elimina los valores duplicados de los resultados de una consulta.
	 * SELECT DISTINCT column_name
	 * FROM table_name;
	 * 
	 * Restringe el número de filas devueltas por la consulta.
	 * SELECT * FROM table_name LIMIT 10;
	 * 
	 * SELECT empleados.nombre, departamentos.departamento
	 * FROM empleados
	 * INNER JOIN departamentos
	 * ON empleados.id_departamento = departamentos.id_departamento;
	 * 
	 * 
	 */
	

}


