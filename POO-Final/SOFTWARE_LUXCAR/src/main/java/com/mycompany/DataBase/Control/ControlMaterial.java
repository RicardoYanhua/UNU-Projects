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
public class ControlMaterial {
    
    private DataBase Data;
    private DefaultTableModel Tabla;
    
    public ControlMaterial() {
        Data = new DataBase();
    }
    
    public ControlMaterial(DefaultTableModel Tabla) {
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
    
    public int getTotalMaterial() {
        int Count = 0;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(*) AS total FROM material";
            st = Data.getConection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Count = rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("Error ControlMaterial.getTotalMaterial:\n " + e.getMessage());
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
                System.out.println("Error ControlMaterial.getTotalMaterial (finally block):\n " + e.getMessage());
            }
        }
        return Count;
    }
    
    public int getIDNuevoMaterial() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        int NuevoID = 0;
        try {
            String sql = "select  MAX(ID_Material)  from material";
            pst = Data.getConection().prepareStatement(sql);
            rs = pst.executeQuery(sql);
            if (rs.next()) {
                NuevoID = rs.getInt(1);
            }
            NuevoID++;
        } catch (Exception e) {
            System.out.println("Error ControlMaterial.getIDNuevoMaterial:\n " + e.getMessage());
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
                System.out.println("Error ControlMaterial.getIDNuevoMaterial (finally block):\n " + e.getMessage());
            }
        }
        return NuevoID;
    }
    
    public void MostrarTablaMaterialBusqueda(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            LimpiarTabla();
            String sql = "SELECT * FROM material "
                    + "WHERE ID_Material  LIKE ? OR "
                    + "Nombre LIKE ? OR "
                    + "Descripcion LIKE ? OR "
                    + "UnidadMedida LIKE ?";
            
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Busqueda + "%");
            pst.setString(2, Busqueda + "%");
            pst.setString(3, Busqueda + "%");
            pst.setString(4, Busqueda + "%");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Tabla.addRow(new MaterialClass(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5)
                ).getRowTable());
            }
        } catch (Exception e) {
            System.out.println("Error ControlMaterial.MostrarTablaMaterialBusqueda:\n " + e.getMessage());
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
                System.out.println("Error ControlMaterial.MostrarTablaMaterialBusqueda (finally block):\n " + e.getMessage());
            }
        }
    }
    
    public MaterialClass ObtenerMaterialEspecifico(int IDMaterial) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        MaterialClass Material = null;
        
        try {
            String sql = "SELECT * FROM material "
                    + "WHERE ID_Material  = ?  ";
            
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDMaterial);
            rs = pst.executeQuery();
            if (rs.next()) {
                
                Material = new MaterialClass(
                        rs.getInt(1),//ID Material
                        rs.getString(2),//Nombre
                        rs.getString(3),//DESCRIPCION
                        rs.getString(4),//Unidad de medida
                        rs.getDouble(5)
                );
                
            }
            return Material;
        } catch (Exception e) {
            System.out.println("Error ControlMaterial.ObtenerMaterialEspecifico:\n " + e.getMessage());
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
                System.out.println("Error ControlMaterial.ObtenerMaterialEspecifico (finally block):\n " + e.getMessage());
            }
        }
    }
    
    public void InsertarMaterial(MaterialClass Material) {
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO material (ID_Material, Nombre,Descripcion,UnidadMedida,PrecioUnitario)"
                    + "VALUES (?, ?, ? ,? ,?)";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, Material.getID_Material());
            pst.setString(2, Material.getNombre());
            pst.setString(3, Material.getDescripcion());
            pst.setString(4, Material.getUnidadMedida());
            pst.setDouble(5, Material.getPrecioUnitario());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error ControlMaterial.InsertarMaterial:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlMaterial.InsertarMaterial (finally block):\n " + e.getMessage());
            }
        }
    }
    
    public void ModificarMaterial(MaterialClass material) {
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE material "
                    + "SET Nombre = ?, Descripcion = ?, UnidadMedida = ?, PrecioUnitario = ? "
                    + "WHERE ID_Material   = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, material.getNombre());
            pst.setString(2, material.getDescripcion());
            pst.setString(3, material.getUnidadMedida());
            pst.setDouble(4, material.getPrecioUnitario());
            pst.setInt(5, material.getID_Material());
            pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error ControlMaterial.ModificarMaterial:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlMaterial.ModificarMaterial (finally block):\n " + e.getMessage());
            }
        }
    }
    
    public void EliminarMaterial(int IDMaterial) {
        PreparedStatement pstservicio = null;
        try {
            String sql
                    = "DELETE FROM material WHERE ID_Material = ? ";
            pstservicio = Data.getConection().prepareStatement(sql);
            pstservicio.setInt(1, IDMaterial);
            pstservicio.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error ControlMaterial.EliminarMaterial:\n " + e.getMessage());
        } finally {
            try {
                if (pstservicio != null && !pstservicio.isClosed()) {
                    pstservicio.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlMaterial.EliminarMaterial (finally block):\n " + e.getMessage());
            }
        }
    }
    
}
