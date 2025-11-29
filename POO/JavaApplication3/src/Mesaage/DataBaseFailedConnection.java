package Mesaage;

import Util.Glasspanepopup.DefaultOption;
import Util.Glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.util.Timer;
import java.util.TimerTask;

public class DataBaseFailedConnection extends javax.swing.JPanel {

    private Timer timer;

    public DataBaseFailedConnection() {
        initComponents();
        setOpaque(false);
        Icono.setIcon(new FlatSVGIcon("svg/database_error.svg", 90, 90));
/*
        // Crear un temporizador
        timer = new Timer();

        // Programar la tarea para ejecutarse después de 3 segundos
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Cerrar la ventana emergente después de 3 segundos
                GlassPanePopup.closePopupLast();

            }
        }, 3000);*/
    }

    /*
    // Método para cancelar el temporizador
    private void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null; // Liberar la referencia al objeto Timer
        }
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new Swing.Panel.JPanel();
        Icono = new javax.swing.JLabel();
        txt_name = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        Entendido = new Swing.JButton.JButton();

        setBackground(new java.awt.Color(255, 81, 81));
        setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPanel_BackgroundGradientActived(true);
        jPanel2.setPanel_BackgroundGradientColor1(new java.awt.Color(255, 51, 102));
        jPanel2.setPanel_BackgroundGradientColor2(new java.awt.Color(255, 51, 51));
        jPanel2.setPanel_Round(50);
        jPanel2.setPanel_ShadowColor(new java.awt.Color(255, 102, 102));
        jPanel2.setPanel_ShadowSize(15);

        Icono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txt_name.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setText("ERROR - SQL");

        lbTitle.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("No se pudo conectar con la base de datos.");

        Entendido.setForeground(new java.awt.Color(51, 51, 51));
        Entendido.setText("Entendido");
        Entendido.setButton_Round(30);
        Entendido.setButton_ShadowColor(new java.awt.Color(255, 255, 255));
        Entendido.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Entendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntendidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Icono, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTitle)
                    .addComponent(Entendido, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lbTitle)
                        .addGap(18, 18, 18)
                        .addComponent(Entendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txt_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Icono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(787, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(750, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(500, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(501, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EntendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntendidoActionPerformed
        //cancelTimer();
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_EntendidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.JButton.JButton Entendido;
    private javax.swing.JLabel Icono;
    private Swing.Panel.JPanel jPanel2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel txt_name;
    // End of variables declaration//GEN-END:variables
}
