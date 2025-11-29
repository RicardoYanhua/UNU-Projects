package com.mycompany.DataBase.Control;

import com.mycompany.DataBase.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class ControlActividad {

    private DataBase Data;
    private DefaultTableModel Tabla;

    public ControlActividad() {
        Data = new DataBase();
    }

    public ControlActividad(DefaultTableModel Tabla) {
        this();
        this.Tabla = Tabla;
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

    public int getTotalActividad() {
        int Count = 0;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(*) AS total FROM actividad";
            st = Data.getConection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Count = rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("Error ControlActividad.getTotalActividad:\n " + e.getMessage());
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

            } catch (Exception e) {
                System.out.println("Error ControlActividad.getTotalActividad (finally block):\n " + e.getMessage());
            }
        }
        return Count;
    }

    public int getIDNuevoActividad() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        int NuevoID = 0;
        try {
            String sql = "select  MAX(ID_Actividad)  from actividad";
            pst = Data.getConection().prepareStatement(sql);
            rs = pst.executeQuery(sql);
            if (rs.next()) {
                NuevoID = rs.getInt(1);
            }
            NuevoID++;
        } catch (Exception e) {
            System.out.println("Error ControlActividad.getIDNuevoActividad:\n " + e.getMessage());
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

            } catch (Exception e) {
                System.out.println("Error ControlActividad.getIDNuevoActividad (finally block):\n " + e.getMessage());
            }
        }
        return NuevoID;
    }

    public void MostrarTablaActividadBusqueda(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            LimpiarTabla();
            String sql = "SELECT * FROM actividad "
                    + "WHERE ID_Actividad  LIKE ? OR "
                    + "Descripcion LIKE ? ";

            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Busqueda + "%");
            pst.setString(2, Busqueda + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Tabla.addRow(new ActividadClass(
                        rs.getInt(1),
                        rs.getString(2)
                ).getRowTable());
            }
        } catch (Exception e) {
            System.out.println("Error ControlActividad.MostrarTablaActividadBusqueda:\n " + e.getMessage());
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

            } catch (Exception e) {
                System.out.println("Error ControlActividad.MostrarTablaActividadBusqueda (finally block):\n " + e.getMessage());
            }
        }
    }

    public ActividadClass getActividadEspecifico(int IDActividad) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        ActividadClass Actividad = null;

        try {
            String sql = "SELECT * FROM actividad "
                    + "WHERE ID_Actividad  = ?  ";

            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDActividad);
            rs = pst.executeQuery();
            if (rs.next()) {
                Actividad = new ActividadClass(
                        rs.getInt(1),
                        rs.getString(2)
                );

            }
            return Actividad;
        } catch (Exception e) {
            System.out.println("Error ControlActividad.ObtenerActividadEspecifico:\n " + e.getMessage());
            return null;
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

            } catch (Exception e) {
                System.out.println("Error ControlActividad.ObtenerActividadEspecifico (finally block):\n " + e.getMessage());
            }
        }
    }

    public void InsertarActividad(ActividadClass Actividad) {
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO actividad (ID_Actividad,Descripcion)"
                    + "VALUES (?, ?)";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, Actividad.getID_Actividad());
            pst.setString(2, Actividad.getDescripcion());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error ControlActividad.InsertarActividad:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlActividad.InsertarActividad (finally block):\n " + e.getMessage());
            }
        }
    }

    public void ModificarActividad(ActividadClass Actividad) {
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE actividad "
                    + "SET Descripcion = ?"
                    + "WHERE ID_Actividad  = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Actividad.getDescripcion());
            pst.setInt(2, Actividad.getID_Actividad());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlActividad.ModificarActividad:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlActividad.ModificarActividad (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarActividad(int ID_Actividad) {
        PreparedStatement pstservicio = null;
        try {
            String sql
                    = "DELETE FROM actividad WHERE ID_Actividad = ? ";
            pstservicio = Data.getConection().prepareStatement(sql);
            pstservicio.setInt(1, ID_Actividad);
            pstservicio.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error ControlActividad.EliminarActividad:\n " + e.getMessage());
        } finally {
            try {
                if (pstservicio != null && !pstservicio.isClosed()) {
                    pstservicio.close();
                }
            } catch (Exception e) {
                System.out.println("Error v.EliminarActividad (finally block):\n " + e.getMessage());
            }
        }
    }

}
