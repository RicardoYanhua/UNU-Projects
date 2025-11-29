/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.BaseDeDatos;

import java.sql.*;

/**
 *
 * @author ricar
 */
public class Conexion {

    public String DRIVER = "com.mysql.cj.jdbc.Driver";
    public String URL = "jdbc:mysql://localhost/prueba";
    private String USER = "root";
    private String PASS = "";
    public static Connection con;

    public Conexion() {
        try {
            Class.forName(DRIVER);
            con = (Connection) DriverManager.getConnection(URL, USER, PASS);
            if (con != null) {
                System.out.println("ConexionExitosa");
            }
        } catch (Exception e) {
            System.out.println("Error : \n" + e.getMessage().toString());
        }
    }

    public Connection getConection() {
        return con;
    }

}
