package com.mycompany.Popup;

import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.Util.Glasspanepopup.DefaultOption;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class PopupConfirMessage extends JPanel {

    public PopupConfirMessage() {
        initComponents();
    }

    public PopupConfirMessage(String Titulo, String Mensaje, Color ColorPanel) {
        this();

        TITTLE.setText(Titulo);
        MESSAGE.setText(Mensaje);
        PANEL_COLOR.setBackground(ColorPanel);

        GlassPanePopup.showPopup(this, new DefaultOption() {
            @Override
            public Color background() {
                return new Color(0, 0, 0);
            }

        });
    }

    public void setIcon(FlatSVGIcon icon, boolean ActivedFilter) {
        ICON.setIconColorFilterActived(ActivedFilter);
        ICON.setIcon(icon);
    }
    public void setIcon_ColorFilter(Color c) {
        ICON.setIconColorFilter(c);
    }

    public String getCodigo() {
        return CODIGO.getText();
    }

    public void setCodigo(String txt) {
        CODIGO.setText(txt);
    }

    public Color getCodigoForeground() {
        return CODIGO.getForeground();
    }

    public void setCodigoForeground(Color c) {
        CODIGO.setForeground(c);
    }

    public Color getTituloForeground(){
        return TITTLE.getForeground();
    }
    public void setTituloForeground(Color c) {
        TITTLE.setForeground(c);
    }

    public void setEventAction(ActionListener event) {
        CONFIR.addActionListener(event);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BACKGROUND = new com.mycompany.Swing.Panel.Panel();
        MESSAGE = new javax.swing.JLabel();
        CONFIR = new com.mycompany.Swing.Button.Button();
        button2 = new com.mycompany.Swing.Button.Button();
        ICON = new com.mycompany.Swing.Label.LabelIcon();
        PANEL_COLOR = new com.mycompany.Swing.Panel.Panel();
        TITTLE = new javax.swing.JLabel();
        CODIGO = new javax.swing.JLabel();

        setOpaque(false);

        BACKGROUND.setPanel_Round(7);
        BACKGROUND.setPanel_ShadowColor(new java.awt.Color(0, 0, 0));
        BACKGROUND.setPanel_ShadowOpacity(0.3F);
        BACKGROUND.setPanel_ShadowSize(3);

        MESSAGE.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        MESSAGE.setForeground(new java.awt.Color(51, 51, 51));
        MESSAGE.setText("Esto es un mensaje.");

        CONFIR.setBackground(new java.awt.Color(102, 255, 102));
        CONFIR.setText("Confirmar");
        CONFIR.setButton_BackgroundColorEntered(new java.awt.Color(122, 255, 122));
        CONFIR.setButton_Round(10);
        CONFIR.setButton_ShadowColor(new java.awt.Color(102, 255, 102));
        CONFIR.setButton_ShadowSize(3);

        button2.setText("Cancelar");
        button2.setButton_Round(10);
        button2.setButton_ShadowSize(3);
        button2.setButton_ShawdowOpacity(0.4F);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        PANEL_COLOR.setPanel_Round(7);
        PANEL_COLOR.setPanel_ShadowColor(getBackground());
        PANEL_COLOR.setPanel_ShadowOpacity(0.3F);
        PANEL_COLOR.setPanel_ShadowSize(3);

        TITTLE.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        TITTLE.setForeground(new java.awt.Color(81, 81, 81));
        TITTLE.setText("Titulo");

        CODIGO.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        CODIGO.setForeground(new java.awt.Color(153, 153, 153));
        CODIGO.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout PANEL_COLORLayout = new javax.swing.GroupLayout(PANEL_COLOR);
        PANEL_COLOR.setLayout(PANEL_COLORLayout);
        PANEL_COLORLayout.setHorizontalGroup(
            PANEL_COLORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_COLORLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(TITTLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CODIGO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        PANEL_COLORLayout.setVerticalGroup(
            PANEL_COLORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_COLORLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PANEL_COLORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TITTLE)
                    .addComponent(CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout BACKGROUNDLayout = new javax.swing.GroupLayout(BACKGROUND);
        BACKGROUND.setLayout(BACKGROUNDLayout);
        BACKGROUNDLayout.setHorizontalGroup(
            BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BACKGROUNDLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BACKGROUNDLayout.createSequentialGroup()
                        .addComponent(ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MESSAGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BACKGROUNDLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CONFIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addComponent(PANEL_COLOR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BACKGROUNDLayout.setVerticalGroup(
            BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BACKGROUNDLayout.createSequentialGroup()
                .addComponent(PANEL_COLOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MESSAGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CONFIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(BACKGROUND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(BACKGROUND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
    }//GEN-LAST:event_button3ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Panel.Panel BACKGROUND;
    private javax.swing.JLabel CODIGO;
    private com.mycompany.Swing.Button.Button CONFIR;
    private com.mycompany.Swing.Label.LabelIcon ICON;
    private javax.swing.JLabel MESSAGE;
    private com.mycompany.Swing.Panel.Panel PANEL_COLOR;
    private javax.swing.JLabel TITTLE;
    private com.mycompany.Swing.Button.Button button2;
    // End of variables declaration//GEN-END:variables
}
