package com.mycompany.Luxcar;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ControlUsuario;
import com.mycompany.DataBase.Control.TrabajadorClass;
import com.mycompany.Popup.PopupMessage;
import com.mycompany.Swing.TextField.Filter.TxtIntegerSize;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ricar
 */
public class Login extends javax.swing.JFrame {

    private ControlUsuario DataUsuario;
    private boolean Reconecting = false;
    private boolean ShowDisconneting = false;

    private Timer TimerVerificarConexion;

    public Login() {
        initComponents();
        InicializarVentana();
        InicializarConexion();
        GlassPanePopup.install(this);
        CargarIconosDeBotones();
        TimerVerificarConexion();
        IncializarTxtFilterDocuments();

    }
    
    public void IncializarTxtFilterDocuments(){
        DNI.setDocument(new TxtIntegerSize(8){});
    }

    public String getDNIUsuario() {
        return DNI.getText();
    }

    public String getContraseñaUsuario() {
        return CONTRASEÑA.getText();
    }

    public void InicializarConexion() {
        DataUsuario = new ControlUsuario();
    }

    public void InicializarVentana() {
        setBackground(new Color(0, 0, 0, 0));
        InhabilitarIconificar();
    }

    public void TimerVerificarConexion() {
        TimerVerificarConexion = new Timer(true);
        TimerVerificarConexion.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Connection();
            }
        }, 0, 10 * 1000);
    }

    public void DetenerTimerDeConexion() {
        if (TimerVerificarConexion != null) {
            TimerVerificarConexion.cancel();
            TimerVerificarConexion = null;
        }
    }

    public void Connection() {
        if (DataUsuario.isConnecting()) {
            if (Reconecting) {
                if (ShowDisconneting) {
                    MostrarMensajeConexion();
                    ShowDisconneting = false;
                }
                Reconecting = false;
            }
        } else {
            if (!Reconecting) {
                MostrarMensajeDesconexion();
                ShowDisconneting = true;
                Reconecting = true;
            } else {
                DataUsuario.Reconnecting();
            }
        }
    }

    public void MostrarMensajeConexion() {
        GlassPanePopup.closePopupLast();
        new PopupMessage(
                "CONECTADO",
                "¡ Usted tiene conexion con la base de datos !.",
                0);
    }

    public void MostrarMensajeDesconexion() {
        GlassPanePopup.closePopupLast();
        new PopupMessage(
                "DESCONECTADO",
                "Verifique su conexion con la base de datos.",
                2);
    }

    public void InhabilitarIconificar() {
        this.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED) {
                    setState(Frame.NORMAL);
                }
            }
        }
        );
    }

    public void CargarIconosDeBotones() {
        BTN_VIEW_PASSWORD.setIcon(
                new FlatSVGIcon("svg/no_ver_contraseña.svg", 25, 25));
        BTN_CERRAR_WINDOWSESION.setIcon(
                new FlatSVGIcon("svg/close.svg", 25, 25));
        DNI.setIcon(
                new FlatSVGIcon("svg/user.svg", 20, 20));
        CONTRASEÑA.setIcon(
                new FlatSVGIcon("svg/passwordkey.svg", 20, 20));
    }

    public boolean ValidarDatosDeSesion() {
        if (getDNIUsuario().equals("")) {
            new PopupMessage(
                    "DNI USUARIO",
                    "Debe ingresar un DNI para iniciar sesion.",
                    2
            );
            return false;
        } else if (getContraseñaUsuario().equals("")) {
            new PopupMessage(
                    "CONTRASEÑA USUARIO",
                    "Debe ingresar su contraseña de usuario para iniciar sesion.",
                    2
            );
            return false;
        } else {
            return true;
        }
    }

    public boolean ValidarDatosDeUsuario() {

        if (DataUsuario.IsExistUsuario(getDNIUsuario(), getContraseñaUsuario())) {
            return true;
        } else {
            new PopupMessage(
                    "DNI Y CONTRASEÑA",
                    "Los datos de usuario no existen en la base de datos.",
                    2
            );
            return false;
        }

    }

    public void InitMainMenu() {
        TrabajadorClass Trabajador = DataUsuario.getUserTrabajador(getDNIUsuario());

        Main window;
        if (Trabajador != null) {
            window = new Main(getDNIUsuario(),Trabajador.getNombresApellidos(), Trabajador.getGenero());
        } else {
            window = new Main("","Usuario invitado", "");
        }

        this.dispose();
        window.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_Img1 = new com.mycompany.Swing.Background.Background_Img();
        BTN_CERRAR_WINDOWSESION = new com.mycompany.Swing.Button.Button();
        BTN_VIEW_PASSWORD = new com.mycompany.Swing.Button.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DNI = new com.mycompany.Swing.TextField.TextField();
        CONTRASEÑA = new com.mycompany.Swing.TextField.PasswordField();
        button4 = new com.mycompany.Swing.Button.Button();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background_Img1.setBackground(new java.awt.Color(204, 204, 204));
        background_Img1.setBackground_Image(new javax.swing.ImageIcon(getClass().getResource("/img/FondoLogin.jpg"))); // NOI18N
        background_Img1.setBackground_ImageOpacity(0.1F);
        background_Img1.setBackground_ImgMaxMin(true);
        background_Img1.setBackground_Round(7);
        background_Img1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN_CERRAR_WINDOWSESION.setBackground(new java.awt.Color(255, 51, 51));
        BTN_CERRAR_WINDOWSESION.setButton_ActivedIconColorFilter(true);
        BTN_CERRAR_WINDOWSESION.setButton_BackgroundColorEntered(new java.awt.Color(255, 71, 71));
        BTN_CERRAR_WINDOWSESION.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_CERRAR_WINDOWSESION.setButton_Round(10);
        BTN_CERRAR_WINDOWSESION.setButton_ShadowColor(new java.awt.Color(255, 51, 51));
        BTN_CERRAR_WINDOWSESION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CERRAR_WINDOWSESIONActionPerformed(evt);
            }
        });
        background_Img1.add(BTN_CERRAR_WINDOWSESION, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 50, 50));

        BTN_VIEW_PASSWORD.setButton_ActivedBackground(false);
        BTN_VIEW_PASSWORD.setButton_ActivedIconColorFilter(true);
        BTN_VIEW_PASSWORD.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_VIEW_PASSWORD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN_VIEW_PASSWORDMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BTN_VIEW_PASSWORDMouseReleased(evt);
            }
        });
        background_Img1.add(BTN_VIEW_PASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 40, 40));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        background_Img1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI");
        background_Img1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 30));

        DNI.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        DNI.setTextField_BorderActived(true);
        DNI.setTextField_Round(7);
        DNI.setTextField_ShadowColor(new java.awt.Color(220, 220, 220));
        DNI.setTextField_ShadowSize(3);
        DNI.setTextField_Txthint("DNI Usuario.");
        DNI.setTextField_TxthintColor(new java.awt.Color(204, 204, 204));
        DNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DNIActionPerformed(evt);
            }
        });
        background_Img1.add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 210, 40));

        CONTRASEÑA.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        CONTRASEÑA.setTextField_BorderActived(true);
        CONTRASEÑA.setTextField_Round(7);
        CONTRASEÑA.setTextField_ShadowColor(new java.awt.Color(220, 220, 220));
        CONTRASEÑA.setTextField_ShadowSize(3);
        CONTRASEÑA.setTextField_Txthint("Contraseña ususario.");
        CONTRASEÑA.setTextField_TxthintColor(new java.awt.Color(204, 204, 204));
        CONTRASEÑA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONTRASEÑAActionPerformed(evt);
            }
        });
        background_Img1.add(CONTRASEÑA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 210, 40));

        button4.setBackground(new java.awt.Color(251, 224, 39));
        button4.setForeground(new java.awt.Color(102, 102, 102));
        button4.setText("Ingresar");
        button4.setButton_BackgroundColorEntered(new java.awt.Color(255, 234, 49));
        button4.setButton_Round(10);
        button4.setButton_ShadowColor(new java.awt.Color(255, 255, 0));
        button4.setButton_ShadowSize(3);
        button4.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        button4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        background_Img1.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 120, 50));
        background_Img1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 230, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(background_Img1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(background_Img1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CERRAR_WINDOWSESIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CERRAR_WINDOWSESIONActionPerformed
        DetenerTimerDeConexion();
        DataUsuario.Disconneting();
        System.exit(0);
    }//GEN-LAST:event_BTN_CERRAR_WINDOWSESIONActionPerformed

    private void BTN_VIEW_PASSWORDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_VIEW_PASSWORDMousePressed
        BTN_VIEW_PASSWORD.setIcon(new FlatSVGIcon("svg/ver_contraseña.svg", 25, 25));
        CONTRASEÑA.setEchoChar((char) 0);
    }//GEN-LAST:event_BTN_VIEW_PASSWORDMousePressed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed

        if (!DataUsuario.isConnecting()) {
            MostrarMensajeDesconexion();
        } else if (ValidarDatosDeSesion() && ValidarDatosDeUsuario()) {
            InitMainMenu();
            DetenerTimerDeConexion();
            DataUsuario.Disconneting();
        }


    }//GEN-LAST:event_button4ActionPerformed

    private void BTN_VIEW_PASSWORDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_VIEW_PASSWORDMouseReleased
        BTN_VIEW_PASSWORD.setIcon(new FlatSVGIcon("svg/no_ver_contraseña.svg", 25, 25));
        CONTRASEÑA.setEchoChar('•');
    }//GEN-LAST:event_BTN_VIEW_PASSWORDMouseReleased

    private void CONTRASEÑAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTRASEÑAActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_CONTRASEÑAActionPerformed

    private void DNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DNIActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Button.Button BTN_CERRAR_WINDOWSESION;
    private com.mycompany.Swing.Button.Button BTN_VIEW_PASSWORD;
    private com.mycompany.Swing.TextField.PasswordField CONTRASEÑA;
    private com.mycompany.Swing.TextField.TextField DNI;
    private com.mycompany.Swing.Background.Background_Img background_Img1;
    private com.mycompany.Swing.Button.Button button4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
