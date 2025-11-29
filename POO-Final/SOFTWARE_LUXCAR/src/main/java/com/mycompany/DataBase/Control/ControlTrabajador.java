package com.mycompany.DataBase.Control;

import com.mycompany.DataBase.DataBase;
import com.mycompany.Popup.PopupMessage;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.io.IOException;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class ControlTrabajador {

    private DataBase Data;
    private DefaultTableModel Tabla;

    public ControlTrabajador() {
        Data = new DataBase();
    }

    public ControlTrabajador(DefaultTableModel TablaModel) {
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

    public int getTotalTrabajadores() {
        int count = 0;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(*) AS total FROM trabajador";
            st = Data.getConection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.getTotalTrabajadores:\n " + e.getMessage());
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
                System.out.println("Error ControlTrabajador.getTotalTrabajadores (finally block):\n " + e.getMessage());
            }
        }
        return count;
    }

    public void MostrarTablaTrabajadorCompleta() {
        Statement st = null;
        ResultSet rs = null;
        try {
            LimpiarTabla();
            String sql = "select  * from trabajador";
            st = Data.getConection().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Tabla.addRow(new TrabajadorClass(
                        rs.getString(1),//DNI
                        rs.getString(2),//Nombres
                        rs.getString(3),//Apellidos
                        rs.getDate(4).toLocalDate(),//FechaNacimiento
                        rs.getString(5),//Direccion
                        rs.getString(6),//Correo
                        rs.getString(7),//Telefono
                        rs.getDate(8).toLocalDate(),//FechaContratacion
                        rs.getString(9),//Puesto
                        rs.getDouble(10),//Salario
                        rs.getString(11),//Genero
                        rs.getString(12)//Estado
                ).getRowTable());
            }
        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorCompleta:\n " + e.getMessage());
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
                System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorCompleta (finally block):\n " + e.getMessage());
            }
        }
    }

    public void BusquedaStaticaTrabajador(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            LimpiarTabla();
            String sql = "SELECT * FROM trabajador "
                    + "WHERE DNI LIKE ? OR "
                    + "Nombres LIKE ? OR "
                    + "Apellidos LIKE ? OR "
                    + "Correo LIKE ? OR "
                    + "Telefono LIKE ?";

            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Busqueda + "%");
            pst.setString(2, Busqueda + "%");
            pst.setString(3, Busqueda + "%");
            pst.setString(4, Busqueda + "%");
            pst.setString(5, Busqueda + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Tabla.addRow(new TrabajadorClass(
                        rs.getString(1),//DNI
                        rs.getString(2),//Nombres
                        rs.getString(3),//Apellidos
                        rs.getDate(4).toLocalDate(),//FechaNacimiento
                        rs.getString(5),//Direccion
                        rs.getString(6),//Correo
                        rs.getString(7),//Telefono
                        rs.getDate(8).toLocalDate(),//FechaContratacion
                        rs.getString(9),//Puesto
                        rs.getDouble(10),//Salario
                        rs.getString(11),//Genero
                        rs.getString(12)//Estado
                ).getRowTable());
            }
        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorStatic:\n " + e.getMessage());
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
                System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorStatic (finally block):\n " + e.getMessage());
            }
        }
    }

    public TrabajadorClass getTrabajadorEspecifico(String DNI) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        TrabajadorClass Trabajador = null;
        try {
            String sql = "SELECT * FROM trabajador "
                    + "WHERE DNI = ?  ";

            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, DNI);
            rs = pst.executeQuery();

            if (rs.next()) {
                Trabajador = new TrabajadorClass(
                        rs.getString(1),//DNI
                        rs.getString(2),//Nombres
                        rs.getString(3),//Apellidos
                        rs.getDate(4).toLocalDate(),//FechaNacimiento
                        rs.getString(5),//Direccion
                        rs.getString(6),//Correo
                        rs.getString(7),//Telefono
                        rs.getDate(8).toLocalDate(),//FechaContratacion
                        rs.getString(9),//Puesto
                        rs.getDouble(10),//Salario
                        rs.getString(11),//Genero
                        rs.getString(12),//Estado
                        rs.getBytes(13)
                );

            }
            return Trabajador;
        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorStatic:\n " + e.getMessage());
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
                System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorStatic (finally block):\n " + e.getMessage());
            }
        }
    }

    public void BusqudaDinamicaTrabajador(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            LimpiarTabla();

            String sql = " SELECT  * FROM trabajador "
                    + " WHERE "
                    + " DNI LIKE ? OR "
                    + " Nombres LIkE  ? OR "
                    + " Apellidos LIkE ? OR "
                    + " Correo LIkE  ? OR "
                    + " Telefono LIkE  ? ";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, "%" + Busqueda + "%");
            pst.setString(2, "%" + Busqueda + "%");
            pst.setString(3, "%" + Busqueda + "%");
            pst.setString(4, "%" + Busqueda + "%");
            pst.setString(5, "%" + Busqueda + "%");

            rs = pst.executeQuery();
            while (rs.next()) {
                Tabla.addRow(new TrabajadorClass(
                        rs.getString(1),//DNI
                        rs.getString(2),//Nombres
                        rs.getString(3),//Apellidos
                        rs.getDate(4).toLocalDate(),//FechaNacimiento
                        rs.getString(5),//Direccion
                        rs.getString(6),//Correo
                        rs.getString(7),//Telefono
                        rs.getDate(8).toLocalDate(),//FechaContratacion
                        rs.getString(9),//Puesto
                        rs.getDouble(10),//Salario
                        rs.getString(11),//Genero
                        rs.getString(12)//Estado
                ).getRowTable());
            }
        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorDinamic:\n " + e.getMessage());
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
                System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorDinamic (finally block):\n " + e.getMessage());
            }
        }

    }

    public void BusquedaDeTablaBasicaTrabajador(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            LimpiarTabla();
            String sql = "SELECT DNI, Nombres, Apellidos, Puesto, HoraCobro  FROM trabajador "
                    + "WHERE Estado = 'activo' AND ("
                    + "DNI LIKE ?  OR "
                    + "Nombres LIKE ? OR "
                    + "Apellidos LIKE ? OR "
                    + "Puesto LIKE  ? )";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, '%' + Busqueda + '%');
            pst.setString(2, '%' + Busqueda + '%');
            pst.setString(3, '%' + Busqueda + '%');
            pst.setString(4, '%' + Busqueda + '%');

            rs = pst.executeQuery();
            while (rs.next()) {
                Tabla.addRow(new TrabajadorClass(
                        rs.getString(1),//DNI
                        rs.getString(2),//Nombres
                        rs.getString(3),//Apellidos
                        rs.getString(4),//Puesto
                        rs.getDouble(5)
                ).getRowTableBasic());
            }
        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorBasic_x_EstadoDinamic:\n " + e.getMessage());
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
                System.out.println("Error ControlTrabajador.MostrarTablaTrabajadorBasic_x_EstadoDinamic (finally block):\n " + e.getMessage());
            }
        }

    }

    public boolean isExistTrabajador(String DNI) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select DNI FROM trabajador where DNI = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, DNI);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.isExistTrabajador:\n " + e.getMessage());
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
                System.out.println("Error ControlTrabajador.isExistTrabajador (finally block):\n " + e.getMessage());
            }
        }
        return false;

    }

    public String GenerarDniTrabajador() {
        String DniRamdom;
        while (true) {
            DniRamdom = String.valueOf((int) (Math.random() * 90000000) + 10000000);
            if (!isExistTrabajador(DniRamdom)) {
                break;
            }
        }
        return DniRamdom;
    }

    public void InsertarTrabajador(TrabajadorClass Trabajador) {
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO Trabajador (DNI, Nombres, Apellidos, FechaNacimiento, Direccion, Correo, Telefono, FechaContratacion, Puesto, HoraCobro, Genero, Estado,Foto)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Trabajador.getDNI());
            pst.setString(2, Trabajador.getNombres());
            pst.setString(3, Trabajador.getApellidos());
            pst.setDate(4, Date.valueOf(Trabajador.getFechaNacimiento()));
            pst.setString(5, Trabajador.getDireccion());
            pst.setString(6, Trabajador.getCorreo());
            pst.setString(7, Trabajador.getTelefono());
            pst.setDate(8, Date.valueOf(Trabajador.getFechaContratacion()));
            pst.setString(9, Trabajador.getPuesto());
            pst.setDouble(10, Trabajador.getHoraCobro());
            pst.setString(11, Trabajador.getGenero());
            pst.setString(12, Trabajador.getEstado());
            pst.setBytes(13, Trabajador.getFoto());

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.InsertarTrabajador:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlTrabajador.InsertarTrabajador (finally block):\n " + e.getMessage());
            }
        }
    }

    public void ModificarTrabajador(TrabajadorClass Trabajador) {
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE Trabajador "
                    + "SET Nombres = ?, Apellidos = ?, FechaNacimiento = ?, Direccion = ?, Correo = ?, Telefono = ?, FechaContratacion = ?, Puesto = ?, HoraCobro = ?, Genero = ?, Estado = ?, Foto =? "
                    + "WHERE DNI = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Trabajador.getNombres());
            pst.setString(2, Trabajador.getApellidos());
            pst.setDate(3, Date.valueOf(Trabajador.getFechaNacimiento()));
            pst.setString(4, Trabajador.getDireccion());
            pst.setString(5, Trabajador.getCorreo());
            pst.setString(6, Trabajador.getTelefono());
            pst.setDate(7, Date.valueOf(Trabajador.getFechaContratacion()));
            pst.setString(8, Trabajador.getPuesto());
            pst.setDouble(9, Trabajador.getHoraCobro());
            pst.setString(10, Trabajador.getGenero());
            pst.setString(11, Trabajador.getEstado());
            if(Trabajador.getFoto() == null){
                pst.setBytes(12,null);
            }else{
                pst.setBytes(12, Trabajador.getFoto());
            }
            
            pst.setString(13, Trabajador.getDNI());

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlTrabajador.ModificarTrabajador:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlTrabajador.ModificarTrabajador (finally block):\n " + e.getMessage());
            }
        }
    }

   

    public void EliminarTrabajador(TrabajadorClass Trabajador) {
        PreparedStatement psttrabajador = null;
        try {
            
            ControlUsuario cu = new ControlUsuario();
            cu.EliminarUsuario(Trabajador.getDNI());
            cu.Disconneting();

            String sql_trabajador
                    = "DELETE FROM Trabajador WHERE DNI = ? ";
            psttrabajador = Data.getConection().prepareStatement(sql_trabajador);
            psttrabajador.setString(1, Trabajador.getDNI());
            psttrabajador.executeUpdate();


        } catch (Exception e) {
            GlassPanePopup.closePopupLast();
            new PopupMessage(
                    "NO SE PUDO COMPLETAR LA OPERACION",
                    "El trabajador esta registrado y agregado a servicios dentro de la base de datos.",
                    2
            );
            
            System.out.println("Error ControlTrabajador.EliminarTrabajador:\n " + e.getMessage());
        } finally {
            
            try {
                if (psttrabajador != null && !psttrabajador.isClosed()) {
                    psttrabajador.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlTrabajador.EliminarTrabajador (finally block):\n " + e.getMessage());
            }
        }
    }

}
