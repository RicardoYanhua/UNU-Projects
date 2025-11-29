package com.mycompany.LuxcarForm;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ControlServicio;
import com.mycompany.DataBase.Control.ServicioClass;
import com.mycompany.LuxcarDocuments.PopupDocument;
import com.mycompany.Popup.PopupConfirMessage;
import com.mycompany.LuxcarForm.FormsServicio.FormModificarServicio;
import com.mycompany.LuxcarForm.FormsServicio.FormRegistrarServicio;
import com.mycompany.LuxcarForm.FormsServicio.FormVerServicio;
import com.mycompany.Swing.TextField.Filter.TxtUpper;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class FormServicio extends javax.swing.JPanel {

    public static ControlServicio DataServicio;

    public FormServicio() {
        initComponents();
        DataServicio = new ControlServicio();
        InicializarTablaServicio();
        InicializarIcons();

        MostrarServicioBusqueda();
        InicializarTXTDocuments();
    }

    public void DisabledButtons() {
        BTN_ELIMINAR.setEnabled(false);
        BTN_MODIFICAR.setEnabled(false);
        BTN_VER_SERVICIO.setEnabled(false);
    }

    public void ActivedButtons() {
        BTN_ELIMINAR.setEnabled(true);
        BTN_MODIFICAR.setEnabled(true);
        BTN_VER_SERVICIO.setEnabled(true);
    }

    public void InicializarTXTDocuments() {
        TXT_BUSQUEDA.setDocument(new TxtUpper() {
        });
    }

    public static void MostrarServicioBusqueda() {
        DataServicio.MostrarTablaServicioBusqueda(TXT_BUSQUEDA.getText());

    }

    public void InicializarIcons() {
        TXT_BUSQUEDA.setIcon(
                new FlatSVGIcon("svg/buscar.svg", 25, 25));
        BTN_MODIFICAR.setIcon(
                new FlatSVGIcon("svg/user_edit.svg", 25, 25));
        BTN_ELIMINAR.setIcon(
                new FlatSVGIcon("svg/user_delete.svg", 25, 25));
    }

    public void InicializarTablaServicio() {
        String Header[] = {
            "ID",
            "Ubicacion",
            "Descripcion",
            "Estado",
            "FechaInicio",
            "F. Registrado"
        };
        DefaultTableModel Model = new DefaultTableModel(null, Header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TABLA_SERVICIO.setHorizontalTextPositionHeader(new int[]{
            SwingConstants.CENTER,//1 ID
            SwingConstants.LEFT,//2 Ubicacion
            SwingConstants.LEFT,//3 Descriocion
            SwingConstants.CENTER,//4 Estado
            SwingConstants.LEFT,//5 FechaInicio
            SwingConstants.LEFT//7 Fecha registrado
        });
        TABLA_SERVICIO.setHorizontalTextPosition(new int[]{
            SwingConstants.CENTER,//1 ID
            SwingConstants.LEFT,//2 Ubicacion
            SwingConstants.LEFT,//3 Descriocion
            SwingConstants.CENTER,//4 Estado
            SwingConstants.LEFT,//5 FechaInicio
            SwingConstants.LEFT//7 Fecha registrado
        });
        TABLA_SERVICIO.FixScroll(jScrollPane1);
        TABLA_SERVICIO.setModel(Model);
        TABLA_SERVICIO.setColumnWidths(new int[]{
            30,//1 ID
            170,//2 Ubicacion
            170,//3 Descriocion
            80, //Estado
            100,//9 Fecha Inicio
            100//9 Fecha Registrada

        });
        DataServicio = new ControlServicio((DefaultTableModel) TABLA_SERVICIO.getModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        TXT_BUSQUEDA = new com.mycompany.Swing.TextField.TextField();
        jLabel2 = new javax.swing.JLabel();
        panel7 = new com.mycompany.Swing.Panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA_SERVICIO = new com.mycompany.Swing.Tabla.Tabla();
        jButton1 = new javax.swing.JButton();
        BTN_MODIFICAR = new com.mycompany.Swing.Button.Button();
        BTN_ELIMINAR = new com.mycompany.Swing.Button.Button();
        BTN_ELIMINAR1 = new com.mycompany.Swing.Button.Button();
        BTN_VER_SERVICIO = new com.mycompany.Swing.Button.Button();

        setOpaque(false);

        TXT_BUSQUEDA.setTextField_ShadowSize(3);
        TXT_BUSQUEDA.setTextField_Txthint("Buscar Servicio");
        TXT_BUSQUEDA.setTextField_TxthintColor(new java.awt.Color(102, 102, 102));
        TXT_BUSQUEDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSQUEDAKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(16, 78, 128));
        jLabel2.setText("BUSQUEDA SERVICIO");

        panel7.setPanel_Round(7);
        panel7.setPanel_ShadowColor(new java.awt.Color(0, 0, 0));
        panel7.setPanel_ShadowOpacity(0.3F);
        panel7.setPanel_ShadowSize(3);

        TABLA_SERVICIO.setModel(new javax.swing.table.DefaultTableModel(
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
        TABLA_SERVICIO.setHeader_BackgroundColor(new java.awt.Color(16, 78, 128));
        TABLA_SERVICIO.setHeader_Border(javax.swing.BorderFactory.createEmptyBorder(11, 1, 11, 1));
        TABLA_SERVICIO.setHeader_BorderActived(false);
        TABLA_SERVICIO.setHeader_ForegroundColor(new java.awt.Color(255, 255, 255));
        TABLA_SERVICIO.setHeader_Round(7);
        TABLA_SERVICIO.setTable_Border(null);
        TABLA_SERVICIO.setTable_GridLineColor(new java.awt.Color(204, 204, 204));
        TABLA_SERVICIO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TABLA_SERVICIOMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TABLA_SERVICIO);

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1)
                .addGap(5, 5, 5))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BTN_MODIFICAR.setBackground(new java.awt.Color(51, 51, 51));
        BTN_MODIFICAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_MODIFICAR.setText("Modificar");
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

        BTN_ELIMINAR1.setBackground(new java.awt.Color(16, 78, 128));
        BTN_ELIMINAR1.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ELIMINAR1.setText("Nuevo");
        BTN_ELIMINAR1.setButton_ActivedIconColorFilter(true);
        BTN_ELIMINAR1.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_ELIMINAR1.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_ELIMINAR1.setButton_Round(15);
        BTN_ELIMINAR1.setButton_ShadowColor(new java.awt.Color(15, 71, 128));
        BTN_ELIMINAR1.setButton_ShadowSize(3);
        BTN_ELIMINAR1.setButton_ShawdowOpacity(0.0F);
        BTN_ELIMINAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ELIMINAR1ActionPerformed(evt);
            }
        });

        BTN_VER_SERVICIO.setBackground(new java.awt.Color(51, 51, 51));
        BTN_VER_SERVICIO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_VER_SERVICIO.setText("Ver Servicio");
        BTN_VER_SERVICIO.setButton_ActivedIconColorFilter(true);
        BTN_VER_SERVICIO.setButton_BackgroundColorEntered(new java.awt.Color(102, 102, 102));
        BTN_VER_SERVICIO.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_VER_SERVICIO.setButton_Round(15);
        BTN_VER_SERVICIO.setButton_ShadowColor(new java.awt.Color(15, 71, 128));
        BTN_VER_SERVICIO.setButton_ShadowSize(3);
        BTN_VER_SERVICIO.setButton_ShawdowOpacity(0.0F);
        BTN_VER_SERVICIO.setEnabled(false);
        BTN_VER_SERVICIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VER_SERVICIOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BTN_VER_SERVICIO, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_ELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_MODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BTN_ELIMINAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTN_ELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTN_MODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTN_ELIMINAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTN_VER_SERVICIO, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MODIFICARActionPerformed

        int filaselected = TABLA_SERVICIO.getSelectedRow();
        if (filaselected > -1) {
            String ID_Servicio = TABLA_SERVICIO.getValueAt(
                    TABLA_SERVICIO.getSelectedRow(),
                    0).toString();
            MostrarServicioBusqueda();
            DisabledButtons();
            new FormModificarServicio(
                    DataServicio.ObtenerServicioEspecifico(
                            Integer.parseInt(ID_Servicio)
                    )
            );
            DisabledButtons();
        }

    }//GEN-LAST:event_BTN_MODIFICARActionPerformed

    private void TXT_BUSQUEDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSQUEDAKeyReleased
        MostrarServicioBusqueda();
        DisabledButtons();

    }//GEN-LAST:event_TXT_BUSQUEDAKeyReleased


    private void BTN_ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ELIMINARActionPerformed
        int filaselected = TABLA_SERVICIO.getSelectedRow();
        if (filaselected > -1) {

            int ServicioID = Integer.parseInt(TABLA_SERVICIO.getValueAt(filaselected, 0).toString());

            PopupConfirMessage obj = new PopupConfirMessage(
                    "Eliminar Servicio",
                    "¿Seguro que eliminar a este Servicio ?.",
                    new Color(236, 85, 101)
            );

            obj.setTituloForeground(Color.WHITE);
            obj.setIcon_ColorFilter(new Color(236, 85, 101));
            obj.setIcon(new FlatSVGIcon("svg/service.svg", 70, 70), true);
            obj.setCodigo(String.valueOf(ServicioID));
            obj.setCodigoForeground(Color.WHITE);

            obj.setEventAction(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GlassPanePopup.closePopupLast();
                    DataServicio.EliminarServicio(ServicioID);
                    MostrarServicioBusqueda();
                    DisabledButtons();

                }
            });
        }


    }//GEN-LAST:event_BTN_ELIMINARActionPerformed

    private void TABLA_SERVICIOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_SERVICIOMousePressed
        int filaselected = TABLA_SERVICIO.getSelectedRow();
        if (filaselected > -1) {
            ActivedButtons();
        } else {
            DisabledButtons();
        }
    }//GEN-LAST:event_TABLA_SERVICIOMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new PopupDocument();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTN_ELIMINAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ELIMINAR1ActionPerformed
        new FormRegistrarServicio();
        DisabledButtons();
    }//GEN-LAST:event_BTN_ELIMINAR1ActionPerformed

    private void BTN_VER_SERVICIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VER_SERVICIOActionPerformed
        // TODO add your handling code here:
        int filaselected = TABLA_SERVICIO.getSelectedRow();
        if (filaselected > -1) {

            int ServicioID = Integer.parseInt(TABLA_SERVICIO.getValueAt(filaselected, 0).toString());
            ServicioClass servicio = DataServicio.ObtenerServicioEspecifico(ServicioID);
            new FormVerServicio(servicio);
        }
    }//GEN-LAST:event_BTN_VER_SERVICIOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Button.Button BTN_ELIMINAR;
    private com.mycompany.Swing.Button.Button BTN_ELIMINAR1;
    private com.mycompany.Swing.Button.Button BTN_MODIFICAR;
    private com.mycompany.Swing.Button.Button BTN_VER_SERVICIO;
    private com.mycompany.Swing.Tabla.Tabla TABLA_SERVICIO;
    private static com.mycompany.Swing.TextField.TextField TXT_BUSQUEDA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.mycompany.Swing.Panel.Panel panel7;
    // End of variables declaration//GEN-END:variables
}
