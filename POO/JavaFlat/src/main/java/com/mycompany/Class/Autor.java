/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Class;

/**
 *
 * @author ricar
 */
public class Autor {
    
    private String AutorID;
    private String Nombre ;
    private String Apellido;

    public Autor(String AutorID, String Nombre, String Apellido) {
        this.AutorID = AutorID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }
    
    public Object[] toRow (){
        return new Object[]{this.AutorID,this.Nombre,this.Apellido};
    }

    public String getAutorID() {
        return AutorID;
    }

    public void setAutorID(String AutorID) {
        this.AutorID = AutorID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    
    
}
