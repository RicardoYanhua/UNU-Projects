package com.mycompany.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private Connection connection = null;

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/Luxcar";
    private final String USUARIO = "root";
    private final String CONTRASENIA = "123456";

    public DataBase() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Error DataBase.Constructor:\n " + e.getMessage());
        }
        Connection();

    }

    public void Connection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
            }
        } catch (SQLException e) {
            System.out.println("Error DataBase.Connection:\n " + e.getMessage());
        }
    }

    public Connection getConection() {
        return connection;
    }

    public boolean isConnecting() {
        if (connection == null) {
            return false;
        }
        try (Statement stmt = connection.createStatement()) {
            stmt.executeQuery("SELECT 1");
            return true;
        } catch (SQLException e) {
           System.out.println("Error DataBase.isConnecting:\n" + e.getMessage());
            return false;
        }
        
    }

    public void Disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error DataBase.Disconnect:\n" + e.getMessage());
        }
    }

    public void Reconnect() {
        
            Disconnect();
            Connection();
       

    }
}
