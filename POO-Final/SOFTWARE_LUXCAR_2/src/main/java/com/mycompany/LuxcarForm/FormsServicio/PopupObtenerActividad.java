package com.mycompany.LuxcarForm.FormsServicio;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ActividadClass;
import com.mycompany.DataBase.Control.ControlActividad;
import com.mycompany.Swing.TextField.Filter.TxtUpper;
import com.mycompany.Util.Glasspanepopup.DefaultOption;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class PopupObtenerActividad extends javax.swing.JPanel {

    public ControlActividad DataActividad;
    private DefaultTableModel ActividadesAgregados;

    public PopupObtenerActividad() {
        initComponents();
        IniciarConexion();
        InicializarTabla();
        InicializarIconos();
        InicializarDocuments();
        GlassPanePopup.showPopup(this, new DefaultOption() {
            @Override
            public Color background() {
                return new Color(0, 0, 0);
            }

            @Override
            public int duration() {
                return 100;
            }
        });
    }

    public void InicializarDocuments() {
        TXT_BUSQUEDA.setDocument(new TxtUpper() {
        });
    }

    public PopupObtenerActividad(DefaultTableModel TablaActividadYaAgregado) {
        this();
        ActividadesAgregados = TablaActividadYaAgregado;
        MostrarTablaActividades();

    }

    public void InicializarIconos() {
        TXT_BUSQUEDA.setIcon(
                new FlatSVGIcon("svg/buscar.svg", 25, 25));
    }

    public void IniciarConexion() {
        DataActividad = new ControlActividad();
    }

    public void MostrarTablaActividades() {
        DataActividad.MostrarTablaActividadBusqueda(TXT_BUSQUEDA.getText());
        VerificarActividadesAgregados((DefaultTableModel) TABLA.getModel());
    }

    public void VerificarActividadesAgregados(DefaultTableModel TablaActividadCompleta) {
    for (int i = TablaActividadCompleta.getRowCount() - 1; i >= 0; i--) {
        int valorCompleto = Integer.parseInt(TablaActividadCompleta.getValueAt(i, 0).toString());
        
        for (int j = 0; j < ActividadesAgregados.getRowCount(); j++) {
            int valorAgregado =Integer.parseInt(ActividadesAgregados.getValueAt(j, 0).toString());
            
            if (valorCompleto == valorAgregado) { // Comparando enteros
                TablaActividadCompleta.removeRow(i);
                break; 
            }
        }
    }
    TABLA.setModel(TablaActividadCompleta);
}

    public void InicializarTabla() {

        TABLA.setHorizontalTextPositionHeader(new int[]{
            SwingConstants.CENTER,//
            SwingConstants.LEFT//
        });
        TABLA.setHorizontalTextPosition(new int[]{
            SwingConstants.CENTER,//
            SwingConstants.LEFT//
        });
        TABLA.FixScroll(jScrollPane1);

        DataActividad = new ControlActividad((DefaultTableModel) TABLA.getModel());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new com.mycompany.Swing.Panel.Panel();
        TXT_BUSQUEDA = new com.mycompany.Swing.TextField.TextField();
        jLabel2 = new javax.swing.JLabel();
        panel1 = new com.mycompany.Swing.Panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA = new com.mycompany.Swing.Tabla.Tabla();
        BTN_AGREGAR = new com.mycompany.Swing.Button.Button();
        button1 = new com.mycompany.Swing.Button.Button();

        setOpaque(false);

        panel2.setBackground(new java.awt.Color(250, 250, 255));
        panel2.setPanel_BackgroundGradientActived(true);
        panel2.setPanel_BackgroundGradientColor1(new java.awt.Color(250, 250, 255));
        panel2.setPanel_BackgroundGradientColor2(new java.awt.Color(240, 240, 255));

        TXT_BUSQUEDA.setTextField_ShadowSize(3);
        TXT_BUSQUEDA.setTextField_Txthint("BuscarActividad");
        TXT_BUSQUEDA.setTextField_TxthintColor(new java.awt.Color(102, 102, 102));
        TXT_BUSQUEDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSQUEDAKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(16, 78, 128));
        jLabel2.setText("BuscarActividad");

        panel1.setPanel_Round(5);
        panel1.setPanel_ShadowOpacity(0.3F);
        panel1.setPanel_ShadowSize(3);

        TABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Actividad", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLA.setHeader_BackgroundColor(new java.awt.Color(16, 78, 128));
        TABLA.setHeader_BorderActived(false);
        TABLA.setHeader_ForegroundColor(new java.awt.Color(255, 255, 255));
        TABLA.setHeader_Round(7);
        TABLA.setRowHeight(33);
        TABLA.setRow_BackgroundColor(new java.awt.Color(251, 251, 255));
        TABLA.setRow_SelectedColor(new java.awt.Color(204, 204, 204));
        TABLA.setTable_Border(null);
        TABLA.setTable_GridLineColor(new java.awt.Color(204, 204, 204));
        TABLA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TABLAMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TABLA);
        if (TABLA.getColumnModel().getColumnCount() > 0) {
            TABLA.getColumnModel().getColumn(0).setResizable(false);
            TABLA.getColumnModel().getColumn(0).setPreferredWidth(40);
            TABLA.getColumnModel().getColumn(1).setResizable(false);
            TABLA.getColumnModel().getColumn(1).setPreferredWidth(500);
        }

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        BTN_AGREGAR.setBackground(new java.awt.Color(15, 71, 128));
        BTN_AGREGAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR.setText("Agregar");
        BTN_AGREGAR.setButton_ActivedIconColorFilter(true);
        BTN_AGREGAR.setButton_BackgroundColorEntered(new java.awt.Color(25, 81, 128));
        BTN_AGREGAR.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR.setButton_Round(15);
        BTN_AGREGAR.setButton_ShadowColor(new java.awt.Color(15, 71, 128));
        BTN_AGREGAR.setButton_ShadowSize(3);
        BTN_AGREGAR.setButton_ShawdowOpacity(0.0F);
        BTN_AGREGAR.setEnabled(false);
        BTN_AGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGARActionPerformed(evt);
            }
        });

        button1.setText("Cancelar");
        button1.setButton_Round(15);
        button1.setButton_ShadowSize(3);
        button1.setButton_ShawdowOpacity(0.3F);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_AGREGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_AGREGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_BUSQUEDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSQUEDAKeyReleased
        MostrarTablaActividades();
    }//GEN-LAST:event_TXT_BUSQUEDAKeyReleased

    private void TABLAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLAMousePressed
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            BTN_AGREGAR.setEnabled(true);
        } else {
            BTN_AGREGAR.setEnabled(false);
        }
    }//GEN-LAST:event_TABLAMousePressed

    public ActividadClass getActividadSeleccionado() {
        ActividadClass ActividadSeleccionado = null;
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            ActividadSeleccionado = DataActividad.getActividadEspecifico(
                    (int) TABLA.getValueAt(filaselected, 0));
        }
        DataActividad.Disconneting();
        return ActividadSeleccionado;
    }

    public Object[] getActividadSeleccionadoRow() {
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            String ID = TABLA.getValueAt(filaselected, 0).toString();
            String Actividad = TABLA.getValueAt(filaselected, 1).toString();
            Object fila[] = new Object[]{ID, Actividad};
            DataActividad.Disconneting();
            return fila;
        }
        return null;
    }

    public void setEventAction(ActionListener event) {
        BTN_AGREGAR.addActionListener(event);
    }
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        GlassPanePopup.closePopupLast();
        DataActividad.Disconneting();
    }//GEN-LAST:event_button1ActionPerformed

    private void BTN_AGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGARActionPerformed
    }//GEN-LAST:event_BTN_AGREGARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Button.Button BTN_AGREGAR;
    private com.mycompany.Swing.Tabla.Tabla TABLA;
    private static com.mycompany.Swing.TextField.TextField TXT_BUSQUEDA;
    private com.mycompany.Swing.Button.Button button1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.mycompany.Swing.Panel.Panel panel1;
    private com.mycompany.Swing.Panel.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
