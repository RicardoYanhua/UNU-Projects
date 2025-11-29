package com.mycompany.LuxcarForm.FormsServicio;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ControlServicio;
import com.mycompany.DataBase.Control.ServicioClass;
import com.mycompany.Luxcar.Utilidades;
import com.mycompany.LuxcarForm.FormServicio;
import com.mycompany.Popup.PopupMessage;
import com.mycompany.Util.Glasspanepopup.DefaultOption;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ricar
 */
public class PopupgetDate extends javax.swing.JPanel {

    public ControlServicio DataServicio;

    public PopupgetDate() {
        initComponents();
        IniciarConexion();
        InicializarIconos();
        GlassPanePopup.showPopup(this, new DefaultOption() {
            @Override
            public Color background() {
                return new Color(0, 0, 0);
            }

            @Override
            public int duration() {
                return 100;
            }
             @Override
            public float opacity() {
                return 0.5f;
            }

        });

    }

    public void IniciarConexion() {
        DataServicio = new ControlServicio();
    }

    public void InicializarIconos() {
        TITTLE.setIcon(new FlatSVGIcon("svg/service.svg", 60, 60));
    }

    public void setEventAction(ActionListener event) {
        BTN_ACTION.addActionListener(event);
    }

    public LocalDateTime getFechaFinalizacion() {
        LocalDate date = Utilidades.getFechaSpinnerx3_dd_StringMes_yyyy(
                DIA.getValue().toString(),
                MES.getValue().toString(),
                AÑO.getValue().toString());

        return Utilidades.getDateTime(
                date,
                HORA.getValue().toString(),
                MINUTO.getValue().toString()
        );
    }

    public void setenabledbutton(boolean bol) {
        BTN_ACTION.setEnabled(bol);
    }

    public boolean ValidarDatos() {
        if (getFechaFinalizacion() == null) {
            new PopupMessage("FECHA DE FINALIZACION", "La fecha es invalido.", 3);
            return false;
        } else {
            return true;
        }

    }

    void VerificarHoraAttemps() {
        if (Integer.parseInt(HORA.getValue().toString()) >= 12) {
            ampm.setText("P.M.");
        } else {
            ampm.setText("A.M.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel2 = new com.mycompany.Swing.Panel.Panel();
        panel4 = new com.mycompany.Swing.Panel.Panel();
        HORA = new com.mycompany.Swing.Spinner.SpinnerHora();
        MINUTO = new com.mycompany.Swing.Spinner.SpinnerMinuto();
        ampm = new javax.swing.JLabel();
        ampm1 = new javax.swing.JLabel();
        panel6 = new com.mycompany.Swing.Panel.Panel();
        DIA = new com.mycompany.Swing.Spinner.SpinnerDia();
        MES = new com.mycompany.Swing.Spinner.SpinnerMes();
        AÑO = new com.mycompany.Swing.Spinner.SpinnerAño();
        BTN_ACTION = new com.mycompany.Swing.Button.Button();
        BACKGROUND = new com.mycompany.Swing.Panel.Panel();
        TITTLE = new com.mycompany.Swing.Label.LabelIcon();
        jLabel1 = new javax.swing.JLabel();
        button3 = new com.mycompany.Swing.Button.Button();

        setOpaque(false);

        panel2.setPanel_BackgroundGradientActived(true);
        panel2.setPanel_BackgroundGradientColor2(new java.awt.Color(255, 255, 255));
        panel2.setPanel_BorderActived(true);
        panel2.setPanel_ShadowOpacity(0.3F);
        panel2.setPanel_ShadowSize(3);
        panel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel2MouseEntered(evt);
            }
        });

        panel4.setPanel_BackgroundGradientColor1(new java.awt.Color(250, 250, 255));
        panel4.setPanel_BackgroundGradientColor2(new java.awt.Color(230, 230, 255));
        panel4.setPanel_BorderActived(true);
        panel4.setPanel_BorderColor(new java.awt.Color(204, 204, 204));
        panel4.setPanel_Round(7);
        panel4.setPanel_ShadowOpacity(0.3F);
        panel4.setPanel_ShadowSize(3);
        panel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel4MouseExited(evt);
            }
        });
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HORA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HORAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HORAMouseExited(evt);
            }
        });
        panel4.add(HORA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 50));
        panel4.add(MINUTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 80, 50));

        ampm.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        ampm.setText("A.M.");
        panel4.add(ampm, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 50, 50));

        ampm1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        ampm1.setText(":");
        panel4.add(ampm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 10, 50));

        panel6.setPanel_BackgroundGradientColor1(new java.awt.Color(250, 250, 255));
        panel6.setPanel_BackgroundGradientColor2(new java.awt.Color(240, 240, 255));
        panel6.setPanel_BorderActived(true);
        panel6.setPanel_BorderColor(new java.awt.Color(204, 204, 204));
        panel6.setPanel_Round(7);
        panel6.setPanel_ShadowOpacity(0.3F);
        panel6.setPanel_ShadowSize(3);
        panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel6.add(DIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 50));
        panel6.add(MES, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 50));
        panel6.add(AÑO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 50));

        BTN_ACTION.setBackground(new java.awt.Color(15, 71, 128));
        BTN_ACTION.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ACTION.setText("Confirmar fecha");
        BTN_ACTION.setButton_ActivedIconColorFilter(true);
        BTN_ACTION.setButton_BackgroundColorEntered(new java.awt.Color(25, 81, 128));
        BTN_ACTION.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_ACTION.setButton_Round(15);
        BTN_ACTION.setButton_ShadowColor(new java.awt.Color(15, 71, 128));
        BTN_ACTION.setButton_ShadowSize(3);
        BTN_ACTION.setButton_ShawdowOpacity(0.0F);
        BTN_ACTION.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        BTN_ACTION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ACTIONActionPerformed(evt);
            }
        });

        BACKGROUND.setBackground(new java.awt.Color(16, 78, 128));
        BACKGROUND.setPanel_BackgroundGradientActived(true);
        BACKGROUND.setPanel_BackgroundGradientColor1(new java.awt.Color(16, 78, 128));
        BACKGROUND.setPanel_BackgroundGradientColor2(new java.awt.Color(36, 98, 128));
        BACKGROUND.setPanel_ShadowOpacity(0.3F);
        BACKGROUND.setPanel_ShadowSize(3);

        TITTLE.setForeground(new java.awt.Color(255, 255, 255));
        TITTLE.setText("Fecha de finalizacion");
        TITTLE.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        TITTLE.setIconColorFilterActived(true);

        javax.swing.GroupLayout BACKGROUNDLayout = new javax.swing.GroupLayout(BACKGROUND);
        BACKGROUND.setLayout(BACKGROUNDLayout);
        BACKGROUNDLayout.setHorizontalGroup(
            BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BACKGROUNDLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(TITTLE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BACKGROUNDLayout.setVerticalGroup(
            BACKGROUNDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BACKGROUNDLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TITTLE, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(36, 98, 128));
        jLabel1.setText("Fecha y hora");

        button3.setText("Cancelar");
        button3.setButton_Round(15);
        button3.setButton_ShadowSize(3);
        button3.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BACKGROUND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_ACTION, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(BACKGROUND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_ACTION, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel2MouseEntered
        VerificarHoraAttemps();
    }//GEN-LAST:event_panel2MouseEntered

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        button3.setEnabled(false);
        DataServicio.Disconneting();
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_button3ActionPerformed

    private void BTN_ACTIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ACTIONActionPerformed

    }//GEN-LAST:event_BTN_ACTIONActionPerformed

    private void panel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel4MouseExited
        VerificarHoraAttemps();
    }//GEN-LAST:event_panel4MouseExited

    private void panel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel4MouseEntered
        VerificarHoraAttemps();
    }//GEN-LAST:event_panel4MouseEntered

    private void HORAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HORAMouseExited
        VerificarHoraAttemps();
    }//GEN-LAST:event_HORAMouseExited

    private void HORAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HORAMouseEntered
        VerificarHoraAttemps();
    }//GEN-LAST:event_HORAMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Spinner.SpinnerAño AÑO;
    private com.mycompany.Swing.Panel.Panel BACKGROUND;
    private com.mycompany.Swing.Button.Button BTN_ACTION;
    private com.mycompany.Swing.Spinner.SpinnerDia DIA;
    private com.mycompany.Swing.Spinner.SpinnerHora HORA;
    private com.mycompany.Swing.Spinner.SpinnerMes MES;
    private com.mycompany.Swing.Spinner.SpinnerMinuto MINUTO;
    private com.mycompany.Swing.Label.LabelIcon TITTLE;
    private javax.swing.JLabel ampm;
    private javax.swing.JLabel ampm1;
    private com.mycompany.Swing.Button.Button button3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private com.mycompany.Swing.Panel.Panel panel2;
    private com.mycompany.Swing.Panel.Panel panel4;
    private com.mycompany.Swing.Panel.Panel panel6;
    // End of variables declaration//GEN-END:variables
}
