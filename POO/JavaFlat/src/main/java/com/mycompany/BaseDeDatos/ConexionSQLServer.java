/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USUARIO
 */
public class ConexionSQLServer {

    private static Connection con = null;
    private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=Categoria;encrypt=true;trustServerCertificate=true";

    private final String user = "sa";
    private final String pass = "123";
    public ConexionSQLServer() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            if (con != null) {
                System.out.println("Conexion okkkkkk");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return con;
    }
}
