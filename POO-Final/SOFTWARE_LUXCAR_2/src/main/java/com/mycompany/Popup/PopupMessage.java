/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.Popup;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.Util.Glasspanepopup.DefaultOption;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ricar
 */
public class PopupMessage extends javax.swing.JPanel {

    public PopupMessage(String Titulo, String Mensaje, int TypoDeMensaje) {
        initComponents();
        TITULO.setText(Titulo);
        MENSAJE.setText(Mensaje);
        setTypeMessage(TypoDeMensaje);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                GlassPanePopup.closePopupLast();
            }
            
            
        });
        
        
        GlassPanePopup.showPopup(this, new DefaultOption() {
            @Override
            public Color background() {
                return PANEL_COLOR_LINE.getBackground();
            }
            
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }

            @Override
            public int duration() {
                return 100;
            }

            @Override
            public float opacity() {
                return 0.04f;
            }
            
            
        });

    }

    private void setTypeMessage(int TypeMessage) {

        int SizeIcon = 60;
        switch (TypeMessage) {
            //Success
            case 0:
                PANEL_BACKGROUND.setBackground(new Color(230, 250, 245));
                PANEL_BACKGROUND.setPanel_BorderColor(new Color(0, 204, 153));
                PANEL_COLOR_LINE.setBackground(new Color(0, 204, 153));
                ICON.setIconColorFilter(new Color(0, 204, 153));
                ICON.setIcon(new FlatSVGIcon("svg/message/icon_success_message.svg", SizeIcon, SizeIcon));
                break;
            //Information
            case 1:
                PANEL_BACKGROUND.setBackground(new Color(238, 239, 255));
                PANEL_BACKGROUND.setPanel_BorderColor(new Color(84, 88, 247));
                PANEL_COLOR_LINE.setBackground(new Color(84, 88, 247));
                ICON.setIconColorFilter(new Color(84, 88, 247));
                ICON.setIcon(new FlatSVGIcon("svg/message/icon_information_message.svg", SizeIcon, SizeIcon));
                break;
            //Error
            case 2:
                PANEL_BACKGROUND.setBackground(new Color(253, 239, 239));
                PANEL_BACKGROUND.setPanel_BorderColor(new Color(235, 87, 87));
                PANEL_COLOR_LINE.setBackground(new Color(235, 87, 87));
                ICON.setIconColorFilter(new Color(235, 87, 87));
                ICON.setIcon(new FlatSVGIcon("svg/message/icon_error_message.svg", SizeIcon, SizeIcon));
                break;
            //Warning
            case 3:
                PANEL_BACKGROUND.setBackground(new Color(253, 248, 232));
                PANEL_BACKGROUND.setPanel_BorderColor(new Color(242, 201, 76));
                PANEL_COLOR_LINE.setBackground(new Color(242, 201, 76));
                ICON.setIconColorFilter(new Color(242, 201, 76));
                ICON.setIcon(new FlatSVGIcon("svg/message/icon_warning_message.svg", SizeIcon, SizeIcon));
                break;
            default:
                ICON.setIcon(new FlatSVGIcon("svg/close.svg", SizeIcon, SizeIcon));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PANEL_BACKGROUND = new com.mycompany.Swing.Panel.Panel();
        ICON = new com.mycompany.Swing.Label.LabelIcon();
        TITULO = new javax.swing.JLabel();
        MENSAJE = new javax.swing.JLabel();
        PANEL_COLOR_LINE = new com.mycompany.Swing.Panel.Panel();

        setOpaque(false);

        PANEL_BACKGROUND.setPanel_BorderActived(true);
        PANEL_BACKGROUND.setPanel_ShadowSize(3);

        ICON.setIconColorFilterActived(true);

        TITULO.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        TITULO.setForeground(new java.awt.Color(81, 81, 81));
        TITULO.setText("Titulo");

        MENSAJE.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        MENSAJE.setForeground(new java.awt.Color(51, 51, 51));
        MENSAJE.setText("Esto es un mensaje.");

        PANEL_COLOR_LINE.setPanel_Round(5);
        PANEL_COLOR_LINE.setPanel_ShadowSize(1);

        javax.swing.GroupLayout PANEL_COLOR_LINELayout = new javax.swing.GroupLayout(PANEL_COLOR_LINE);
        PANEL_COLOR_LINE.setLayout(PANEL_COLOR_LINELayout);
        PANEL_COLOR_LINELayout.setHorizontalGroup(
            PANEL_COLOR_LINELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        PANEL_COLOR_LINELayout.setVerticalGroup(
            PANEL_COLOR_LINELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PANEL_BACKGROUNDLayout = new javax.swing.GroupLayout(PANEL_BACKGROUND);
        PANEL_BACKGROUND.setLayout(PANEL_BACKGROUNDLayout);
        PANEL_BACKGROUNDLayout.setHorizontalGroup(
            PANEL_BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_BACKGROUNDLayout.createSequentialGroup()
                .addComponent(PANEL_COLOR_LINE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(PANEL_BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MENSAJE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TITULO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        PANEL_BACKGROUNDLayout.setVerticalGroup(
            PANEL_BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PANEL_COLOR_LINE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PANEL_BACKGROUNDLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PANEL_BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PANEL_BACKGROUNDLayout.createSequentialGroup()
                        .addComponent(TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MENSAJE)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PANEL_BACKGROUND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PANEL_BACKGROUND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Label.LabelIcon ICON;
    private javax.swing.JLabel MENSAJE;
    private com.mycompany.Swing.Panel.Panel PANEL_BACKGROUND;
    private com.mycompany.Swing.Panel.Panel PANEL_COLOR_LINE;
    private javax.swing.JLabel TITULO;
    // End of variables declaration//GEN-END:variables
}
