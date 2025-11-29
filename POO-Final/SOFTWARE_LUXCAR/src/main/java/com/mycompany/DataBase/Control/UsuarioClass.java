package com.mycompany.DataBase.Control;

public class UsuarioClass {

    private int ID;
    private String DNI;
    private String Contraseña;
    private boolean AdminPermision;
    

    public UsuarioClass() {
    }

    public UsuarioClass(int ID, String DNI, String Contraseña, boolean AdminPermision) {
        this.ID = ID;
        this.DNI = DNI;
        this.Contraseña = Contraseña;
        this.AdminPermision = AdminPermision;
    }

    public UsuarioClass(String DNI, String Contraseña, boolean AdminPermision) {
        this.DNI = DNI;
        this.Contraseña = Contraseña;
        this.AdminPermision = AdminPermision;
    }

    public UsuarioClass(String DNI, String Contraseña) {
        this.DNI = DNI;
        this.Contraseña = Contraseña;
    }

    public UsuarioClass(String DNI, boolean AdminPermision) {
        this.DNI = DNI;
        this.AdminPermision = AdminPermision;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public boolean isAdminPermision() {
        return AdminPermision;
    }

    public void setAdminPermision(boolean AdminPermision) {
        this.AdminPermision = AdminPermision;
    }
    
    
    
    

   

}
