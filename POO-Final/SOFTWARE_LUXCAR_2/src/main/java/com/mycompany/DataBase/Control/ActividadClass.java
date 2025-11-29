/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DataBase.Control;

/**
 *
 * @author ricar
 */
public class ActividadClass {
    
    private int ID_Actividad;
    private String Descripcion;

    public ActividadClass() {
    }

    public ActividadClass(int ID_Actividad, String Descripcion) {
        this.ID_Actividad = ID_Actividad;
        this.Descripcion = Descripcion;
    }

    public ActividadClass(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
     public Object[] getRowTable() {
        return new Object[]{
            ID_Actividad,
            Descripcion
        };
    }


    public int getID_Actividad() {
        return ID_Actividad;
    }

    public void setID_Actividad(int ID_Actividad) {
        this.ID_Actividad = ID_Actividad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
}
