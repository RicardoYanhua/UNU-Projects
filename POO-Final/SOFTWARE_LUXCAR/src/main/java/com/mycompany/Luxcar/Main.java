package com.mycompany.Luxcar;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.DataBase.Control.ControlServicio;
import com.mycompany.DataBase.Control.ControlUsuario;
import com.mycompany.DataBase.Control.UsuarioClass;
import static com.mycompany.Luxcar.Utilidades.getImagenIconToProject;
import com.mycompany.LuxcarForm.FormActividad;
import com.mycompany.LuxcarForm.FormHome;
import com.mycompany.LuxcarForm.FormMaterial;
import com.mycompany.LuxcarForm.FormServicio;
import com.mycompany.LuxcarForm.FormTrabajador;
import com.mycompany.LuxcarForm.FormUsuario;
import com.mycompany.Popup.PopupConfirMessage;
import com.mycompany.Swing.Menu.auxiliary.ButtonItem;
import com.mycompany.Swing.Menu.auxiliary.EventMenuSelected;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.UIManager;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author ricar
 */
public class Main extends javax.swing.JFrame {

    private int[] StatePreviusWindow = {this.MAXIMIZED_BOTH};
    private static Main main;
    public static int ActivedIndex = -1;

    private static boolean ActivedMenuExpanded = false;
    public static String DNIUser = "";

    public static String getDNIUser() {
        return DNIUser;
    }

    public static Main getMain() {
        return main;
    }

    public Main() {
        initComponents();
        IncializarVentana();
        GlassPanePopup.install(this);
        InicializarWindow();
        InicializarMenu();
        InicializarButtonIcons();
        CargarServiciosEstados();
    }
    
    public void CargarServiciosEstados(){
        ControlServicio cs = new ControlServicio();
        cs.ActualizarEstadosServicio();
        cs.Disconneting();
    }

   public Main(String DNI, String NombresApellidos, String Genero) {
        this();
        DNIUser = DNI;
        CARD_USER.setIconGenero(Genero);
        CARD_USER.setTextNombreUsuario(NombresApellidos);
        setRolUser(DNI);
    }
    
    public void setRolUser(String DNI) {
        ControlUsuario cu = new ControlUsuario();
        UsuarioClass u = cu.getUsuario(DNI);
        if (u.isAdminPermision()) {
            CARD_USER_ROL.setTextNombreRolUsuario("Administrador");
        } else {
            CARD_USER_ROL.setTextNombreRolUsuario("Trabajador");
        }
        cu.Disconneting();
    }

    public void IncializarVentana() {
        setBackground(new Color(0, 0, 0, 0));
    }

    public void InicializarButtonIcons() {
        BTN_CLOSE.setIcon(
                new FlatSVGIcon("svg/close.svg", 30, 30));
        BTN_ICONIFI.setIcon(
                new FlatSVGIcon("svg/iconifi.svg", 30, 30));
        BTN_MENU.setIcon(
                new FlatSVGIcon("svg/menu_expan.svg", 40, 40));
        btn_exit_login.setIcon(
                new FlatSVGIcon("svg/exit_sesion.svg", 35, 35));
    }

    public void InicializarWindow() {
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState()) == 0) {
                    setExtendedState(StatePreviusWindow[0]);
                }
            }
        }
        );
    }

    public void InicializarMenu() {
        Menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index) {

                if ((index == 0) && (ActivedIndex != index)) {
                    MostrarPanel(new FormHome());
                } else if ((index == 1) && (ActivedIndex != index)) {
                    MostrarPanel(new FormTrabajador());
                } else if ((index == 2) && (ActivedIndex != index)) {
                    MostrarPanel(new FormUsuario());
                } else if ((index == 3) && (ActivedIndex != index)) {
                    MostrarPanel(new FormServicio());
                } else if ((index == 4) && (ActivedIndex != index)) {
                    MostrarPanel(new FormMaterial());
                } else if ((index == 5) && (ActivedIndex != index)) {
                    MostrarPanel(new FormActividad());
                }
                ActivedIndex = index;
            }
        });
        Menu.setSelectedIndex(0);
        ActivedIndex = 0;

    }

    public void MostrarPanel(Component com) {
        PanelComponents.removeAll();
        PanelComponents.add(com);
        PanelComponents.repaint();
        PanelComponents.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        PanelMenu = new com.mycompany.Swing.Panel.Panel();
        Menu = new com.mycompany.Swing.Menu.Menu();
        jPanel1 = new javax.swing.JPanel();
        background_Img2 = new com.mycompany.Swing.Background.Background_Img();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        btn_exit_login = new com.mycompany.Swing.Button.Button();
        background_Img1 = new com.mycompany.Swing.Background.Background_Img();
        jPanel3 = new javax.swing.JPanel();
        BTN_CLOSE = new com.mycompany.Swing.Button.Button();
        BTN_MENU = new com.mycompany.Swing.Button.Button();
        BTN_ICONIFI = new com.mycompany.Swing.Button.Button();
        CARD_TIME = new com.mycompany.Swing.Card.CardTime();
        CARD_USER = new com.mycompany.Swing.Card.CardUser();
        cardConnection1 = new com.mycompany.Swing.Card.CardConnection();
        CARD_USER_ROL = new com.mycompany.Swing.Card.CardUserRol();
        PanelComponents = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(96);
        jSplitPane1.setDividerSize(0);

        PanelMenu.setBackground(new java.awt.Color(16, 71, 128));
        PanelMenu.setPanel_BackgroundGradientActived(true);
        PanelMenu.setPanel_BackgroundGradientColor1(new java.awt.Color(16, 71, 128));
        PanelMenu.setPanel_BackgroundGradientColor2(new java.awt.Color(6, 51, 108));
        PanelMenu.setPanel_Round(0);
        PanelMenu.setPanel_ShadowColor(new java.awt.Color(16, 71, 128));
        PanelMenu.setPanel_ShadowOpacity(1.0F);
        PanelMenu.setPanel_ShadowSize(0);

        Menu.setBackground(new java.awt.Color(0,0,0,0)
        );
        Menu.setForeground(new java.awt.Color(0,0,0,0)
        );

        jPanel1.setBackground(new java.awt.Color(0,0,0,0));

        background_Img2.setBackground(new java.awt.Color(16, 71, 128));
        background_Img2.setBackground_Image(new javax.swing.ImageIcon(getClass().getResource("/img/IconLuxcar.jpg"))); // NOI18N
        background_Img2.setBackground_ImageOpacity(0.0F);

        javax.swing.GroupLayout background_Img2Layout = new javax.swing.GroupLayout(background_Img2);
        background_Img2.setLayout(background_Img2Layout);
        background_Img2Layout.setHorizontalGroup(
            background_Img2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        background_Img2Layout.setVerticalGroup(
            background_Img2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background_Img2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(background_Img2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(0,0,0,0));

        btn_exit_login.setBackground(new java.awt.Color(254, 229, 107));
        btn_exit_login.setButton_ActivedIconColorFilter(true);
        btn_exit_login.setButton_BackgroundColorEntered(new java.awt.Color(255, 179, 107));
        btn_exit_login.setButton_IconColorFilter(new java.awt.Color(16, 78, 128));
        btn_exit_login.setButton_Round(7);
        btn_exit_login.setButton_ShadowSize(3);
        btn_exit_login.setButton_ShawdowOpacity(0.3F);
        btn_exit_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exit_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btn_exit_login, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_exit_login, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setLeftComponent(PanelMenu);

        background_Img1.setBackground(new java.awt.Color(255, 255, 51));
        background_Img1.setBackground_Image(new javax.swing.ImageIcon(getClass().getResource("/img/FondoMain.jpg"))); // NOI18N
        background_Img1.setBackground_ImageOpacity(0.2F);
        background_Img1.setBackground_ImgMaxMin(true);

        jPanel3.setOpaque(false);

        BTN_CLOSE.setBackground(new java.awt.Color(16, 71, 128));
        BTN_CLOSE.setButton_ActivedIconColorFilter(true);
        BTN_CLOSE.setButton_BackgroundColorEntered(new java.awt.Color(26, 81, 128));
        BTN_CLOSE.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_CLOSE.setButton_Round(15);
        BTN_CLOSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CLOSEActionPerformed(evt);
            }
        });

        BTN_MENU.setButton_ActivedBackground(false);
        BTN_MENU.setButton_ActivedIconColorFilter(true);
        BTN_MENU.setButton_IconColorFilter(new java.awt.Color(16, 71, 128));
        BTN_MENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MENUActionPerformed(evt);
            }
        });

        BTN_ICONIFI.setBackground(new java.awt.Color(16, 71, 128));
        BTN_ICONIFI.setButton_ActivedIconColorFilter(true);
        BTN_ICONIFI.setButton_BackgroundColorEntered(new java.awt.Color(26, 81, 128));
        BTN_ICONIFI.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_ICONIFI.setButton_Round(15);
        BTN_ICONIFI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ICONIFIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(BTN_MENU, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                .addComponent(cardConnection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CARD_TIME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CARD_USER_ROL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CARD_USER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(BTN_ICONIFI, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BTN_CLOSE, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTN_MENU, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CARD_USER_ROL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cardConnection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CARD_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CARD_TIME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTN_ICONIFI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTN_CLOSE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        PanelComponents.setOpaque(false);
        PanelComponents.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout background_Img1Layout = new javax.swing.GroupLayout(background_Img1);
        background_Img1.setLayout(background_Img1Layout);
        background_Img1Layout.setHorizontalGroup(
            background_Img1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(background_Img1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelComponents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        background_Img1Layout.setVerticalGroup(
            background_Img1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_Img1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelComponents, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(background_Img1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1483, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AnimarJpanelSplitMenu(int Inicio, int Final, int Duracion) {
        Animator animator = new Animator(Duracion);
        animator.setResolution(5);

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                int newWidth = (int) (Inicio + fraction * (Final - Inicio));
                jSplitPane1.setDividerLocation(newWidth);
                jSplitPane1.revalidate();
                jSplitPane1.repaint();
            }
        };

        animator.addTarget(target);
        animator.start();
    }


    private void BTN_MENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MENUActionPerformed
        if (ActivedMenuExpanded) {
            AnimarJpanelSplitMenu(250, 96, 0);
            background_Img2.setBackground_Image(getImagenIconToProject("/img/IconLuxcar.jpg"));
            BTN_MENU.setIcon(new FlatSVGIcon("svg/menu_expan.svg", 30, 30));
            ButtonItem.OpenMenu = false;

        } else {
            AnimarJpanelSplitMenu(96, 250, 200);
            BTN_MENU.setIcon(new FlatSVGIcon("svg/menu_colap.svg", 30, 30));
            background_Img2.setBackground_Image(getImagenIconToProject("/img/LogoLuxcar.jpg"));
            ButtonItem.OpenMenu = true;
        }
        ActivedMenuExpanded = !ActivedMenuExpanded;
    }//GEN-LAST:event_BTN_MENUActionPerformed

    private void BTN_CLOSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CLOSEActionPerformed
        PopupConfirMessage obj = new PopupConfirMessage(
                "Confirmar salida.",
                "¿Seguro que desea cerrar la aplicación?.",
                new Color(236, 85, 101)
        );

        obj.setTituloForeground(Color.WHITE);
        obj.setIcon(new FlatSVGIcon("svg/window_close.svg", 60, 60), false);
        obj.setEventAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }//GEN-LAST:event_BTN_CLOSEActionPerformed

    private void BTN_ICONIFIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ICONIFIActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_BTN_ICONIFIActionPerformed

    private void btn_exit_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exit_loginActionPerformed
        this.dispose();
        Login log = new Login();
        log.setVisible(true);
        ActivedIndex = -1;
    }//GEN-LAST:event_btn_exit_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
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
         //FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Button.Button BTN_CLOSE;
    private com.mycompany.Swing.Button.Button BTN_ICONIFI;
    private com.mycompany.Swing.Button.Button BTN_MENU;
    private com.mycompany.Swing.Card.CardTime CARD_TIME;
    private com.mycompany.Swing.Card.CardUser CARD_USER;
    private com.mycompany.Swing.Card.CardUserRol CARD_USER_ROL;
    public static com.mycompany.Swing.Menu.Menu Menu;
    private javax.swing.JPanel PanelComponents;
    private com.mycompany.Swing.Panel.Panel PanelMenu;
    private com.mycompany.Swing.Background.Background_Img background_Img1;
    private com.mycompany.Swing.Background.Background_Img background_Img2;
    private com.mycompany.Swing.Button.Button btn_exit_login;
    private com.mycompany.Swing.Card.CardConnection cardConnection1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
