package com.mycompany.Menu_4;

import com.formdev.flatlaf.extras.FlatSVGIcon;


public class ModelMenuItem {

    public FlatSVGIcon getIcon() {
        return icon;
    }

    public void setIcon(FlatSVGIcon icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String[] getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }

    public ModelMenuItem(FlatSVGIcon icon, String menuName, String... subMenu) {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }

    public ModelMenuItem() {
    }

    private FlatSVGIcon icon;
    private String menuName;
    private String subMenu[];
}
