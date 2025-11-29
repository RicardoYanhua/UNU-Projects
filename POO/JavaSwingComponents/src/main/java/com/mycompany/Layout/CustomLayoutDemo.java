/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.Layout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;

public class CustomLayoutDemo {
    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Custom Layout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear el JPanel y establecer el layout personalizado
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.RED));
        panel.setLayout(new RightBorderButtonLayout());

        // Crear el botón que se superpondrá en el borde derecho
        JButton button = new JButton("Resize");

        // Agregar funcionalidad al botón para cambiar el tamaño del panel
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el tamaño actual del panel
                Dimension currentSize = panel.getSize();

                // Alternar entre el tamaño grande y pequeño
                if (currentSize.width == 300) {
                    panel.setPreferredSize(new Dimension(50, panel.getHeight()));
                } else {
                    panel.setPreferredSize(new Dimension(300, panel.getHeight()));
                }

                // Volver a colocar los componentes y refrescar el contenedor
                panel.revalidate();
                frame.pack(); // Ajusta el tamaño de la ventana al contenido
            }
        });

        // Agregar el botón al panel
        panel.add(button);

        // Establecer el tamaño inicial del panel
        panel.setPreferredSize(new Dimension(400, 300));

        // Agregar el panel al frame
        frame.add(panel);

        // Hacer visible la ventana
        frame.pack(); // Ajusta el tamaño de la ventana al contenido inicial
        frame.setVisible(true);
    }
}
