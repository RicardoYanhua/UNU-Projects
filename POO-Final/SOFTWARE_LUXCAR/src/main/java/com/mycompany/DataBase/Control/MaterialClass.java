/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DataBase.Control;

/**
 *
 * @author ricar
 */
public class MaterialClass {

    private int ID_Material;
    private String Nombre;
    private String Descripcion;
    private String UnidadMedida;
    private double PrecioUnitario;

    public MaterialClass() {
    }

    public MaterialClass(int ID_Material, String Nombre, String Descripcion, String UnidadMedida, double PrecioUnitario) {
        this.ID_Material = ID_Material;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.UnidadMedida = UnidadMedida;
        this.PrecioUnitario = PrecioUnitario;
    }

    
    public MaterialClass(int ID_Material, String Nombre, String Descripcion, String UnidadMedida) {
        this.ID_Material = ID_Material;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.UnidadMedida = UnidadMedida;
    }

    public MaterialClass(String Nombre, String Descripcion, String UnidadMedida) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.UnidadMedida = UnidadMedida;
    }

    public MaterialClass(String Nombre, String Descripcion, String UnidadMedida, double PrecioUnitario) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.UnidadMedida = UnidadMedida;
        this.PrecioUnitario = PrecioUnitario;
    }
    

    public Object[] getRowTable() {
        return new Object[]{
            ID_Material,
            Nombre,
            Descripcion,
            UnidadMedida,
            PrecioUnitario
        };
    }

    public int getID_Material() {
        return ID_Material;
    }

    public void setID_Material(int ID_Material) {
        this.ID_Material = ID_Material;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }
    

}
