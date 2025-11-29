package com.mycompany.Swing.Menu.auxiliary;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class ModelMenuItem {

    private FlatSVGIcon IconoItem;
    private String NombreItem;

    public ModelMenuItem() {
    }

    public ModelMenuItem(FlatSVGIcon Icono, String Nombre) {
        this.IconoItem = Icono;
        this.NombreItem = Nombre;
    }

    public FlatSVGIcon getIcon() {
        return IconoItem;
    }

    public String getMenuName() {
        return NombreItem;
    }

    public void setMenuName(String menuName) {
        this.NombreItem = menuName;
    }

}
