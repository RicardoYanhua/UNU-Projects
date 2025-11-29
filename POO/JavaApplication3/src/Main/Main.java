package Main;

import DataBase.Data;
import Forms.Empty;
import Forms.Home;
import Forms.Register;
import Mesaage.ConfDelete;
import Mesaage.DataBaseFailedConnection;
import Mesaage.Close;
import Mesaage.DataBaseSuccessfulConnection;
import Mesaage.ViewItem;
import Util.Glasspanepopup.DefaultOption;
import Util.Glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Clase Main
public class Main extends javax.swing.JFrame {

    //Variable que obtiene la conexion con la base de datos
    Connection conexion = Data.getConnection();

    //Timer, Tiempo de espera
    private Timer timer;

    private static Main main;

    public static Main getMain() {
        return main;
    }

    public void IncializarGlassPopup() {
        main = this;
        GlassPanePopup.install(this);
    }

    //Constructor Main
    public Main() {
        initComponents();
        
        ConfiguracionVentana_This();
        InicializarMenu();
        
        CargarLogo();
        CargarImagenBotones();
        IncializarGlassPopup();
        Conection();
    }

    private void MessageAlertData() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    Main.class.getResourceAsStream("/Main/alert_2.wav")); // Cambia la ruta por la ubicación de tu archivo de audio
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // Iniciar sonido
            clip.start();
            
            // Message Panel
            DataBaseFailedConnection obj = new DataBaseFailedConnection();
            GlassPanePopup.showPopup(obj);
            
            // Esperar hasta que el clip de audio termine de reproducirse
            while (!clip.isRunning()) {
                Thread.sleep(0);
            }
            while (clip.isRunning()) {
                Thread.sleep(0);
            }
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Conection() {
        timer = new Timer();

        // Programar la tarea para ejecutarse después de 3 segundos
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Cerrar la ventana emergente después de 3 segundos
                //GlassPanePopup.closePopupLast();
                DataBaseConnetion();

            }
        }, 1000);
    }

    private void DataBaseConnetion() {

        if (conexion == null) {
            MessageAlertData();
        } else {

            DataBaseSuccessfulConnection obj = new DataBaseSuccessfulConnection();
            GlassPanePopup.showPopup(obj);
            timer = new Timer();

            // Programar la tarea para ejecutarse después de 3 segundos
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    GlassPanePopup.closePopupLast();
                }
            }, 1500);
            
            

        }
    }

    //Carga la imagen SVG del logo
    private void CargarLogo() {
        Img_Logo.setIcon(new FlatSVGIcon("svg/ps.svg", 50, 50));

    }

    //Carga la imagenes SVG de los botones de la ventana
    private void CargarImagenBotones() {
        //Boton de configuracion
        BotonConfigurar.setIcon(new FlatSVGIcon("svg/configuration.svg", 31, 31));
        
        //Boton de Maximizar
        BotonMaximizar.setIconSVG(new FlatSVGIcon("svg/maximize.svg", 25, 25));
        BotonMaximizar.setIconColorFilter(new Color(255, 255, 255));

        //Boton de Cerrar
        BotonCerrar.setIconSVG(new FlatSVGIcon("svg/close.svg", 25, 25));
        BotonCerrar.setIconColorFilter(new Color(255, 255, 255));

        //Boton de Minimizar
        BotonMinimizar.setIconSVG(new FlatSVGIcon("svg/minimize.svg", 25, 25));
        BotonMinimizar.setIconColorFilter(new Color(255, 255, 255));
    }

    //Metodo para configurar la ventana
    private void ConfiguracionVentana_This() {
        //Elimina en color de fondo o background
        setBackground(new Color(0, 0, 0, 0));// (0 - 255)
    }

    //Metodo que carga el menu y sus botones para cada panel
    private void InicializarMenu() {
        //Carga e independiza cada boton 
        Menu.addEvent(new Menu.EventMenuSelected() {
            @Override
            public void menuSelected(int index) {
                if (index == 0) {
                    MostarPanel(new Home());
                } else if (index == 1) {
                    MostarPanel(new Register());
                } else {
                    MostarPanel(new Empty(index + " "));
                }
            }
        });

        //Inicializa el panel con el primer boton 0 - "Home"
        Menu.setSelectedIndex(0);
    }

    //Metodo para reemplazar y mostrar un nuevo panel
    private void MostarPanel(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_Img1 = new Swing.Background.Background_Img();
        body = new javax.swing.JPanel();
        BotonCerrar = new Swing.JButton.JButton();
        BotonMinimizar = new Swing.JButton.JButton();
        jPanel1 = new javax.swing.JPanel();
        BotonConfigurar = new Swing.JButton.JButton();
        jPanel2 = new javax.swing.JPanel();
        Img_Logo = new javax.swing.JLabel();
        Menu = new Menu.Menu_2();
        BotonMaximizar = new Swing.JButton.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        background_Img1.setBackground(new java.awt.Color(240, 240, 255));
        background_Img1.setBackground_BorderActived(true);
        background_Img1.setBackground_BorderColor(new java.awt.Color(0, 0, 0));
        background_Img1.setBackground_GradientColor1(new java.awt.Color(73, 73, 73));
        background_Img1.setBackground_GradientColor2(new java.awt.Color(43, 53, 77));
        background_Img1.setBackground_Round(0);

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        BotonCerrar.setBackground(new java.awt.Color(255, 102, 102));
        BotonCerrar.setButton_ShadowColor(new java.awt.Color(255, 51, 51));
        BotonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarActionPerformed(evt);
            }
        });

        BotonMinimizar.setBackground(new java.awt.Color(102, 102, 102));
        BotonMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        BotonMinimizar.setButton_ShadowColor(new java.awt.Color(0, 0, 0));
        BotonMinimizar.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        BotonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMinimizarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(29, 28, 34));

        BotonConfigurar.setButton_BorderColor(new java.awt.Color(255, 255, 255));
        BotonConfigurar.setButton_RippleColor(new java.awt.Color(51, 153, 255));
        BotonConfigurar.setButton_Round(15);
        BotonConfigurar.setButton_ShadowColor(new java.awt.Color(255, 255, 255));
        BotonConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfigurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(BotonConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(BotonConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(38, 39, 57));

        Img_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Img_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Img_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(38, 39, 57));
        Menu.setForeground(new java.awt.Color(29, 28, 34));

        BotonMaximizar.setBackground(new java.awt.Color(102, 102, 102));
        BotonMaximizar.setForeground(new java.awt.Color(255, 255, 255));
        BotonMaximizar.setButton_ShadowColor(new java.awt.Color(0, 0, 0));
        BotonMaximizar.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        BotonMaximizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMaximizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background_Img1Layout = new javax.swing.GroupLayout(background_Img1);
        background_Img1.setLayout(background_Img1Layout);
        background_Img1Layout.setHorizontalGroup(
            background_Img1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_Img1Layout.createSequentialGroup()
                .addGroup(background_Img1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(background_Img1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_Img1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1610, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        background_Img1Layout.setVerticalGroup(
            background_Img1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_Img1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(background_Img1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(BotonMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(BotonMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(background_Img1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(background_Img1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed

        Close obj = new Close();
        
        GlassPanePopup.showPopup(obj);

    }//GEN-LAST:event_BotonCerrarActionPerformed

    private void BotonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMinimizarActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_BotonMinimizarActionPerformed

    private void BotonConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfigurarActionPerformed

        
        
    }//GEN-LAST:event_BotonConfigurarActionPerformed

    private void BotonMaximizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMaximizarActionPerformed
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }//GEN-LAST:event_BotonMaximizarActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.JButton.JButton BotonCerrar;
    private Swing.JButton.JButton BotonConfigurar;
    private Swing.JButton.JButton BotonMaximizar;
    private Swing.JButton.JButton BotonMinimizar;
    private javax.swing.JLabel Img_Logo;
    private Menu.Menu_2 Menu;
    private Swing.Background.Background_Img background_Img1;
    private javax.swing.JPanel body;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
