/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Layout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class RightBorderButtonLayout implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // No es necesario implementar nada aquí para este caso
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // No es necesario implementar nada aquí para este caso
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getSize(); // Devuelve el tamaño del contenedor
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getSize(); // Devuelve el tamaño del contenedor
    }

    @Override
    public void layoutContainer(Container parent) {
        // Obtener el tamaño del contenedor
        int width = parent.getWidth();
        int height = parent.getHeight();

        // Recorrer todos los componentes del contenedor
        for (Component comp : parent.getComponents()) {
            if (comp.isVisible()) {
                // Obtener el tamaño preferido del componente
                Dimension preferredSize = comp.getPreferredSize();

                // Posicionar el componente en el borde derecho, centrado verticalmente en la línea
                int x = width - (preferredSize.width / 2);
                int y = (height - preferredSize.height) / 2;

                // Establecer la ubicación y el tamaño del componente
                comp.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
        }
    }
}