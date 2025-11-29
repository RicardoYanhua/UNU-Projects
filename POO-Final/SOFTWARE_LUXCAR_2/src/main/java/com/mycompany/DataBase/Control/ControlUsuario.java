/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DataBase.Control;

import com.mycompany.DataBase.Control.UsuarioClass;
import com.mycompany.DataBase.DataBase;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class ControlUsuario {

    private DataBase Data;
    private DefaultTableModel Tabla;

    public ControlUsuario() {
        Data = new DataBase();
    }

    public ControlUsuario(DefaultTableModel TablaModel) {
        this();
        Tabla = TablaModel;
    }

    public boolean isConnecting() {
        return Data.isConnecting();
    }

    public void Reconnecting() {
        Data.Reconnect();
    }

    public void Disconneting() {
        Data.Disconnect();
    }

    public void LimpiarTabla() {
        for (int i = Tabla.getRowCount() - 1; i >= 0; i--) {
            Tabla.removeRow(i);
        }
    }

    public int getTotalUsuarios() {
        int Count = 0;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(*) AS total FROM usuario "
                    + "WHERE Contraseña != ''";
            st = Data.getConection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Count = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.getTotalUsuarios:\n " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (st != null && !st.isClosed()) {
                    st.close();
                    st = null;
                }

            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.getTotalUsuarios (finally block):\n " + e.getMessage());
            }
        }
        return Count;
    }

    public int getTotalUsuariosTrabajadores() {
        int Count = 0;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(*) AS total "
                    + "FROM trabajador t "
                    + "JOIN usuario u ON t.DNI = u.DNI "
                    + "WHERE u.Contraseña IS NOT NULL AND u.Contraseña <> '' ";
            st = Data.getConection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Count = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.getTotalUsuarios:\n " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (st != null && !st.isClosed()) {
                    st.close();
                    st = null;
                }

            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.getTotalUsuarios (finally block):\n " + e.getMessage());
            }
        }
        return Count;
    }

    public int getTotalUsuariosTrabajadoresSinUsuario() {
        int Count = 0;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(*) AS total "
                    + "FROM trabajador t "
                    + "LEFT JOIN usuario u ON t.DNI = u.DNI "
                    + "WHERE u.Contraseña IS NULL OR u.Contraseña = ''";
            st = Data.getConection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Count = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.getTotalUsuarios:\n " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (st != null && !st.isClosed()) {
                    st.close();
                    st = null;
                }

            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.getTotalUsuarios (finally block):\n " + e.getMessage());
            }
        }
        return Count;
    }

    public boolean isUserAdmindAccess(String DNI) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select AdminPermision from usuario where DNI =? ";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, DNI);
            rs = pst.executeQuery();

            if (rs.next()) {
                if (rs.getBoolean(1)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.isUserAdmindAccess:\n " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                    pst = null;
                }

            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.isUserAdmindAccess (finally block):\n " + e.getMessage());
            }
        }
        return false;
    }

    public TrabajadorClass getUserTrabajador(String DNI) {
        TrabajadorClass Trabajador = null;
        ControlTrabajador dataTrabajador = new ControlTrabajador();
        if (dataTrabajador.isExistTrabajador(DNI)) {
            Trabajador = dataTrabajador.getTrabajadorEspecifico(DNI);
            dataTrabajador.Disconneting();
        }
        return Trabajador;
    }

    public boolean IsExistUsuario(String DNI, String Contraseña) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select DNI from usuario where DNI =? and Contraseña =?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, DNI);
            pst.setString(2, Contraseña);
            rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.IsExistUsuario:\n " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                    pst = null;
                }

            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.IsExistUsuario (finally block):\n " + e.getMessage());
            }
        }
        return false;
    }

    public UsuarioClass getUsuario(String DNI) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        UsuarioClass usuario = null;
        try {
            String sql = "select * from usuario where DNI =? ";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, DNI);
            rs = pst.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioClass(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
            return usuario;

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.IsExistUsuario:\n " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                    pst = null;
                }

            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.IsExistUsuario (finally block):\n " + e.getMessage());
            }
        }
        return usuario;
    }

    public void MostrarBusquedaDeUsuarioTrabajador(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        LimpiarTabla();
        try {
            String sql = "SELECT t.DNI, t.Nombres, t.Apellidos, u.AdminPermision "
                    + "FROM trabajador t "
                    + "JOIN usuario u ON t.DNI = u.DNI AND u.Contraseña IS NOT NULL AND u.Contraseña <> '' "
                    + "WHERE t.DNI LIKE ? OR t.Nombres LIKE ? OR t.Apellidos LIKE ?";

            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Busqueda + "%");
            pst.setString(2, Busqueda + "%");
            pst.setString(3, Busqueda + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                String ROL = "";
                if (rs.getBoolean(4)) {
                    ROL = "T.Administrador";
                } else {
                    ROL = "Trabajador";
                }
                Object Row[] = new Object[]{
                    rs.getString(1),
                    rs.getString(2) + ", " + rs.getString(3),
                    ROL
                };
                Tabla.addRow(Row);
            }

        } catch (Exception e) {
            System.out.println("Error ControlUsuario.MostrarTablaUsuarioStatic:\n " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                    pst = null;
                }

            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.MostrarTablaUsuarioStatic (finally block):\n " + e.getMessage());
            }
        }
    }

    public void MostrarBusquedaDeTrabajadorSinUsuario(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        LimpiarTabla();
        try {
            String sql = "SELECT t.DNI, t.Nombres, t.Apellidos "
                    + "FROM trabajador t "
                    + "LEFT JOIN usuario u ON t.DNI = u.DNI "
                    + "WHERE (u.Contraseña IS NULL OR u.Contraseña = '') "
                    + "AND t.DNI LIKE ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Busqueda + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                Object Row[] = new Object[]{
                    rs.getString("DNI"), // DNI
                    rs.getString(2) + ", " + rs.getString(3),
                    "Trabajador"
                };
                Tabla.addRow(Row);
            }
        } catch (Exception e) {
            System.out.println("Error ControlUsuario.MostrarBusquedaDeUsuarioNoTrabajador:\n " + e.getMessage());
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                    pst = null;
                }

            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.MostrarBusquedaDeUsuarioNoTrabajador (finally block):\n " + e.getMessage());
            }
        }
    }

    public void InsertarUsuario(UsuarioClass Usuario) {
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO Usuario (DNI, Contraseña, AdminPermision)"
                    + "VALUES (?,?,?);";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Usuario.getDNI());
            pst.setString(2, Usuario.getContraseña());
            pst.setBoolean(3, Usuario.isAdminPermision());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.InsertarUsuario:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                    pst = null;
                }
            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.InsertarUsuario (finally block):\n " + e.getMessage());
            }
        }
    }

    public void ModificarUsuario(UsuarioClass Usuario) {
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE Usuario "
                    + "SET Contraseña = ? , AdminPermision = ? "
                    + "WHERE DNI = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Usuario.getContraseña());
            pst.setBoolean(2, Usuario.isAdminPermision());
            pst.setString(3, Usuario.getDNI());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.ModificarUsuario:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                    pst = null;
                }
            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.ModificarUsuario (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarUsuario(String DNI) {
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM Usuario WHERE DNI = ? ";

            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, DNI);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ControlUsuario.EliminarUsuario:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                    pst = null;
                }
            } catch (SQLException e) {
                System.out.println("Error ControlUsuario.EliminarUsuario (finally block):\n " + e.getMessage());
            }
        }
    }

}
