/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DataBase.Control;

import java.time.LocalDate;

/**
 *
 * @author ricar
 */
public class TrabajadorClass {

    private String DNI;
    private String Nombres;
    private String Apellidos;
    private LocalDate FechaNacimiento;
    private String Direccion;
    private String Correo;
    private String Telefono;
    private LocalDate FechaContratacion;
    private String Puesto;
    private double HoraCobro;
    private String Genero;
    private String Estado;

    public TrabajadorClass() {
    }

    public TrabajadorClass(String DNI) {
        this.DNI = DNI;
    }
    

    public TrabajadorClass(String DNI, String Nombres, String Apellidos, LocalDate FechaNacimiento, String Direccion, String Correo, String Telefono, LocalDate FechaContratacion, String Puesto, double HoraCobro, String Genero, String Estado) {
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.FechaNacimiento = FechaNacimiento;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.FechaContratacion = FechaContratacion;
        this.Puesto = Puesto;
        this.HoraCobro = HoraCobro;
        this.Genero = Genero;
        this.Estado = Estado;
    }

    public TrabajadorClass(String DNI, String Nombres, String Apellidos, String Puesto, double HoraCobro) {
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Puesto = Puesto;
        this.HoraCobro = HoraCobro;
    }
    

    public TrabajadorClass(String DNI, String Nombres, String Apellidos, String Puesto) {
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Puesto = Puesto;
    }
    public Object[] getRowTableBasic() {
        return new Object[]{
            DNI,
            Nombres,
            Apellidos,
            Puesto,
            HoraCobro
        };
    }
    
    public String getNombresApellidos(){
        return "" + Nombres + ", "+  Apellidos;
    }

    public Object[] getRowTable() {
        return new Object[]{
            DNI,
            Nombres,
            Apellidos,
            FechaNacimiento,
            Direccion,
            Correo,
            Telefono,
            FechaContratacion,
            Puesto,
            HoraCobro,
            Genero,
            Estado
        };
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public LocalDate getFechaContratacion() {
        return FechaContratacion;
    }

    public void setFechaContratacion(LocalDate FechaContratacion) {
        this.FechaContratacion = FechaContratacion;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public double getHoraCobro() {
        return HoraCobro;
    }

    public void setHoraCobro(double HoraCobro) {
        this.HoraCobro = HoraCobro;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
