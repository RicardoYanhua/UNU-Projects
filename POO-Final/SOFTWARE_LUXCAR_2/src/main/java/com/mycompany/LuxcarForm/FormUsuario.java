package com.mycompany.LuxcarForm;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ControlTrabajador;
import com.mycompany.DataBase.Control.ControlUsuario;
import com.mycompany.DataBase.Control.TrabajadorClass;
import com.mycompany.DataBase.Control.UsuarioClass;
import com.mycompany.Luxcar.Main;
import com.mycompany.LuxcarForm.FormsUsuario.PopupCambiarContraseña;
import com.mycompany.LuxcarForm.FormsUsuario.PopupCrearUsuario;
import com.mycompany.Popup.PopupConfirMessage;
import com.mycompany.Popup.PopupMessage;
import com.mycompany.Swing.TextField.Filter.TxtUpper;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class FormUsuario extends javax.swing.JPanel {

    public static ControlUsuario DataUsuario;
    public int ActtionBusqueda = 1;

    public FormUsuario() {
        initComponents();
        IniciarConexion();
        InicializarTabla();
        InicializarIcons();
        IncializarEventCardUsuarioTrabajador();
        IncializarEventCardUsuarioNoTrabajador();
        MostrarUsuarioBusqueda();
        getCountUsers();
        InicializarTXTDocuments();
        CARD_U_TRABAJADORES.setvisibleBTN(false);
        CARD_U__NO_TRABAJADORES.setvisibleBTN(true);

    }

    public void InicializarTXTDocuments() {
        TXT_BUSQUEDA.setDocument(new TxtUpper() {
        });
    }

    public void getCountUsers() {
        CARD_U_TRABAJADORES.setCardTextNumero(
                String.valueOf(DataUsuario.getTotalUsuariosTrabajadores()
                )
        );
        CARD_U_TRABAJADORES.setCardActivedFilter();
        CARD_U_TRABAJADORES.setCardIcon(new FlatSVGIcon("svg/worker.svg", 80, 80));
        CARD_U__NO_TRABAJADORES.setCardTextNumero(
                String.valueOf(DataUsuario.getTotalUsuariosTrabajadoresSinUsuario()
                )
        );
        CARD_U__NO_TRABAJADORES.setCardActivedFilter();
        CARD_U__NO_TRABAJADORES.setCardIcon(new FlatSVGIcon("svg/worker.svg", 80, 80));
        
    }

    public void MostrarUsuarioBusqueda() {
        if (ActtionBusqueda == 1) {
            DataUsuario.MostrarBusquedaDeUsuarioTrabajador(TXT_BUSQUEDA.getText());
        } else if (ActtionBusqueda == 2) {
            DataUsuario.MostrarBusquedaDeTrabajadorSinUsuario(TXT_BUSQUEDA.getText());
        }
        DesactivarTodosLosBotones();
        VerificarQuitarUserLogin((DefaultTableModel) TABLA.getModel());

    }

    public void DesactivarTodosLosBotones() {
        BTN_AGREGAR_USUSARIO.setEnabled(false);
        BTN_ELIMINAR.setEnabled(false);
        BTN_CAMBIAR_CONTRASEÑA.setEnabled(false);
        BTN_ROL_ADMIN.setEnabled(false);
        BTN_QUITAR_ADMIN.setEnabled(false);
    }

    public void IncializarEventCardUsuarioTrabajador() {
        CARD_U_TRABAJADORES.setActionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActtionBusqueda = 1;
                CARD_U_TRABAJADORES.setvisibleBTN(false);
                CARD_U__NO_TRABAJADORES.setvisibleBTN(true);
                MostrarUsuarioBusqueda();
                TITULO_BUSQUEDA.setText("BUSCAR USUSARIO TRABAJADOR");

            }
        });

    }

    public void IncializarEventCardUsuarioNoTrabajador() {
        CARD_U__NO_TRABAJADORES.setActionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActtionBusqueda = 2;
                CARD_U_TRABAJADORES.setvisibleBTN(true);
                CARD_U__NO_TRABAJADORES.setvisibleBTN(false);
                MostrarUsuarioBusqueda();
                TITULO_BUSQUEDA.setText("BUSCAR TRABAJADOR SIN USUARIO");

            }
        });

    }

    public void IniciarConexion() {
        DataUsuario = new ControlUsuario();
    }

    public void InicializarIcons() {
        TXT_BUSQUEDA.setIcon(
                new FlatSVGIcon("svg/buscar.svg", 25, 25));
        BTN_CAMBIAR_CONTRASEÑA.setIcon(
                new FlatSVGIcon("svg/user_edit.svg", 25, 25));
        BTN_ELIMINAR.setIcon(
                new FlatSVGIcon("svg/user_delete.svg", 25, 25));

    }

    public void VerificarQuitarUserLogin(DefaultTableModel ListaDeUsuarios) {

        for (int i = ListaDeUsuarios.getRowCount() - 1; i >= 0; i--) {
            for (int j = 0; j < 1; j++) {
                if (ListaDeUsuarios.getValueAt(i, 0).equals(Main.getDNIUser())) { // Comparando DNI
                    ListaDeUsuarios.removeRow(i); // Eliminar la fila
                    break;
                }
            }
        }
        TABLA.setModel(ListaDeUsuarios);
    }

    public void InicializarTabla() {

        String TextHeader[] = {
            "DNI",
            "Nombre de Usuario",
            "ROL"
        };
        TABLA.setHorizontalTextPositionHeader(new int[]{
            SwingConstants.CENTER,//1 DNI
            SwingConstants.CENTER,//2 Nombre de Usuario
            SwingConstants.CENTER//3 ROL
        });

        TABLA.setHorizontalTextPosition(new int[]{
            SwingConstants.CENTER,//1 DNI
            SwingConstants.CENTER,//2 Nombre de Usuario
            SwingConstants.CENTER//3 ROL
        });
        DefaultTableModel Model = new DefaultTableModel(null, TextHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TABLA.FixScroll(jScrollPane1);
        TABLA.setModel(Model);
        TABLA.setColumnWidths(new int[]{
            30,//1 DNI
            250,//2 Nombre de Usuario
            100, //ROL    
        });
        DataUsuario = new ControlUsuario((DefaultTableModel) TABLA.getModel());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        CARD_U_TRABAJADORES = new com.mycompany.Swing.Card.CardDataAction();
        CARD_U__NO_TRABAJADORES = new com.mycompany.Swing.Card.CardDataAction();
        TITULO_BUSQUEDA = new javax.swing.JLabel();
        TXT_BUSQUEDA = new com.mycompany.Swing.TextField.TextField();
        panel1 = new com.mycompany.Swing.Panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA = new com.mycompany.Swing.Tabla.Tabla();
        jPanel2 = new javax.swing.JPanel();
        BTN_CAMBIAR_CONTRASEÑA = new com.mycompany.Swing.Button.Button();
        BTN_AGREGAR_USUSARIO = new com.mycompany.Swing.Button.Button();
        BTN_ROL_ADMIN = new com.mycompany.Swing.Button.Button();
        BTN_QUITAR_ADMIN = new com.mycompany.Swing.Button.Button();
        BTN_ELIMINAR = new com.mycompany.Swing.Button.Button();

        setOpaque(false);

        CARD_U_TRABAJADORES.setCardBackgroundColor(new java.awt.Color(0, 204, 0));
        CARD_U_TRABAJADORES.setCardForegroundNumero(new java.awt.Color(255, 255, 255));
        CARD_U_TRABAJADORES.setCardForegroundTitulo(new java.awt.Color(255, 255, 255));
        CARD_U_TRABAJADORES.setCardTextNumero("");
        CARD_U_TRABAJADORES.setCardTextTitulo("Usuario trabajador");

        CARD_U__NO_TRABAJADORES.setCardBackgroundColor(new java.awt.Color(255, 51, 51));
        CARD_U__NO_TRABAJADORES.setCardForegroundNumero(new java.awt.Color(255, 255, 255));
        CARD_U__NO_TRABAJADORES.setCardForegroundTitulo(new java.awt.Color(255, 255, 255));
        CARD_U__NO_TRABAJADORES.setCardTextNumero("");
        CARD_U__NO_TRABAJADORES.setCardTextTitulo("Trabajador sin usuario");

        TITULO_BUSQUEDA.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        TITULO_BUSQUEDA.setForeground(new java.awt.Color(16, 78, 128));
        TITULO_BUSQUEDA.setText("BUSCAR USUSARIO TRABAJADOR");

        TXT_BUSQUEDA.setTextField_ShadowSize(3);
        TXT_BUSQUEDA.setTextField_Txthint("Buscar Usuario");
        TXT_BUSQUEDA.setTextField_TxthintColor(new java.awt.Color(102, 102, 102));
        TXT_BUSQUEDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BUSQUEDAActionPerformed(evt);
            }
        });
        TXT_BUSQUEDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSQUEDAKeyReleased(evt);
            }
        });

        TABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        TABLA.setHeader_BackgroundColor(new java.awt.Color(16, 78, 128));
        TABLA.setHeader_BorderActived(false);
        TABLA.setHeader_ForegroundColor(new java.awt.Color(255, 255, 255));
        TABLA.setHeader_Round(7);
        TABLA.setRowHeight(33);
        TABLA.setRow_Font(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        TABLA.setTable_Border(null);
        TABLA.setTable_GridLineColor(new java.awt.Color(204, 204, 204));
        TABLA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TABLAMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TABLA);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1)
                .addGap(10, 10, 10))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setOpaque(false);

        BTN_CAMBIAR_CONTRASEÑA.setBackground(new java.awt.Color(16, 78, 128));
        BTN_CAMBIAR_CONTRASEÑA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_CAMBIAR_CONTRASEÑA.setText("Cambiar Contraseña");
        BTN_CAMBIAR_CONTRASEÑA.setButton_ActivedIconColorFilter(true);
        BTN_CAMBIAR_CONTRASEÑA.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_CAMBIAR_CONTRASEÑA.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_CAMBIAR_CONTRASEÑA.setButton_Round(15);
        BTN_CAMBIAR_CONTRASEÑA.setButton_ShadowColor(new java.awt.Color(51, 51, 51));
        BTN_CAMBIAR_CONTRASEÑA.setButton_ShadowSize(3);
        BTN_CAMBIAR_CONTRASEÑA.setButton_ShawdowOpacity(0.0F);
        BTN_CAMBIAR_CONTRASEÑA.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BTN_CAMBIAR_CONTRASEÑA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CAMBIAR_CONTRASEÑAActionPerformed(evt);
            }
        });

        BTN_AGREGAR_USUSARIO.setBackground(new java.awt.Color(16, 78, 128));
        BTN_AGREGAR_USUSARIO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_USUSARIO.setText("Crear Usuario");
        BTN_AGREGAR_USUSARIO.setButton_ActivedIconColorFilter(true);
        BTN_AGREGAR_USUSARIO.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_AGREGAR_USUSARIO.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_USUSARIO.setButton_Round(15);
        BTN_AGREGAR_USUSARIO.setButton_ShadowColor(new java.awt.Color(51, 51, 51));
        BTN_AGREGAR_USUSARIO.setButton_ShadowSize(3);
        BTN_AGREGAR_USUSARIO.setButton_ShawdowOpacity(0.0F);
        BTN_AGREGAR_USUSARIO.setEnabled(false);
        BTN_AGREGAR_USUSARIO.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BTN_AGREGAR_USUSARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_USUSARIOActionPerformed(evt);
            }
        });

        BTN_ROL_ADMIN.setBackground(new java.awt.Color(16, 78, 128));
        BTN_ROL_ADMIN.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ROL_ADMIN.setText("Dar Administrador");
        BTN_ROL_ADMIN.setButton_ActivedIconColorFilter(true);
        BTN_ROL_ADMIN.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_ROL_ADMIN.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_ROL_ADMIN.setButton_Round(15);
        BTN_ROL_ADMIN.setButton_ShadowColor(new java.awt.Color(51, 51, 51));
        BTN_ROL_ADMIN.setButton_ShadowSize(3);
        BTN_ROL_ADMIN.setButton_ShawdowOpacity(0.0F);
        BTN_ROL_ADMIN.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BTN_ROL_ADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ROL_ADMINActionPerformed(evt);
            }
        });

        BTN_QUITAR_ADMIN.setBackground(new java.awt.Color(16, 78, 128));
        BTN_QUITAR_ADMIN.setForeground(new java.awt.Color(255, 255, 255));
        BTN_QUITAR_ADMIN.setText("Quitar Administrador");
        BTN_QUITAR_ADMIN.setButton_ActivedIconColorFilter(true);
        BTN_QUITAR_ADMIN.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_QUITAR_ADMIN.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_QUITAR_ADMIN.setButton_Round(15);
        BTN_QUITAR_ADMIN.setButton_ShadowColor(new java.awt.Color(51, 51, 51));
        BTN_QUITAR_ADMIN.setButton_ShadowSize(3);
        BTN_QUITAR_ADMIN.setButton_ShawdowOpacity(0.0F);
        BTN_QUITAR_ADMIN.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BTN_QUITAR_ADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_QUITAR_ADMINActionPerformed(evt);
            }
        });

        BTN_ELIMINAR.setBackground(new java.awt.Color(255, 61, 61));
        BTN_ELIMINAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ELIMINAR.setText("Eliminar Usuario");
        BTN_ELIMINAR.setButton_ActivedIconColorFilter(true);
        BTN_ELIMINAR.setButton_BackgroundColorEntered(new java.awt.Color(255, 81, 81));
        BTN_ELIMINAR.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_ELIMINAR.setButton_Round(15);
        BTN_ELIMINAR.setButton_ShadowColor(new java.awt.Color(15, 71, 128));
        BTN_ELIMINAR.setButton_ShadowSize(3);
        BTN_ELIMINAR.setButton_ShawdowOpacity(0.0F);
        BTN_ELIMINAR.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BTN_ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ELIMINARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_AGREGAR_USUSARIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_ELIMINAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_ROL_ADMIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_CAMBIAR_CONTRASEÑA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_QUITAR_ADMIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_AGREGAR_USUSARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(BTN_ELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_CAMBIAR_CONTRASEÑA, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_ROL_ADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_QUITAR_ADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TITULO_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CARD_U__NO_TRABAJADORES, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(CARD_U_TRABAJADORES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TITULO_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CARD_U_TRABAJADORES, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(CARD_U__NO_TRABAJADORES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CAMBIAR_CONTRASEÑAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CAMBIAR_CONTRASEÑAActionPerformed

        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            if (DataUsuario.isUserAdmindAccess(Main.getDNIUser())) {
                String DNI = String.valueOf(TABLA.getValueAt(filaselected, 0));
                ControlTrabajador ct = new ControlTrabajador();
                TrabajadorClass t = ct.getTrabajadorEspecifico(DNI);
                ct.Disconneting();

                new PopupCambiarContraseña(t);
            } else {
                new PopupMessage(
                        "ACCESO RESTRINGIDO",
                        "Usted no tiene permisos para realizar esta accion",
                        2
                );
            }

        }
    }//GEN-LAST:event_BTN_CAMBIAR_CONTRASEÑAActionPerformed

    private void TXT_BUSQUEDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSQUEDAKeyReleased
        MostrarUsuarioBusqueda();


    }//GEN-LAST:event_TXT_BUSQUEDAKeyReleased

    private void BTN_ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ELIMINARActionPerformed
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {

            if (DataUsuario.isUserAdmindAccess(Main.getDNIUser())) {

                String DNI_User = TABLA.getValueAt(filaselected, 0).toString();
                PopupConfirMessage obj = new PopupConfirMessage(
                        "Eliminar Usuario Trabajador",
                        "¿Esta seguro de eliminar este usuario ?.",
                        new Color(236, 85, 101)
                );
                obj.setTituloForeground(Color.WHITE);
                obj.setIcon_ColorFilter(new Color(236, 85, 101));
                obj.setIcon(new FlatSVGIcon("svg/user.svg", 70, 70), true);
                obj.setCodigo(DNI_User);
                obj.setCodigoForeground(Color.WHITE);

                obj.setEventAction(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DataUsuario.EliminarUsuario(DNI_User);
                        MostrarUsuarioBusqueda();
                        getCountUsers();
                        GlassPanePopup.closePopupLast();
                    }
                });
            } else {
                new PopupMessage(
                        "ACCESO RESTRINGIDO",
                        "Usted no tiene permisos para realizar esta accion",
                        2
                );
            }

        }


    }//GEN-LAST:event_BTN_ELIMINARActionPerformed

    private void TABLAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLAMousePressed
        // TODO add your handling code here:
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1 && ActtionBusqueda == 1) {
            BTN_AGREGAR_USUSARIO.setEnabled(false);
            BTN_ELIMINAR.setEnabled(true);
            BTN_CAMBIAR_CONTRASEÑA.setEnabled(true);
            BTN_ROL_ADMIN.setEnabled(true);
            BTN_QUITAR_ADMIN.setEnabled(true);
        } else {
            BTN_AGREGAR_USUSARIO.setEnabled(true);
            BTN_ELIMINAR.setEnabled(false);
            BTN_CAMBIAR_CONTRASEÑA.setEnabled(false);
            BTN_ROL_ADMIN.setEnabled(false);
            BTN_QUITAR_ADMIN.setEnabled(false);
        }
    }//GEN-LAST:event_TABLAMousePressed

    private void TXT_BUSQUEDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BUSQUEDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BUSQUEDAActionPerformed

    private void BTN_AGREGAR_USUSARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_USUSARIOActionPerformed

        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            if (DataUsuario.isUserAdmindAccess(Main.getDNIUser())) {
                String DNI = String.valueOf(TABLA.getValueAt(filaselected, 0));
                ControlTrabajador ct = new ControlTrabajador();
                TrabajadorClass t = ct.getTrabajadorEspecifico(DNI);
                ct.Disconneting();
                new PopupCrearUsuario(t);

            } else {
                new PopupMessage(
                        "ACCESO RESTRINGIDO",
                        "Usted no tiene permisos para realizar esta accion",
                        2
                );
            }

        }
    }//GEN-LAST:event_BTN_AGREGAR_USUSARIOActionPerformed

    private void BTN_ROL_ADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ROL_ADMINActionPerformed
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            if (DataUsuario.isUserAdmindAccess(Main.getDNIUser())) {

                String DNI_User = TABLA.getValueAt(filaselected, 0).toString();
                if (DataUsuario.isUserAdmindAccess(DNI_User)) {
                    new PopupMessage(
                            "NO SE PUEDE EJECUTAR",
                            "El usuario " + DNI_User + " ya es un Administrador.",
                            2
                    );

                } else {
                    UsuarioClass u = DataUsuario.getUsuario(DNI_User);
                    u.setAdminPermision(true);
                    DataUsuario.ModificarUsuario(u);
                    new PopupMessage(
                            "MODIFICAION EXITOSO",
                            "Se ha otorgado al usuario " + DNI_User + " el rol de Administrador.",
                            0
                    );
                    MostrarUsuarioBusqueda();
                }

            } else {
                new PopupMessage(
                        "ACCESO RESTRINGIDO",
                        "Usted no tiene permisos para realizar esta accion",
                        2
                );
            }

        }
    }//GEN-LAST:event_BTN_ROL_ADMINActionPerformed

    private void BTN_QUITAR_ADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_QUITAR_ADMINActionPerformed
        // TODO add your handling code here:
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            if (DataUsuario.isUserAdmindAccess(Main.getDNIUser())) {

                String DNI_User = TABLA.getValueAt(filaselected, 0).toString();
                if (DataUsuario.isUserAdmindAccess(DNI_User)) {

                    UsuarioClass u = DataUsuario.getUsuario(DNI_User);
                    u.setAdminPermision(false);
                    DataUsuario.ModificarUsuario(u);
                    new PopupMessage(
                            "MODIFICAION EXITOSO",
                            "Se ha otorgado al usuario " + DNI_User + " el rol de Trabajador.",
                            0
                    );
                    MostrarUsuarioBusqueda();

                } else {
                    new PopupMessage(
                            "NO SE PUEDE EJECUTAR",
                            "El usuario " + DNI_User + " ya es un Trabajador.",
                            2
                    );
                }

            } else {
                new PopupMessage(
                        "ACCESO RESTRINGIDO",
                        "Usted no tiene permisos para realizar esta accion",
                        2
                );
            }
        }
    }//GEN-LAST:event_BTN_QUITAR_ADMINActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Button.Button BTN_AGREGAR_USUSARIO;
    private com.mycompany.Swing.Button.Button BTN_CAMBIAR_CONTRASEÑA;
    private com.mycompany.Swing.Button.Button BTN_ELIMINAR;
    private com.mycompany.Swing.Button.Button BTN_QUITAR_ADMIN;
    private com.mycompany.Swing.Button.Button BTN_ROL_ADMIN;
    private com.mycompany.Swing.Card.CardDataAction CARD_U_TRABAJADORES;
    private com.mycompany.Swing.Card.CardDataAction CARD_U__NO_TRABAJADORES;
    private com.mycompany.Swing.Tabla.Tabla TABLA;
    private javax.swing.JLabel TITULO_BUSQUEDA;
    private static com.mycompany.Swing.TextField.TextField TXT_BUSQUEDA;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.mycompany.Swing.Panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
