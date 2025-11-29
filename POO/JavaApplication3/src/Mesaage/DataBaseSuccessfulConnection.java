package Mesaage;

import Util.Glasspanepopup.DefaultOption;
import Util.Glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.util.Timer;
import java.util.TimerTask;

public class DataBaseSuccessfulConnection extends javax.swing.JPanel {

    private Timer timer;

    public DataBaseSuccessfulConnection() {
        initComponents();
        setOpaque(false);
        Icono.setIcon(new FlatSVGIcon("svg/database_exito.svg", 85, 85));
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

        setBackground(new java.awt.Color(255, 81, 81));
        setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPanel_BackgroundGradientActived(true);
        jPanel2.setPanel_BackgroundGradientColor1(new java.awt.Color(204, 0, 255));
        jPanel2.setPanel_BackgroundGradientColor2(new java.awt.Color(102, 102, 255));
        jPanel2.setPanel_Round(50);
        jPanel2.setPanel_ShadowColor(new java.awt.Color(255, 153, 255));
        jPanel2.setPanel_ShadowOpacity(0.3F);
        jPanel2.setPanel_ShadowSize(10);

        Icono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txt_name.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setText("SQL");

        lbTitle.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("¡ Conexion Exitosa !");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Icono, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTitle)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txt_name)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Icono, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lbTitle)))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(873, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(836, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(500, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(501, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icono;
    private Swing.Panel.JPanel jPanel2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel txt_name;
    // End of variables declaration//GEN-END:variables
}
