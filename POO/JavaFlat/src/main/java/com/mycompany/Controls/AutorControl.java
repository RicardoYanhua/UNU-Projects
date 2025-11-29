/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controls;

import com.mycompany.BaseDeDatos.Conexion;
import com.mycompany.Class.Autor;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class AutorControl {

    private Connection con = new Conexion().getConection();
    private final String SQL_MOSTRAR_AUTORES = "select * from autores";
    private final String SQL_BUSQUEDA_AUTORES = "select * from autores where AutorID like ?";
    private final String SQL_OBTENER_AUTOR = "select * from autores where AutorID = ?";
    private final String SQL_INSERTAR_AUTOR = "insert into autores() values()";
    private DefaultTableModel TABLA;

    public AutorControl(DefaultTableModel model) {
        this.TABLA = model;
    }

    public void LimpiarTabla() {
        for (int i = this.TABLA.getRowCount() - 1; i >= 0; i--) {
            TABLA.removeRow(i);
        }
    }

    public void MostrarAutores() {
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(SQL_MOSTRAR_AUTORES);

            LimpiarTabla();
            while (rs.next()) {
                String codigo = String.valueOf(rs.getInt(1));
                TABLA.addRow(new Autor(codigo, rs.getString(2), rs.getString(3)).toRow());
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error MostrarAutores : \n" + e.getMessage().toString());
        }
    }

    public void MostrarBusquedaAutor(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = con.prepareStatement(SQL_BUSQUEDA_AUTORES);
            pst.setString(1, '%' + Busqueda + '%');
            rs = pst.executeQuery();

            LimpiarTabla();
            while (rs.next()) {
                String codigo = String.valueOf(rs.getInt(1));
                TABLA.addRow(new Autor(codigo, rs.getString(2), rs.getString(3)).toRow());
            }
            rs.close();
            pst.close();

        } catch (Exception e) {
            System.out.println("Error MostrarAutores : \n" + e.getMessage().toString());
        }
    }

}
