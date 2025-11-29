package com.mycompany.LuxcarForm.FormsServicio;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ControlMaterial;
import com.mycompany.DataBase.Control.ControlTrabajador;
import com.mycompany.Swing.TextField.Filter.TxtDecimalSize;
import com.mycompany.Swing.TextField.Filter.TxtIntegerSize;
import com.mycompany.Swing.TextField.Filter.TxtUpper;
import com.mycompany.Util.Glasspanepopup.DefaultOption;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class PopupObtenerMaterial extends javax.swing.JPanel {

    public ControlMaterial DataMaterial;
    private DefaultTableModel MaterialesAgregados;

    public PopupObtenerMaterial() {
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
             @Override
            public float opacity() {
                return 0.5f;
            }
        });
    }

    public void InicializarDocuments() {
        CANTIDAD.setDocument(new TxtIntegerSize(3) {
        });
        TXT_BUSQUEDA.setDocument(new TxtUpper() {
        });
    }

    public PopupObtenerMaterial(DefaultTableModel TablaMaterialesAgregados) {
        this();
        MaterialesAgregados = TablaMaterialesAgregados;
        MostrarTablaMaterial();

    }

    public void InicializarIconos() {
        TXT_BUSQUEDA.setIcon(
                new FlatSVGIcon("svg/buscar.svg", 25, 25));
    }

    public void IniciarConexion() {
        DataMaterial = new ControlMaterial();
    }

    public void MostrarTablaMaterial() {
        DataMaterial.MostrarTablaMaterialBusqueda(TXT_BUSQUEDA.getText());
        VerificarMaterialesAgregados((DefaultTableModel) TABLA.getModel());
    }

    public void VerificarMaterialesAgregados(DefaultTableModel TabalaMaterialCompleta) {
        for (int i = TabalaMaterialCompleta.getRowCount() - 1; i >= 0; i--) {
            int valorCompleto = Integer.parseInt(TabalaMaterialCompleta.getValueAt(i, 0).toString());

            for (int j = 0; j < MaterialesAgregados.getRowCount(); j++) {
                int valorAgregado = Integer.parseInt(MaterialesAgregados.getValueAt(j, 0).toString());

                if (valorCompleto == valorAgregado) { // Comparando enteros
                    TabalaMaterialCompleta.removeRow(i);
                    break;
                }
            }
        }
        TABLA.setModel(TabalaMaterialCompleta);
    }

    public void InicializarTabla() {

        TABLA.setHorizontalTextPositionHeader(new int[]{
            SwingConstants.CENTER,//1 DNI
            SwingConstants.LEFT,//2 Nombres
            SwingConstants.LEFT,//3 Apellidos
            SwingConstants.LEFT,//9 Puesto
            SwingConstants.CENTER//9 CobroPorHora
        });
        TABLA.setHorizontalTextPosition(new int[]{
            SwingConstants.CENTER,//1 DNI
            SwingConstants.LEFT,//2 Nombres
            SwingConstants.LEFT,//3 Apellidos
            SwingConstants.LEFT,//9 Puesto
            SwingConstants.RIGHT//9 CobroPorHora
        });
        TABLA.FixScroll(jScrollPane1);
        DataMaterial = new ControlMaterial((DefaultTableModel) TABLA.getModel());

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
        jLabel3 = new javax.swing.JLabel();
        CANTIDAD = new com.mycompany.Swing.TextField.TextField();

        setOpaque(false);

        panel2.setBackground(new java.awt.Color(250, 250, 255));
        panel2.setPanel_BackgroundGradientActived(true);
        panel2.setPanel_BackgroundGradientColor1(new java.awt.Color(250, 250, 255));
        panel2.setPanel_BackgroundGradientColor2(new java.awt.Color(240, 240, 255));

        TXT_BUSQUEDA.setTextField_ShadowSize(3);
        TXT_BUSQUEDA.setTextField_Txthint("Buscar Material");
        TXT_BUSQUEDA.setTextField_TxthintColor(new java.awt.Color(102, 102, 102));
        TXT_BUSQUEDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSQUEDAKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(16, 78, 128));
        jLabel2.setText("Buscar Material");

        panel1.setPanel_Round(5);
        panel1.setPanel_ShadowOpacity(0.3F);
        panel1.setPanel_ShadowSize(3);

        TABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID_Material", "Nombre", "Descripcion", "Unidad de Medida", "Precio Unitario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            TABLA.getColumnModel().getColumn(1).setPreferredWidth(130);
            TABLA.getColumnModel().getColumn(2).setResizable(false);
            TABLA.getColumnModel().getColumn(2).setPreferredWidth(130);
            TABLA.getColumnModel().getColumn(3).setResizable(false);
            TABLA.getColumnModel().getColumn(3).setPreferredWidth(130);
            TABLA.getColumnModel().getColumn(4).setResizable(false);
            TABLA.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
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

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(16, 78, 128));
        jLabel3.setText("Inserte una cantidad: ");

        CANTIDAD.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        CANTIDAD.setTextField_ActivedIconColorFilter(true);
        CANTIDAD.setTextField_BorderActived(true);
        CANTIDAD.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        CANTIDAD.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        CANTIDAD.setTextField_Round(5);
        CANTIDAD.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        CANTIDAD.setTextField_ShadowOpacity(0.3F);
        CANTIDAD.setTextField_ShadowSize(3);
        CANTIDAD.setTextField_Txthint("000");
        CANTIDAD.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CANTIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_AGREGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(TXT_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CANTIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_AGREGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_BUSQUEDAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSQUEDAKeyReleased

        MostrarTablaMaterial();
    }//GEN-LAST:event_TXT_BUSQUEDAKeyReleased

    private void TABLAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLAMousePressed
        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {
            BTN_AGREGAR.setEnabled(true);
        } else {
            BTN_AGREGAR.setEnabled(false);
        }
    }//GEN-LAST:event_TABLAMousePressed

    public int getCantidad() {
        return Integer.parseInt(CANTIDAD.getText());
    }

    public String getHorasEjecutasString() {
        return CANTIDAD.getText();
    }
public void setenabledbuttonadd(boolean bol){
        BTN_AGREGAR.setEnabled(bol);
    }
    public Object[] getMaterialSeleccionado() {

        int filaselected = TABLA.getSelectedRow();
        if (filaselected > -1) {

            String ID_MATERIAL = TABLA.getValueAt(filaselected, 0).toString();
            String NOMBRE = TABLA.getValueAt(filaselected, 1).toString();
            String DESCRIPCION = TABLA.getValueAt(filaselected, 2).toString();
            String UNIDADMEDIDA = TABLA.getValueAt(filaselected, 3).toString();
            double PrecioUnitario = Double.parseDouble(TABLA.getValueAt(filaselected, 4).toString());
            int Cantidad;
            if (getHorasEjecutasString().equals("")) {
                Cantidad = 0;
            } else {
                Cantidad = getCantidad();
            }

            Object fila[] = new Object[]{
                ID_MATERIAL,
                DESCRIPCION,
                UNIDADMEDIDA,
                Cantidad,
                PrecioUnitario,
                Cantidad * PrecioUnitario

            };

            DataMaterial.Disconneting();
            return fila;
        }

        return null;

    }

    public void setEventAction(ActionListener event) {
        BTN_AGREGAR.addActionListener(event);
    }
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        button1.setEnabled(false);
        GlassPanePopup.closePopupLast();
        DataMaterial.Disconneting();
    }//GEN-LAST:event_button1ActionPerformed

    private void BTN_AGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGARActionPerformed
    }//GEN-LAST:event_BTN_AGREGARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Button.Button BTN_AGREGAR;
    private com.mycompany.Swing.TextField.TextField CANTIDAD;
    private com.mycompany.Swing.Tabla.Tabla TABLA;
    private static com.mycompany.Swing.TextField.TextField TXT_BUSQUEDA;
    private com.mycompany.Swing.Button.Button button1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.mycompany.Swing.Panel.Panel panel1;
    private com.mycompany.Swing.Panel.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
