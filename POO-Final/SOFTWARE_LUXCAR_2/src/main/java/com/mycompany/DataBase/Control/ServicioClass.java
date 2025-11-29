/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DataBase.Control;

import java.time.LocalDateTime;

/**
 *
 * @author ricar
 */
public class ServicioClass {

    private int IDServicio;
    private String Ubicacion;
    private String Descripcion;
    private String Estado;
    private LocalDateTime FechaInicio;
    private LocalDateTime FechaServicoRegistrado;

    public ServicioClass() {
    }

    public ServicioClass(int IDServicio, String Ubicacion, String Descripcion, String Estado, LocalDateTime FechaInicio, LocalDateTime FechaServicoRegistrado) {
        this.IDServicio = IDServicio;
        this.Ubicacion = Ubicacion;
        this.Descripcion = Descripcion;
        this.FechaInicio = FechaInicio;
        this.FechaServicoRegistrado = FechaServicoRegistrado;
        this.Estado = Estado;
    }

    public ServicioClass(String Ubicacion, String Descripcion, String Estado, LocalDateTime FechaInicio) {
        this.Ubicacion = Ubicacion;
        this.Descripcion = Descripcion;
        this.FechaInicio = FechaInicio;
        this.Estado = Estado;
    }

    public ServicioClass(int IDServicio, String Ubicacion, String Descripcion, String Estado, LocalDateTime FechaInicio) {
        this.IDServicio = IDServicio;
        this.Ubicacion = Ubicacion;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.FechaInicio = FechaInicio;
    }
    

    public Object[] getRowTableBasic() {
        return new Object[]{
            IDServicio,
            Ubicacion,
            Descripcion,
            Estado,
            FechaInicio
        };
    }

    public Object[] getRowTable() {
        return new Object[]{
            IDServicio,
            Ubicacion,
            Descripcion,
            Estado,
            FechaInicio,
            FechaServicoRegistrado
        };
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public LocalDateTime getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDateTime Fecha) {
        this.FechaInicio = Fecha;
    }

    public LocalDateTime getFechaServicoRegistrado() {
        return FechaServicoRegistrado;
    }

    public void setFechaServicoRegistrado(LocalDateTime FechaServicoRegistrado) {
        this.FechaServicoRegistrado = FechaServicoRegistrado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
