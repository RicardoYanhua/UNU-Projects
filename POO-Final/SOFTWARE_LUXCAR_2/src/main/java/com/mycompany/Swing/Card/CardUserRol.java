package com.mycompany.Swing.Card;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.LuxcarForm.FormsUsuario.PopupMyUser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class CardUserRol extends javax.swing.JPanel {

    public CardUserRol() {
        initComponents();
    }
   
    public void setTextNombreRolUsuario(String nombre){
        NOMBRE.setText(nombre);
    }
    
    public void setColorBackground(Color color) {
        BACKGROUND.setBackground(color);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BACKGROUND = new com.mycompany.Swing.Panel.Panel();
        NOMBRE = new javax.swing.JLabel();

        setOpaque(false);

        NOMBRE.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        NOMBRE.setForeground(new java.awt.Color(102, 102, 102));
        NOMBRE.setText("Usuario");
        NOMBRE.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout BACKGROUNDLayout = new javax.swing.GroupLayout(BACKGROUND);
        BACKGROUND.setLayout(BACKGROUNDLayout);
        BACKGROUNDLayout.setHorizontalGroup(
            BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BACKGROUNDLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(NOMBRE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        BACKGROUNDLayout.setVerticalGroup(
            BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BACKGROUNDLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(NOMBRE, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(BACKGROUND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(BACKGROUND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Panel.Panel BACKGROUND;
    private javax.swing.JLabel NOMBRE;
    // End of variables declaration//GEN-END:variables

    
}
