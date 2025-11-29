package com.mycompany.DataBase.Control;

import com.mycompany.DataBase.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class ControlServicio {

    private DataBase Data;
    private DefaultTableModel Tabla;

    public ControlServicio() {
        Data = new DataBase();
    }

    public ControlServicio(DefaultTableModel Tabla) {
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

    public int getTotalServicio() {
        int Count = 0;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(*) AS total FROM servicio";
            st = Data.getConection().createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Count = rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("Error ControlServicio.getTotalServicio:\n " + e.getMessage());
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
                System.out.println("Error ControlServicio.getTotalServicio (finally block):\n " + e.getMessage());
            }
        }
        return Count;
    }

    public int getIDNuevoServicio() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        int NuevoID = 0;
        try {
            String sql = "select  MAX(ID_Servicio)  from servicio";
            pst = Data.getConection().prepareStatement(sql);
            rs = pst.executeQuery(sql);
            if (rs.next()) {
                NuevoID = rs.getInt(1);
            }
            NuevoID++;
        } catch (Exception e) {
            System.out.println("Error ControlServicio.getIDNuevoServicio:\n " + e.getMessage());
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
                System.out.println("Error ControlServicio.getIDNuevoServicio (finally block):\n " + e.getMessage());
            }
        }
        return NuevoID;
    }

    public void MostrarTablaServicioBusqueda(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            LimpiarTabla();
            String sql = "SELECT * FROM servicio "
                    + "WHERE ID_Servicio  LIKE ? OR "
                    + "Ubicacion LIKE ? OR "
                    + "Descripcion LIKE ? OR "
                    + "Estado LIKE ?";

            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Busqueda + "%");
            pst.setString(2, Busqueda + "%");
            pst.setString(3, Busqueda + "%");
            pst.setString(4, Busqueda + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Timestamp Fechainicio = rs.getTimestamp(5);
                Timestamp Fecharegistrada = rs.getTimestamp(6);
                Tabla.addRow(new ServicioClass(
                        rs.getInt(1),//ID SERVICIO
                        rs.getString(2),//UBICACION
                        rs.getString(3),//DESCRIPCION
                        rs.getString(4),//ESTADO
                        Fechainicio.toLocalDateTime(),//FECHA INICIO
                        Fecharegistrada.toLocalDateTime()//FECHA REGISTRO
                ).getRowTable());
            }
        } catch (Exception e) {
            System.out.println("Error ControlServicio.MostrarTablaServicioStatic:\n " + e.getMessage());
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
                System.out.println("Error ControlServicio.MostrarTablaServicioStatic (finally block):\n " + e.getMessage());
            }
        }
    }

    public void MostrarTablaServicioOrInProcess(String Busqueda) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            LimpiarTabla();
            String sql = "SELECT * FROM servicio "
                    + "WHERE Estado != 'Terminado' AND "
                    + "(ID_Servicio  LIKE ? OR "
                    + "Ubicacion LIKE ? OR "
                    + "Descripcion LIKE ?  )";

            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Busqueda + "%");
            pst.setString(2, Busqueda + "%");
            pst.setString(3, Busqueda + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Timestamp Fechainicio = rs.getTimestamp(5);
                Tabla.addRow(new ServicioClass(
                        rs.getInt(1),//ID SERVICIO
                        rs.getString(2),//UBICACION
                        rs.getString(3),//DESCRIPCION
                        rs.getString(4),//ESTADO
                        Fechainicio.toLocalDateTime()//FECHA INICIO
                ).getRowTable());
            }
        } catch (Exception e) {
            System.out.println("Error ControlServicio.MostrarTablaServicioStatic:\n " + e.getMessage());
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
                System.out.println("Error ControlServicio.MostrarTablaServicioStatic (finally block):\n " + e.getMessage());
            }
        }
    }

    public void getTablaTrabajoresOfServicio(int IDServicio, DefaultTableModel model) {

        ControlTrabajador Trabajador = new ControlTrabajador();

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

            String sql = "select  DNI,HorasEjecutado from serviciotrabajador "
                    + "where ID_Servicio  = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            rs = pst.executeQuery();

            while (rs.next()) {
                String DNI = rs.getString(1);
                double HorasEjecutadas = rs.getDouble(2);

                TrabajadorClass T = Trabajador.getTrabajadorEspecifico(DNI);
                double CobroPorHora = T.getHoraCobro();
                Object fila[] = new Object[]{
                    T.getDNI(),
                    T.getNombres(),
                    T.getApellidos(),
                    T.getPuesto(),
                    HorasEjecutadas,
                    CobroPorHora,
                    (HorasEjecutadas * CobroPorHora)
                };

                model.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error ControlServicio.getTablaTrabajoresOfServicio:\n " + e.getMessage());
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
                Trabajador.Disconneting();

            } catch (Exception e) {
                System.out.println("Error ControlServicio.getTablaTrabajoresOfServicio (finally block):\n " + e.getMessage());
            }
        }

    }

    private void ActualizarEstado(String Estado, int id) {
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE servicio "
                    + "SET Estado = ?"
                    + "WHERE ID_Servicio  = ?";
            pst = Data.getConection().prepareStatement(sql);

            pst.setString(1, Estado);
            pst.setInt(2, id);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.ModificarServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.ModificarServicio (finally block):\n " + e.getMessage());
            }
        }

    }

    public void insertarfechaFinalizacion(LocalDateTime localtime, int id) {
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE servicio "
                    + "SET FechaFinalizacion = ?"
                    + "WHERE ID_Servicio  = ?";
            pst = Data.getConection().prepareStatement(sql);

            Timestamp timestamp = Timestamp.valueOf(localtime);
            pst.setTimestamp(1, timestamp);
            pst.setInt(2, id);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.ModificarServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.ModificarServicio (finally block):\n " + e.getMessage());
            }
        }

    }

    public void getTablaMaterialesOfServicio(int IDServicio, DefaultTableModel model) {

        ControlMaterial Material = new ControlMaterial();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            String sql = "select  ID_Material ,Cantidad from serviciomaterial "
                    + "where ID_Servicio  = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            rs = pst.executeQuery();

            while (rs.next()) {

                int ID_Material = rs.getInt(1);
                int Cantidad = rs.getInt(2);
                MaterialClass M = Material.ObtenerMaterialEspecifico(ID_Material);

                Object fila[] = new Object[]{
                    M.getID_Material(),
                    M.getDescripcion(),
                    M.getUnidadMedida(),
                    Cantidad,
                    M.getPrecioUnitario(),
                    Cantidad * M.getPrecioUnitario()
                };

                model.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error ControlServicio.getTablaTrabajoresOfServicio:\n " + e.getMessage());
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
                Material.Disconneting();

            } catch (Exception e) {
                System.out.println("Error ControlServicio.getTablaTrabajoresOfServicio (finally block):\n " + e.getMessage());
            }
        }

    }

    public String obtenerEstado(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        LocalDateTime fechaActual = LocalDateTime.now();

        if (fechaActual.isBefore(fechaInicio)) {
            return "Sin comenzar";
        } else if (fechaActual.isAfter(fechaFin)) {
            return "Terminado";
        } else {
            return "En proceso";
        }
    }

    public void ActualizarEstadosServicio() {
        Statement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT ID_Servicio , FechaInicio,FechaFinalizacion FROM servicio ";

            pst = Data.getConection().createStatement();
            rs = pst.executeQuery(sql);

            while (rs.next()) {
                Timestamp Fechainicio = rs.getTimestamp(2);
                Timestamp FechaFinalizacion = rs.getTimestamp(3);

                if (FechaFinalizacion != null) {
                    String estadoNuevo = obtenerEstado(Fechainicio.toLocalDateTime(), FechaFinalizacion.toLocalDateTime());
                    ActualizarEstado(estadoNuevo, rs.getInt(1));
                }

            }
        } catch (Exception e) {
            System.out.println("Error ControlServicio.MostrarTablaServicioStatic:\n " + e.getMessage());
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
                System.out.println("Error ControlServicio.MostrarTablaServicioStatic (finally block):\n " + e.getMessage());
            }
        }
    }

    public void getTablaActividadOfServicio(int IDServicio, DefaultTableModel model) {

        ControlActividad Actividad = new ControlActividad();

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

            String sql = "select  ID_Actividad  from servicioactividad "
                    + "where ID_Servicio  = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            rs = pst.executeQuery();

            while (rs.next()) {

                ActividadClass A = Actividad.getActividadEspecifico(rs.getInt(1));
                Object fila[] = new Object[]{
                    A.getID_Actividad(),
                    A.getDescripcion()
                };

                model.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error ControlServicio.getTablaTrabajoresOfServicio:\n " + e.getMessage());
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
                Actividad.Disconneting();

            } catch (Exception e) {
                System.out.println("Error ControlServicio.getTablaTrabajoresOfServicio (finally block):\n " + e.getMessage());
            }
        }

    }

    public DefaultTableModel getAllServiceTrabajador(String DNI, DefaultTableModel modelo) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        DefaultTableModel model = modelo;
        try {
            String sql = "SELECT ID_Servicio  FROM serviciotrabajador "
                    + "WHERE DNI = ?  ";

            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, DNI);
            rs = pst.executeQuery();

            int Count = 0;

            while (rs.next()) {
                Count++;
                ServicioClass s = ObtenerServicioEspecifico(rs.getInt(1));
                Object fila[] = new Object[]{
                    Count,
                    rs.getInt(1),
                    s.getUbicacion(),
                    s.getEstado()
                };
                model.addRow(fila);
            }
            return model;
        } catch (Exception e) {
            System.out.println("Error ControlServicio.ObtenerServicioEspecifico:\n " + e.getMessage());
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
                System.out.println("Error ControlServicio.ObtenerServicioEspecifico (finally block):\n " + e.getMessage());
            }
        }
        return model;
    }

    public ServicioClass ObtenerServicioEspecifico(int IDServicio) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ServicioClass Servicio = null;
        try {
            String sql = "SELECT * FROM servicio "
                    + "WHERE ID_Servicio = ?  ";

            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            rs = pst.executeQuery();

            if (rs.next()) {
                Timestamp Fechainicio = rs.getTimestamp(5);
                Timestamp Fecharegistrada = rs.getTimestamp(6);
                if (rs.getTimestamp(7) != null) {
                    Timestamp FechaFinalizacion = rs.getTimestamp(7);
                    Servicio = new ServicioClass(
                            rs.getInt(1),//ID SERVICIO
                            rs.getString(2),//UBICACION
                            rs.getString(3),//DESCRIPCION
                            rs.getString(4),//ESTADO
                            Fechainicio.toLocalDateTime(),//FECHA INICIO
                            Fecharegistrada.toLocalDateTime(),//FECHA REGISTRO
                            FechaFinalizacion.toLocalDateTime()//FECHA FINALIZACION
                    );
                } else {
                    Servicio = new ServicioClass(
                            rs.getInt(1),//ID SERVICIO
                            rs.getString(2),//UBICACION
                            rs.getString(3),//DESCRIPCION
                            rs.getString(4),//ESTADO
                            Fechainicio.toLocalDateTime(),//FECHA INICIO
                            Fecharegistrada.toLocalDateTime(),//FECHA REGISTRO
                            null//FECHA FINALIZACION
                    );
                }

            }
            return Servicio;
        } catch (Exception e) {
            System.out.println("Error ControlServicio.ObtenerServicioEspecifico:\n " + e.getMessage());
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
                System.out.println("Error ControlServicio.ObtenerServicioEspecifico (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarAllTrabajadorServicio(int IDServicio) {
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM serviciotrabajador WHERE ID_Servicio = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.InsertarTrabajadorServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.InsertarTrabajadorServicio (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarAllActividadServicio(int IDServicio) {
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM servicioactividad WHERE ID_Servicio = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.InsertarTrabajadorServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.InsertarTrabajadorServicio (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarAllMaterialServicio(int IDServicio) {
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM serviciomaterial WHERE ID_Servicio = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.InsertarTrabajadorServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.InsertarTrabajadorServicio (finally block):\n " + e.getMessage());
            }
        }
    }

    public void InsertarTrabajadorServicio(int IDServicio, String DNI, double HorasEjecutadas) {
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO serviciotrabajador (ID_Servicio , DNI, HorasEjecutado)"
                    + "VALUES (?, ? ,?)";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            pst.setString(2, DNI);
            pst.setDouble(3, HorasEjecutadas);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.InsertarTrabajadorServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.InsertarTrabajadorServicio (finally block):\n " + e.getMessage());
            }
        }
    }

    public void InsertarActividadServicio(int IDServicio, String ID_Actividad) {
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO servicioactividad (ID_Servicio , ID_Actividad )"
                    + "VALUES (?, ? )";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            pst.setString(2, ID_Actividad);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.InsertarActividadServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.InsertarActividadServicio (finally block):\n " + e.getMessage());
            }
        }
    }

    public void InsertarMaterialServicio(int IDServicio, String ID_Material, int Cantidad) {
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO serviciomaterial (ID_Servicio , ID_Material  ,Cantidad)"
                    + "VALUES ( ?, ?, ?)";
            pst = Data.getConection().prepareStatement(sql);
            pst.setInt(1, IDServicio);
            pst.setString(2, ID_Material);
            pst.setInt(3, Cantidad);
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.InsertarActividadServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.InsertarActividadServicio (finally block):\n " + e.getMessage());
            }
        }
    }

    public void InsertarServicio(ServicioClass Servicio) {
        PreparedStatement pst = null;

        try {

            String sql = "INSERT INTO servicio (ID_Servicio , Ubicacion, Descripcion, FechaInicio, Estado)"
                    + "VALUES (?, ?, ?, ?, ? )";
            pst = Data.getConection().prepareStatement(sql);

            Timestamp timestamp = Timestamp.valueOf(Servicio.getFechaInicio());

            pst.setInt(1, Servicio.getIDServicio());
            pst.setString(2, Servicio.getUbicacion());
            pst.setString(3, Servicio.getDescripcion());
            pst.setTimestamp(4, timestamp);
            pst.setString(5, Servicio.getEstado());

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.InsertarServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }

            } catch (Exception e) {
                System.out.println("Error ControlServicio.InsertarServicio (finally block):\n " + e.getMessage());
            }
        }
    }

    public void ModificarServicio(ServicioClass Servicio) {
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE servicio "
                    + "SET Ubicacion = ?, Descripcion = ?, Estado = ? ,  FechaInicio = ?"
                    + "WHERE ID_Servicio  = ?";
            pst = Data.getConection().prepareStatement(sql);
            pst.setString(1, Servicio.getUbicacion());
            pst.setString(2, Servicio.getDescripcion());
            pst.setString(3, Servicio.getEstado());
            Timestamp timestamp = Timestamp.valueOf(Servicio.getFechaInicio());
            pst.setTimestamp(4, timestamp);
            pst.setInt(5, Servicio.getIDServicio());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.ModificarServicio:\n " + e.getMessage());
        } finally {
            try {
                if (pst != null && !pst.isClosed()) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.ModificarServicio (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarServicioTrabajador(int IDServicio) {
        PreparedStatement pstservicio = null;
        try {

            String sql_trabajador
                    = "DELETE FROM serviciotrabajador WHERE ID_Servicio = ? ";
            pstservicio = Data.getConection().prepareStatement(sql_trabajador);
            pstservicio.setInt(1, IDServicio);
            pstservicio.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.EliminarServicioTrabajador:\n " + e.getMessage());
        } finally {
            try {

                if (pstservicio != null && !pstservicio.isClosed()) {
                    pstservicio.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.EliminarServicioTrabajador (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarServicioMaterial(int IDServicio) {
        PreparedStatement pstservicio = null;
        try {

            String sql_trabajador
                    = "DELETE FROM serviciomaterial WHERE ID_Servicio = ? ";
            pstservicio = Data.getConection().prepareStatement(sql_trabajador);
            pstservicio.setInt(1, IDServicio);
            pstservicio.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.EliminarServicioMaterial:\n " + e.getMessage());
        } finally {
            try {

                if (pstservicio != null && !pstservicio.isClosed()) {
                    pstservicio.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.EliminarServicioMaterial (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarServicioActividad(int IDServicio) {
        PreparedStatement pstservicio = null;
        try {

            String sql_trabajador
                    = "DELETE FROM servicioactividad WHERE ID_Servicio = ? ";
            pstservicio = Data.getConection().prepareStatement(sql_trabajador);
            pstservicio.setInt(1, IDServicio);
            pstservicio.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.EliminarServicioMaterial:\n " + e.getMessage());
        } finally {
            try {

                if (pstservicio != null && !pstservicio.isClosed()) {
                    pstservicio.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.EliminarServicioMaterial (finally block):\n " + e.getMessage());
            }
        }
    }

    public void EliminarServicio(int IDServicio) {
        EliminarServicioMaterial(IDServicio);
        EliminarServicioTrabajador(IDServicio);
        EliminarServicioActividad(IDServicio);
        PreparedStatement pstservicio = null;
        try {

            String sql_trabajador
                    = "DELETE FROM servicio WHERE ID_Servicio  = ? ";
            pstservicio = Data.getConection().prepareStatement(sql_trabajador);
            pstservicio.setInt(1, IDServicio);
            pstservicio.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error ControlServicio.EliminarServicio:\n " + e.getMessage());
        } finally {
            try {

                if (pstservicio != null && !pstservicio.isClosed()) {
                    pstservicio.close();
                }
            } catch (Exception e) {
                System.out.println("Error ControlServicio.EliminarServicio (finally block):\n " + e.getMessage());
            }
        }
    }
}
