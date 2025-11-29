package com.mycompany.LuxcarForm;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ControlTrabajador;
import com.mycompany.DataBase.Control.ControlUsuario;
import com.mycompany.DataBase.Control.TrabajadorClass;
import com.mycompany.Luxcar.Main;
import com.mycompany.Popup.PopupConfirMessage;
import com.mycompany.LuxcarForm.FormsTrabajador.PopupModificarTrabajador;
import com.mycompany.LuxcarForm.FormsTrabajador.PopupRegistrarTrabajador;
import com.mycompany.LuxcarForm.FormsTrabajador.PopupVerRegistroTrabajador;
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
public class FormTrabajador extends javax.swing.JPanel {

    public static ControlTrabajador DataTrabajador;

    public FormTrabajador() {
        initComponents();
        DataTrabajador = new ControlTrabajador();
        InicializarTabla();
        MostrarTablaTrabajadorBusqueda();
        InicializarIcons();
        InicializarTXTDocuments();
    }

    public void InicializarTXTDocuments() {
        TXT_BUSQUEDA.setDocument(new TxtUpper() {
        });
    }

    public static void MostrarTablaTrabajadorBusqueda() {

        if (SWITCH_DINAMIC.isSelected()) {
            DataTrabajador.BusqudaDinamicaTrabajador(TXT_BUSQUEDA.getText());
        } else {
            DataTrabajador.BusquedaStaticaTrabajador(TXT_BUSQUEDA.getText());
        }

    }

    public void InicializarIcons() {
        TXT_BUSQUEDA.setIcon(
                new FlatSVGIcon("svg/buscar.svg", 25, 25));
        BTN_REGISTRAR.setIcon(
                new FlatSVGIcon("svg/user_add.svg", 25, 25));
        BTN_MODIFICAR.setIcon(
                new FlatSVGIcon("svg/user_edit.svg", 25, 25));
        BTN_ELIMINAR.setIcon(
                new FlatSVGIcon("svg/user_delete.svg", 25, 25));
        BTN_VIEW_REGISTRO.setIcon(
                new FlatSVGIcon("svg/worker.svg", 25, 25));

    }

    public void InicializarTabla() {
        String TextHeader[] = {
            "DNI",
            "Nombres",
            "Apellidos",
            "Nacimiento",
            "Dirección",
            "Correo",
            "Telefono",
            "Contratación",
            "Puesto",
            "CobroPorHora",
            "Genero",
            "Estado"
        };
        TABLA.setHorizontalTextPositionHeader(new int[]{
            SwingConstants.CENTER,//1 DNI
            SwingConstants.LEFT,//2 Nombres
            SwingConstants.LEFT,//3 Apellidos
            SwingConstants.CENTER,//4 F.Nacimiento
            SwingConstants.LEFT,//5 Direccion
            SwingConstants.LEFT,//6 Correo
            SwingConstants.CENTER,//7 Telefono
            SwingConstants.CENTER,//8 F.Contratacion
            SwingConstants.LEFT,//9 Puesto
            SwingConstants.CENTER,//10 CobroPorHora
            SwingConstants.CENTER,//11 Genero
            SwingConstants.CENTER,//12 Estado
        });

        TABLA.setHorizontalTextPosition(new int[]{
            SwingConstants.CENTER,//1 DNI
            SwingConstants.LEFT,//2 Nombres
            SwingConstants.LEFT,//3 Apellidos
            SwingConstants.CENTER,//4 F.Nacimiento
            SwingConstants.LEFT,//5 Direccion
            SwingConstants.LEFT,//6 Correo
            SwingConstants.CENTER,//7 Telefono
            SwingConstants.CENTER,//8 F.Contratacion
            SwingConstants.LEFT,//9 Puesto
            SwingConstants.RIGHT,//10 CobroPorHora
            SwingConstants.CENTER,//11 Genero
            SwingConstants.CENTER,//12 Estado
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
            100,//2 Nombres
            100,//3 Apellidos
            45,//4 F.Nacimiento
            120,//5 Direccion
            120,//6 Correo
            10,//7 Telefono
            45,//8 F.Contratacion
            120,//9 Puesto
            50,//10 CobroPorHora
            10,//11 Genero
            10,//12 Estado
        });

        DataTrabajador = new ControlTrabajador((DefaultTableModel) TABLA.getModel());

    }

    public void MostrarAllTrabajadores() {
        DataTrabajador.MostrarTablaTrabajadorCompleta();
    }

    public void DisabledButtons() {
        BTN_ELIMINAR.setEnabled(false);
        BTN_MODIFICAR.setEnabled(false);
        BTN_VIEW_REGISTRO.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new com.mycompany.Swing.Panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA = new com.mycompany.Swing.Tabla.Tabla();
        TXT_BUSQUEDA = new com.mycompany.Swing.TextField.TextField();
        jPanel1 = new javax.swing.JPanel();
        BTN_REGISTRAR = new com.mycompany.Swing.Button.Button();
        BTN_MODIFICAR = new com.mycompany.Swing.Button.Button();
        BTN_ELIMINAR = new com.mycompany.Swing.Button.Button();
        BTN_VIEW_REGISTRO = new com.mycompany.Swing.Button.Button();
        jLabel2 = new javax.swing.JLabel();
        SWITCH_DINAMIC = new com.mycompany.Swing.SwitchButton.SwitchButton();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        TABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TABLA.setHeader_BackgroundColor(new java.awt.Color(16, 78, 128));
        TABLA.setHeader_Border(javax.swing.BorderFactory.createEmptyBorder(11, 1, 11, 1));
        TABLA.setHeader_BorderActived(false);
        TABLA.setHeader_ForegroundColor(new java.awt.Color(255, 255, 255));
        TABLA.setHeader_Round(7);
        TABLA.setRow_SelectedColor(new java.awt.Color(230, 230, 255));
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
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1)
                .addGap(6, 6, 6))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        TXT_BUSQUEDA.setTextField_ShadowSize(3);
        TXT_BUSQUEDA.setTextField_Txthint("Buscar trabajador.");
        TXT_BUSQUEDA.setTextField_TxthintColor(new java.awt.Color(102, 102, 102));
        TXT_BUSQUEDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSQUEDAKeyReleased(evt);
            }
        });

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN_REGISTRAR.setBackground(new java.awt.Color(15, 71, 128));
        BTN_REGISTRAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_REGISTRAR.setText("Nuevo");
        BTN_REGISTRAR.setButton_ActivedIconColorFilter(true);
        BTN_REGISTRAR.setButton_BackgroundColorEntered(new java.awt.Color(25, 81, 128));
        BTN_REGISTRAR.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_REGISTRAR.setButton_Round(15);
        BTN_REGISTRAR.setButton_ShadowColor(new java.awt.Color(15, 71, 128));
        BTN_REGISTRAR.setButton_ShadowSize(3);
        BTN_REGISTRAR.setButton_ShawdowOpacity(0.0F);
        BTN_REGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_REGISTRARActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_REGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 141, 48));

        BTN_MODIFICAR.setBackground(new java.awt.Color(51, 51, 51));
        BTN_MODIFICAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_MODIFICAR.setText("Editar");
        BTN_MODIFICAR.setButton_ActivedIconColorFilter(true);
        BTN_MODIFICAR.setButton_BackgroundColorEntered(new java.awt.Color(71, 71, 71));
        BTN_MODIFICAR.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_MODIFICAR.setButton_Round(15);
        BTN_MODIFICAR.setButton_ShadowColor(new java.awt.Color(51, 51, 51));
        BTN_MODIFICAR.setButton_ShadowSize(3);
        BTN_MODIFICAR.setButton_ShawdowOpacity(0.0F);
        BTN_MODIFICAR.setEnabled(false);
        BTN_MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MODIFICARActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 141, 48));

        BTN_ELIMINAR.setBackground(new java.awt.Color(255, 61, 61));
        BTN_ELIMINAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ELIMINAR.setText("Eliminar");
        BTN_ELIMINAR.setButton_ActivedIconColorFilter(true);
        BTN_ELIMINAR.setButton_BackgroundColorEntered(new java.awt.Color(255, 81, 81));
        BTN_ELIMINAR.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_ELIMINAR.setButton_Round(15);
        BTN_ELIMINAR.setButton_ShadowColor(new java.awt.Color(15, 71, 128));
        BTN_ELIMINAR.setButton_ShadowSize(3);
        BTN_ELIMINAR.setButton_ShawdowOpacity(0.0F);
        BTN_ELIMINAR.setEnabled(false);
        BTN_ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ELIMINARActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_ELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 141, 48));

        BTN_VIEW_REGISTRO.setBackground(new java.awt.Color(16, 78, 128));
        BTN_VIEW_REGISTRO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_VIEW_REGISTRO.setText("Ver registros");
        BTN_VIEW_REGISTRO.setButton_ActivedIconColorFilter(true);
        BTN_VIEW_REGISTRO.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_VIEW_REGISTRO.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_VIEW_REGISTRO.setButton_Round(15);
        BTN_VIEW_REGISTRO.setButton_ShadowColor(new java.awt.Color(15, 71, 128));
        BTN_VIEW_REGISTRO.setButton_ShadowSize(3);
        BTN_VIEW_REGISTRO.setButton_ShawdowOpacity(0.0F);
        BTN_VIEW_REGISTRO.setEnabled(false);
        BTN_VIEW_REGISTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VIEW_REGISTROActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VIEW_REGISTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 30, 180, 48));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(16, 78, 128));
        jLabel2.setText("BUSQUEDA TRABAJADOR");

        SWITCH_DINAMIC.setBackground(new java.awt.Color(16, 78, 128));
        SWITCH_DINAMIC.setEnabled(false);
        SWITCH_DINAMIC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SWITCH_DINAMICMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Dinamic search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SWITCH_DINAMIC, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(SWITCH_DINAMIC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGap(5, 5, 5)
                        .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MODIFICARActionPerformed
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            String TrabajadorDNI = TABLA.getValueAt(filaselected, 0).toString();
            new PopupModificarTrabajador(DataTrabajador.getTrabajadorEspecifico(TrabajadorDNI));
            DisabledButtons();
            TABLA.setSelectionMode(0);

        }
    }//GEN-LAST:event_BTN_MODIFICARActionPerformed

    private void TXT_BUSQUEDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSQUEDAKeyReleased
        MostrarTablaTrabajadorBusqueda();
        DisabledButtons();


    }//GEN-LAST:event_TXT_BUSQUEDAKeyReleased

    private void BTN_REGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_REGISTRARActionPerformed
        new PopupRegistrarTrabajador();
    }//GEN-LAST:event_BTN_REGISTRARActionPerformed

    private void SWITCH_DINAMICMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SWITCH_DINAMICMouseReleased
        MostrarTablaTrabajadorBusqueda();
        DisabledButtons();
    }//GEN-LAST:event_SWITCH_DINAMICMouseReleased

    private void BTN_ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ELIMINARActionPerformed
        int filaselected = TABLA.getSelectedRow();
        ControlUsuario cu = new ControlUsuario();
        String TrabajadorDNI = TABLA.getValueAt(filaselected, 0).toString();

        if ((filaselected > -1)
                && cu.isUserAdmindAccess(Main.getDNIUser())
                && !Main.getDNIUser().equals(TrabajadorDNI)) {

            PopupConfirMessage obj = new PopupConfirMessage(
                    "Eliminar trabajador",
                    "¿Seguro que eliminar a este trabajador?.",
                    new Color(236, 85, 101)
            );

            obj.setTituloForeground(Color.WHITE);
            obj.setIcon_ColorFilter(new Color(236, 85, 101));

            obj.setIcon(new FlatSVGIcon("svg/worker.svg", 70, 70), true);
            obj.setCodigo(TrabajadorDNI);
            obj.setCodigoForeground(Color.WHITE);

            obj.setEventAction(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GlassPanePopup.closePopupLast();
                    new PopupMessage(
                            "ACCION COMPLETADA",
                            "Se ha eliminado correctamente al trabajdor.",
                            0
                    );
                    DataTrabajador.EliminarTrabajador(new TrabajadorClass(TrabajadorDNI));
                    MostrarTablaTrabajadorBusqueda();
                    DisabledButtons();
                    

                }
            });
        } else {
            new PopupMessage(
                    "ACCESO DENEGADO",
                    "Usted no puede realizar esta accion en el programa.",
                    2
            );
        }
        cu.Disconneting();


    }//GEN-LAST:event_BTN_ELIMINARActionPerformed

    private void TABLAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLAMousePressed
        // TODO add your handling code here:
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            BTN_ELIMINAR.setEnabled(true);
            BTN_MODIFICAR.setEnabled(true);
            BTN_VIEW_REGISTRO.setEnabled(true);
        } else {
            DisabledButtons();
        }
    }//GEN-LAST:event_TABLAMousePressed

    private void BTN_VIEW_REGISTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VIEW_REGISTROActionPerformed
        // TODO add your handling code here:
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            String TrabajadorDNI = TABLA.getValueAt(filaselected, 0).toString();

            TrabajadorClass t = DataTrabajador.getTrabajadorEspecifico(TrabajadorDNI);
            new PopupVerRegistroTrabajador(t);

        }


    }//GEN-LAST:event_BTN_VIEW_REGISTROActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Button.Button BTN_ELIMINAR;
    private com.mycompany.Swing.Button.Button BTN_MODIFICAR;
    private com.mycompany.Swing.Button.Button BTN_REGISTRAR;
    private com.mycompany.Swing.Button.Button BTN_VIEW_REGISTRO;
    private static com.mycompany.Swing.SwitchButton.SwitchButton SWITCH_DINAMIC;
    private com.mycompany.Swing.Tabla.Tabla TABLA;
    private static com.mycompany.Swing.TextField.TextField TXT_BUSQUEDA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.mycompany.Swing.Panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
