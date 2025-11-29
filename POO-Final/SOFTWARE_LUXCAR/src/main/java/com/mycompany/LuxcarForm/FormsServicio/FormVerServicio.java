/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.LuxcarForm.FormsServicio;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.mycompany.DataBase.Control.ControlMaterial;
import com.mycompany.DataBase.Control.ControlServicio;
import com.mycompany.DataBase.Control.ControlTrabajador;
import com.mycompany.DataBase.Control.ServicioClass;
import com.mycompany.LuxcarDocuments.Document;
import com.mycompany.LuxcarDocuments.PopupViewDocument;
import com.mycompany.LuxcarForm.FormServicio;
import com.mycompany.Popup.PopupMessage;
import com.mycompany.Util.Glasspanepopup.DefaultOption;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class FormVerServicio extends javax.swing.JPanel {

    /**
     * Creates new form FormVerServicio
     *
     */
    ServicioClass service = null;

    public FormVerServicio() {
        initComponents();
        InicializarTablaTrabajador();
        InicializarTablaActividad();
        InicializarTablaMaterial();
        TITTLE.setIcon(new FlatSVGIcon("svg/service.svg",70,70));
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
                return 0.4f;
            }
            

        });
    }

    public FormVerServicio(ServicioClass Servicio) {
        this();

        ID_SERVICIO.setText(String.valueOf(Servicio.getIDServicio()));
        DESCRIPCION.setText(Servicio.getDescripcion());
        UBICACION.setText(Servicio.getUbicacion());
        FECHA_EJECUCION.setText(Servicio.getFechaInicio().toString());
        if (Servicio.getFechaFinalizacion() != null) {
            TXT_FECHA_FINALIZACION.setText(Servicio.getFechaFinalizacion().toString());
        } else {
            TXT_FECHA_FINALIZACION.setText("Sin definir.");
        }

        //ESTADO.setText(Servicio.getEstado());
        service = Servicio;

        ControlServicio cs = new ControlServicio();
        cs.getTablaTrabajoresOfServicio(Servicio.getIDServicio(), (DefaultTableModel) TABLA_TRABAJADOR.getModel());
        cs.getTablaActividadOfServicio(Servicio.getIDServicio(), (DefaultTableModel) TABLA_ACTIVIDAD.getModel());
        cs.getTablaMaterialesOfServicio(Servicio.getIDServicio(), (DefaultTableModel) TABLA_MATERIAL.getModel());
        cs.Disconneting();
        CalcularMontos();

    }

    public void CalcularMontos() {
        DecimalFormat df = new DecimalFormat("$ ##0.00");
        double MontoManoObra = 0.0;
        for (int i = TABLA_TRABAJADOR.getRowCount() - 1; i >= 0; i--) {
            MontoManoObra = MontoManoObra + Double.parseDouble(TABLA_TRABAJADOR.getValueAt(i, 6).toString());
        }
        MONTO_OBRA.setText(df.format(MontoManoObra)/*String.valueOf(MontoManoObra)*/);

        double MontoMateriales = 0.0;
        for (int i = TABLA_MATERIAL.getRowCount() - 1; i >= 0; i--) {
            MontoMateriales = MontoMateriales + Double.parseDouble(TABLA_MATERIAL.getValueAt(i, 5).toString());
        }
        MONTO_MATERIAL.setText(df.format(MontoMateriales));
        TOTAL_OTM.setText(df.format(MontoManoObra + MontoMateriales));

    }

    public void InicializarTablaTrabajador() {

        TABLA_TRABAJADOR.setHorizontalTextPositionHeader(new int[]{
            SwingConstants.CENTER,
            SwingConstants.LEFT,
            SwingConstants.LEFT,
            SwingConstants.LEFT,
            SwingConstants.CENTER,
            SwingConstants.CENTER,
            SwingConstants.CENTER
        });
        TABLA_TRABAJADOR.setHorizontalTextPosition(new int[]{
            SwingConstants.CENTER,
            SwingConstants.LEFT,
            SwingConstants.LEFT,
            SwingConstants.LEFT,
            SwingConstants.CENTER,
            SwingConstants.CENTER,
            SwingConstants.CENTER
        });
        TABLA_TRABAJADOR.FixScroll(jScrollPane2);

    }

    public void InicializarTablaActividad() {

        TABLA_ACTIVIDAD.setHorizontalTextPositionHeader(new int[]{
            SwingConstants.CENTER,
            SwingConstants.LEFT
        });
        TABLA_ACTIVIDAD.setHorizontalTextPosition(new int[]{
            SwingConstants.CENTER,
            SwingConstants.LEFT
        });
        TABLA_ACTIVIDAD.FixScroll(jScrollPane3);

    }

    public void InicializarTablaMaterial() {

        TABLA_MATERIAL.setHorizontalTextPositionHeader(new int[]{
            SwingConstants.CENTER,
            SwingConstants.LEFT,
            SwingConstants.CENTER,
            SwingConstants.CENTER,
            SwingConstants.CENTER,
            SwingConstants.CENTER

        });
        TABLA_MATERIAL.setHorizontalTextPosition(new int[]{
            SwingConstants.CENTER,
            SwingConstants.LEFT,
            SwingConstants.CENTER,
            SwingConstants.CENTER,
            SwingConstants.CENTER,
            SwingConstants.CENTER
        });
        TABLA_MATERIAL.FixScroll(jScrollPane4);

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
        button1 = new com.mycompany.Swing.Button.Button();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        UBICACION = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DESCRIPCION = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TXT_FECHA_FINALIZACION = new javax.swing.JLabel();
        FECHA_EJECUCION = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panel2 = new com.mycompany.Swing.Panel.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABLA_TRABAJADOR = new com.mycompany.Swing.Tabla.Tabla();
        TITTLE3 = new com.mycompany.Swing.Label.LabelIcon();
        BTN_QUITAR_TRABAJADOR = new com.mycompany.Swing.Button.Button();
        BTN_AGREGAR_TRABAJADOR = new com.mycompany.Swing.Button.Button();
        jSeparator3 = new javax.swing.JSeparator();
        TITTLE4 = new com.mycompany.Swing.Label.LabelIcon();
        BTN_QUITAR_ACTIVIDAD = new com.mycompany.Swing.Button.Button();
        BTN_AGREGAR_TRABAJADOR1 = new com.mycompany.Swing.Button.Button();
        jSeparator4 = new javax.swing.JSeparator();
        panel3 = new com.mycompany.Swing.Panel.Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABLA_ACTIVIDAD = new com.mycompany.Swing.Tabla.Tabla();
        panel4 = new com.mycompany.Swing.Panel.Panel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TABLA_MATERIAL = new com.mycompany.Swing.Tabla.Tabla();
        TITTLE5 = new com.mycompany.Swing.Label.LabelIcon();
        BTN_QUITAR_MATERIAL = new com.mycompany.Swing.Button.Button();
        BTN_AGREGAR_TRABAJADOR2 = new com.mycompany.Swing.Button.Button();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MONTO_MATERIAL = new javax.swing.JLabel();
        MONTO_OBRA = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TOTAL_OTM = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        BTN_GUARDAR = new com.mycompany.Swing.Button.Button();
        button3 = new com.mycompany.Swing.Button.Button();
        jButton1 = new javax.swing.JButton();
        panel6 = new com.mycompany.Swing.Panel.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ID_SERVICIO = new javax.swing.JLabel();
        TITTLE = new com.mycompany.Swing.Label.LabelIcon();
        document1 = new com.mycompany.LuxcarDocuments.Document();

        setOpaque(false);

        panel1.setPanel_BackgroundGradientActived(true);
        panel1.setPanel_BackgroundGradientColor2(new java.awt.Color(240, 240, 255));
        panel1.setPanel_BorderActived(true);
        panel1.setPanel_BorderColor(new java.awt.Color(0, 0, 0));
        panel1.setPanel_Round(7);
        panel1.setPanel_ShadowOpacity(0.0F);
        panel1.setPanel_ShadowSize(0);

        button1.setBackground(new java.awt.Color(16, 78, 128));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Finalizar Servicio");
        button1.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        button1.setButton_Round(7);
        button1.setButton_ShadowSize(3);
        button1.setButton_ShawdowOpacity(0.3F);
        button1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(16, 78, 128));
        jLabel2.setText("Datos del servicio");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        jPanel4.setOpaque(false);

        UBICACION.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        UBICACION.setText("Ubicacion sel servicio");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(16, 78, 128));
        jLabel3.setText("Ubicacion:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(16, 78, 128));
        jLabel5.setText("Descripció: ");

        DESCRIPCION.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DESCRIPCION.setText("Descripcion del servicio.");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(16, 78, 128));
        jLabel11.setText("Fecha de finalizacion: ");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(16, 78, 128));
        jLabel7.setText("Fecha de ejecución: ");

        TXT_FECHA_FINALIZACION.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TXT_FECHA_FINALIZACION.setText("dd / MM / YYYY     HH:mm:ss ");

        FECHA_EJECUCION.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        FECHA_EJECUCION.setText("dd / MM / YYYY     HH:mm:ss ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DESCRIPCION, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(UBICACION, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FECHA_EJECUCION)
                    .addComponent(TXT_FECHA_FINALIZACION))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(UBICACION))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(DESCRIPCION)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FECHA_EJECUCION, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(TXT_FECHA_FINALIZACION, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        jPanel3.setOpaque(false);

        panel2.setPanel_Round(7);
        panel2.setPanel_ShadowColor(new java.awt.Color(0, 0, 0));
        panel2.setPanel_ShadowOpacity(0.3F);
        panel2.setPanel_ShadowSize(3);

        TABLA_TRABAJADOR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombres", "Apelldios", "Puesto", "H.E", "HH", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLA_TRABAJADOR.setHeader_BackgroundColor(new java.awt.Color(16, 78, 128));
        TABLA_TRABAJADOR.setHeader_BorderActived(false);
        TABLA_TRABAJADOR.setHeader_Font(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        TABLA_TRABAJADOR.setHeader_ForegroundColor(new java.awt.Color(255, 255, 255));
        TABLA_TRABAJADOR.setHeader_Round(7);
        TABLA_TRABAJADOR.setRowHeight(29);
        TABLA_TRABAJADOR.setRow_Font(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        TABLA_TRABAJADOR.setRow_SelectedColor(new java.awt.Color(230, 230, 255));
        TABLA_TRABAJADOR.setTable_Border(null);
        TABLA_TRABAJADOR.setTable_GridLineColor(new java.awt.Color(204, 204, 204));
        TABLA_TRABAJADOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TABLA_TRABAJADORMousePressed(evt);
            }
        });
        TABLA_TRABAJADOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TABLA_TRABAJADORKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TABLA_TRABAJADOR);
        if (TABLA_TRABAJADOR.getColumnModel().getColumnCount() > 0) {
            TABLA_TRABAJADOR.getColumnModel().getColumn(0).setResizable(false);
            TABLA_TRABAJADOR.getColumnModel().getColumn(0).setPreferredWidth(30);
            TABLA_TRABAJADOR.getColumnModel().getColumn(1).setResizable(false);
            TABLA_TRABAJADOR.getColumnModel().getColumn(1).setPreferredWidth(100);
            TABLA_TRABAJADOR.getColumnModel().getColumn(2).setResizable(false);
            TABLA_TRABAJADOR.getColumnModel().getColumn(2).setPreferredWidth(100);
            TABLA_TRABAJADOR.getColumnModel().getColumn(3).setResizable(false);
            TABLA_TRABAJADOR.getColumnModel().getColumn(3).setPreferredWidth(100);
            TABLA_TRABAJADOR.getColumnModel().getColumn(4).setResizable(false);
            TABLA_TRABAJADOR.getColumnModel().getColumn(4).setPreferredWidth(20);
            TABLA_TRABAJADOR.getColumnModel().getColumn(5).setResizable(false);
            TABLA_TRABAJADOR.getColumnModel().getColumn(5).setPreferredWidth(20);
            TABLA_TRABAJADOR.getColumnModel().getColumn(6).setResizable(false);
            TABLA_TRABAJADOR.getColumnModel().getColumn(6).setPreferredWidth(30);
        }

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        TITTLE3.setForeground(new java.awt.Color(16, 78, 128));
        TITTLE3.setText("Trabajadores encargados");
        TITTLE3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TITTLE3.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE3.setIconColorFilterActived(true);

        BTN_QUITAR_TRABAJADOR.setBackground(new java.awt.Color(16, 78, 128));
        BTN_QUITAR_TRABAJADOR.setBorder(null);
        BTN_QUITAR_TRABAJADOR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_QUITAR_TRABAJADOR.setText("-");
        BTN_QUITAR_TRABAJADOR.setButton_BackgroundColorEntered(new java.awt.Color(46, 98, 128));
        BTN_QUITAR_TRABAJADOR.setButton_Round(7);
        BTN_QUITAR_TRABAJADOR.setButton_ShadowColor(new java.awt.Color(82, 133, 255));
        BTN_QUITAR_TRABAJADOR.setButton_ShadowSize(3);
        BTN_QUITAR_TRABAJADOR.setButton_ShawdowOpacity(0.3F);
        BTN_QUITAR_TRABAJADOR.setEnabled(false);
        BTN_QUITAR_TRABAJADOR.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        BTN_QUITAR_TRABAJADOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_QUITAR_TRABAJADORActionPerformed(evt);
            }
        });

        BTN_AGREGAR_TRABAJADOR.setBackground(new java.awt.Color(16, 78, 128));
        BTN_AGREGAR_TRABAJADOR.setBorder(null);
        BTN_AGREGAR_TRABAJADOR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_TRABAJADOR.setText("+");
        BTN_AGREGAR_TRABAJADOR.setButton_BackgroundColorEntered(new java.awt.Color(46, 98, 128));
        BTN_AGREGAR_TRABAJADOR.setButton_Round(7);
        BTN_AGREGAR_TRABAJADOR.setButton_ShadowColor(new java.awt.Color(82, 133, 255));
        BTN_AGREGAR_TRABAJADOR.setButton_ShadowSize(3);
        BTN_AGREGAR_TRABAJADOR.setButton_ShawdowOpacity(0.3F);
        BTN_AGREGAR_TRABAJADOR.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        BTN_AGREGAR_TRABAJADOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_TRABAJADORActionPerformed(evt);
            }
        });

        TITTLE4.setForeground(new java.awt.Color(16, 78, 128));
        TITTLE4.setText("Actividades realizadas");
        TITTLE4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TITTLE4.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE4.setIconColorFilterActived(true);

        BTN_QUITAR_ACTIVIDAD.setBackground(new java.awt.Color(16, 78, 128));
        BTN_QUITAR_ACTIVIDAD.setBorder(null);
        BTN_QUITAR_ACTIVIDAD.setForeground(new java.awt.Color(255, 255, 255));
        BTN_QUITAR_ACTIVIDAD.setText("-");
        BTN_QUITAR_ACTIVIDAD.setButton_BackgroundColorEntered(new java.awt.Color(46, 98, 128));
        BTN_QUITAR_ACTIVIDAD.setButton_Round(7);
        BTN_QUITAR_ACTIVIDAD.setButton_ShadowColor(new java.awt.Color(82, 133, 255));
        BTN_QUITAR_ACTIVIDAD.setButton_ShadowSize(3);
        BTN_QUITAR_ACTIVIDAD.setButton_ShawdowOpacity(0.3F);
        BTN_QUITAR_ACTIVIDAD.setEnabled(false);
        BTN_QUITAR_ACTIVIDAD.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        BTN_QUITAR_ACTIVIDAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_QUITAR_ACTIVIDADActionPerformed(evt);
            }
        });

        BTN_AGREGAR_TRABAJADOR1.setBackground(new java.awt.Color(16, 78, 128));
        BTN_AGREGAR_TRABAJADOR1.setBorder(null);
        BTN_AGREGAR_TRABAJADOR1.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_TRABAJADOR1.setText("+");
        BTN_AGREGAR_TRABAJADOR1.setButton_BackgroundColorEntered(new java.awt.Color(46, 98, 128));
        BTN_AGREGAR_TRABAJADOR1.setButton_Round(7);
        BTN_AGREGAR_TRABAJADOR1.setButton_ShadowColor(new java.awt.Color(82, 133, 255));
        BTN_AGREGAR_TRABAJADOR1.setButton_ShadowSize(3);
        BTN_AGREGAR_TRABAJADOR1.setButton_ShawdowOpacity(0.3F);
        BTN_AGREGAR_TRABAJADOR1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        BTN_AGREGAR_TRABAJADOR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_TRABAJADOR1ActionPerformed(evt);
            }
        });

        panel3.setPanel_Round(7);
        panel3.setPanel_ShadowColor(new java.awt.Color(0, 0, 0));
        panel3.setPanel_ShadowOpacity(0.3F);
        panel3.setPanel_ShadowSize(3);

        TABLA_ACTIVIDAD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Actividad", "Descripcion de la actividad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLA_ACTIVIDAD.setHeader_BackgroundColor(new java.awt.Color(16, 78, 128));
        TABLA_ACTIVIDAD.setHeader_BorderActived(false);
        TABLA_ACTIVIDAD.setHeader_Font(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        TABLA_ACTIVIDAD.setHeader_ForegroundColor(new java.awt.Color(255, 255, 255));
        TABLA_ACTIVIDAD.setHeader_Round(7);
        TABLA_ACTIVIDAD.setRowHeight(25);
        TABLA_ACTIVIDAD.setRow_Font(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        TABLA_ACTIVIDAD.setRow_SelectedColor(new java.awt.Color(230, 230, 255));
        TABLA_ACTIVIDAD.setTable_Border(null);
        TABLA_ACTIVIDAD.setTable_GridLineColor(new java.awt.Color(204, 204, 204));
        TABLA_ACTIVIDAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TABLA_ACTIVIDADMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TABLA_ACTIVIDAD);
        if (TABLA_ACTIVIDAD.getColumnModel().getColumnCount() > 0) {
            TABLA_ACTIVIDAD.getColumnModel().getColumn(0).setResizable(false);
            TABLA_ACTIVIDAD.getColumnModel().getColumn(0).setPreferredWidth(50);
            TABLA_ACTIVIDAD.getColumnModel().getColumn(1).setResizable(false);
            TABLA_ACTIVIDAD.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3)
                .addGap(5, 5, 5))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        panel4.setPanel_Round(7);
        panel4.setPanel_ShadowColor(new java.awt.Color(0, 0, 0));
        panel4.setPanel_ShadowOpacity(0.3F);
        panel4.setPanel_ShadowSize(3);

        TABLA_MATERIAL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Material", "Descripcion", "Unidad Medida", "Cantidad", "P. Unitario", "P. Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLA_MATERIAL.setHeader_BackgroundColor(new java.awt.Color(16, 78, 128));
        TABLA_MATERIAL.setHeader_BorderActived(false);
        TABLA_MATERIAL.setHeader_Font(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        TABLA_MATERIAL.setHeader_ForegroundColor(new java.awt.Color(255, 255, 255));
        TABLA_MATERIAL.setHeader_Round(7);
        TABLA_MATERIAL.setRowHeight(23);
        TABLA_MATERIAL.setRow_Font(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        TABLA_MATERIAL.setRow_SelectedColor(new java.awt.Color(230, 230, 255));
        TABLA_MATERIAL.setTable_Border(null);
        TABLA_MATERIAL.setTable_GridLineColor(new java.awt.Color(204, 204, 204));
        TABLA_MATERIAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TABLA_MATERIALMousePressed(evt);
            }
        });
        TABLA_MATERIAL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TABLA_MATERIALKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(TABLA_MATERIAL);
        if (TABLA_MATERIAL.getColumnModel().getColumnCount() > 0) {
            TABLA_MATERIAL.getColumnModel().getColumn(0).setResizable(false);
            TABLA_MATERIAL.getColumnModel().getColumn(0).setPreferredWidth(50);
            TABLA_MATERIAL.getColumnModel().getColumn(1).setResizable(false);
            TABLA_MATERIAL.getColumnModel().getColumn(1).setPreferredWidth(400);
            TABLA_MATERIAL.getColumnModel().getColumn(2).setResizable(false);
            TABLA_MATERIAL.getColumnModel().getColumn(2).setPreferredWidth(100);
            TABLA_MATERIAL.getColumnModel().getColumn(3).setResizable(false);
            TABLA_MATERIAL.getColumnModel().getColumn(4).setResizable(false);
            TABLA_MATERIAL.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        TITTLE5.setForeground(new java.awt.Color(16, 78, 128));
        TITTLE5.setText("Registrar Material Registrado");
        TITTLE5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TITTLE5.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE5.setIconColorFilterActived(true);

        BTN_QUITAR_MATERIAL.setBackground(new java.awt.Color(16, 78, 128));
        BTN_QUITAR_MATERIAL.setBorder(null);
        BTN_QUITAR_MATERIAL.setForeground(new java.awt.Color(255, 255, 255));
        BTN_QUITAR_MATERIAL.setText("-");
        BTN_QUITAR_MATERIAL.setButton_BackgroundColorEntered(new java.awt.Color(46, 98, 128));
        BTN_QUITAR_MATERIAL.setButton_Round(7);
        BTN_QUITAR_MATERIAL.setButton_ShadowColor(new java.awt.Color(82, 133, 255));
        BTN_QUITAR_MATERIAL.setButton_ShadowSize(3);
        BTN_QUITAR_MATERIAL.setButton_ShawdowOpacity(0.3F);
        BTN_QUITAR_MATERIAL.setEnabled(false);
        BTN_QUITAR_MATERIAL.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        BTN_QUITAR_MATERIAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_QUITAR_MATERIALActionPerformed(evt);
            }
        });

        BTN_AGREGAR_TRABAJADOR2.setBackground(new java.awt.Color(16, 78, 128));
        BTN_AGREGAR_TRABAJADOR2.setBorder(null);
        BTN_AGREGAR_TRABAJADOR2.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_TRABAJADOR2.setText("+");
        BTN_AGREGAR_TRABAJADOR2.setButton_BackgroundColorEntered(new java.awt.Color(46, 98, 128));
        BTN_AGREGAR_TRABAJADOR2.setButton_Round(7);
        BTN_AGREGAR_TRABAJADOR2.setButton_ShadowColor(new java.awt.Color(82, 133, 255));
        BTN_AGREGAR_TRABAJADOR2.setButton_ShadowSize(3);
        BTN_AGREGAR_TRABAJADOR2.setButton_ShawdowOpacity(0.3F);
        BTN_AGREGAR_TRABAJADOR2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        BTN_AGREGAR_TRABAJADOR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_TRABAJADOR2ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(16, 78, 128)));
        jPanel5.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(16, 78, 128));
        jLabel4.setText("Total Materiales : ");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(16, 78, 128));
        jLabel6.setText("Total mano de obra: ");

        MONTO_MATERIAL.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        MONTO_MATERIAL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        MONTO_MATERIAL.setText("$ 00.00");

        MONTO_OBRA.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        MONTO_OBRA.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        MONTO_OBRA.setText("$ 00.00");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(16, 78, 128));
        jLabel8.setText("Costo total OTM: ");

        TOTAL_OTM.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TOTAL_OTM.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        TOTAL_OTM.setText("$ 00.00");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(16, 78, 128));
        jLabel10.setText("Pago totales ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator6)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(MONTO_MATERIAL, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                        .addComponent(MONTO_OBRA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(TOTAL_OTM, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(MONTO_MATERIAL)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(MONTO_OBRA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TOTAL_OTM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TITTLE5, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1052, 1052, 1052))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(TITTLE3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_QUITAR_TRABAJADOR, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_AGREGAR_TRABAJADOR, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(TITTLE4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_QUITAR_ACTIVIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_AGREGAR_TRABAJADOR1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(BTN_QUITAR_MATERIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_AGREGAR_TRABAJADOR2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BTN_AGREGAR_TRABAJADOR1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BTN_QUITAR_ACTIVIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TITTLE4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TITTLE3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTN_AGREGAR_TRABAJADOR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_QUITAR_TRABAJADOR, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTN_AGREGAR_TRABAJADOR2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTN_QUITAR_MATERIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TITTLE5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        BTN_GUARDAR.setBackground(new java.awt.Color(16, 78, 128));
        BTN_GUARDAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_GUARDAR.setText("Guardar");
        BTN_GUARDAR.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_GUARDAR.setButton_Round(7);
        BTN_GUARDAR.setButton_ShadowSize(3);
        BTN_GUARDAR.setButton_ShawdowOpacity(0.3F);
        BTN_GUARDAR.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        BTN_GUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GUARDARActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(16, 78, 128));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Imprimir");
        button3.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        button3.setButton_Round(7);
        button3.setButton_ShadowSize(3);
        button3.setButton_ShawdowOpacity(0.3F);
        button3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        jButton1.setText("Ver documento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panel6.setPanel_BackgroundGradientActived(true);
        panel6.setPanel_BackgroundGradientColor1(new java.awt.Color(16, 78, 128));
        panel6.setPanel_BackgroundGradientColor2(new java.awt.Color(46, 98, 128));
        panel6.setPanel_Round(7);
        panel6.setPanel_ShadowSize(0);

        jPanel1.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Servicio: ");

        ID_SERVICIO.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        ID_SERVICIO.setForeground(new java.awt.Color(255, 255, 255));
        ID_SERVICIO.setText("000");

        TITTLE.setForeground(new java.awt.Color(255, 255, 255));
        TITTLE.setText("REGISTRO DEL SERVICIO");
        TITTLE.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        TITTLE.setIconColorFilterActived(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(TITTLE, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ID_SERVICIO)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9)
                .addComponent(ID_SERVICIO))
            .addComponent(TITTLE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(735, 735, 735)
                        .addComponent(BTN_GUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 40, Short.MAX_VALUE))
            .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BTN_GUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );

        document1.setPreferredSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 727, Short.MAX_VALUE)
                    .addComponent(document1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 728, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(document1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TABLA_TRABAJADORMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_TRABAJADORMousePressed
        // TODO add your handling code here:
        int filaselected = TABLA_TRABAJADOR.getSelectedRow();
        if (filaselected > -1) {
            BTN_QUITAR_TRABAJADOR.setEnabled(true);
        } else {
            BTN_QUITAR_TRABAJADOR.setEnabled(false);
        }
    }//GEN-LAST:event_TABLA_TRABAJADORMousePressed

    private void BTN_QUITAR_TRABAJADORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_QUITAR_TRABAJADORActionPerformed

        int filaselected = TABLA_TRABAJADOR.getSelectedRow();
        if (filaselected > -1) {
            DefaultTableModel model = (DefaultTableModel) TABLA_TRABAJADOR.getModel();
            model.removeRow(filaselected);

            TABLA_TRABAJADOR.setModel(model);
            BTN_QUITAR_TRABAJADOR.setEnabled(false);
            CalcularMontos();

        }
    }//GEN-LAST:event_BTN_QUITAR_TRABAJADORActionPerformed

    private void BTN_AGREGAR_TRABAJADORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_TRABAJADORActionPerformed

        if (TABLA_TRABAJADOR.getRowCount() < 6) {

            PopupObtenerTrabajador getTrabajador = new PopupObtenerTrabajador((DefaultTableModel) TABLA_TRABAJADOR.getModel());
            getTrabajador.setEventAction(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getTrabajador.setenabledbuttonadd(false);
                    TABLA_TRABAJADOR.addRow(getTrabajador.getTrabajadorSeleccionadoRow());
                    GlassPanePopup.closePopupLast();
                    CalcularMontos();

                }
            });
        } else {
            new PopupMessage(
                    "LISTA TRABAJADAOR",
                    "No puede insertar a mas trabajadores",
                    3
            );
        }

    }//GEN-LAST:event_BTN_AGREGAR_TRABAJADORActionPerformed

    private void BTN_QUITAR_ACTIVIDADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_QUITAR_ACTIVIDADActionPerformed
        // TODO add your handling code here:
        int filaselected = TABLA_ACTIVIDAD.getSelectedRow();
        if (filaselected > -1) {
            DefaultTableModel model = (DefaultTableModel) TABLA_ACTIVIDAD.getModel();
            model.removeRow(filaselected);
            TABLA_ACTIVIDAD.setModel(model);
            BTN_QUITAR_TRABAJADOR.setEnabled(false);

        }
    }//GEN-LAST:event_BTN_QUITAR_ACTIVIDADActionPerformed

    private void BTN_AGREGAR_TRABAJADOR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_TRABAJADOR1ActionPerformed

        if (TABLA_ACTIVIDAD.getRowCount() < 7) {
            PopupObtenerActividad getActividad = new PopupObtenerActividad((DefaultTableModel) TABLA_ACTIVIDAD.getModel());
            getActividad.setEventAction(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getActividad.setenabledbuttonadd(false);
                    TABLA_ACTIVIDAD.addRow(getActividad.getActividadSeleccionadoRow());
                    GlassPanePopup.closePopupLast();

                }
            });
        } else {
            new PopupMessage(
                    "LISTA ACTIVIDAD",
                    "No puede insertar a mas actividades",
                    3
            );
        }
    }//GEN-LAST:event_BTN_AGREGAR_TRABAJADOR1ActionPerformed

    private void TABLA_ACTIVIDADMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_ACTIVIDADMousePressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int filaselected = TABLA_ACTIVIDAD.getSelectedRow();
        if (filaselected > -1) {
            BTN_QUITAR_ACTIVIDAD.setEnabled(true);
        } else {
            BTN_QUITAR_ACTIVIDAD.setEnabled(false);
        }
    }//GEN-LAST:event_TABLA_ACTIVIDADMousePressed

    private void TABLA_MATERIALMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_MATERIALMousePressed
        // TODO add your handling code here:
        int filaselected = TABLA_MATERIAL.getSelectedRow();
        if (filaselected > -1) {
            BTN_QUITAR_MATERIAL.setEnabled(true);
        } else {
            BTN_QUITAR_MATERIAL.setEnabled(false);
        }
    }//GEN-LAST:event_TABLA_MATERIALMousePressed

    private void BTN_QUITAR_MATERIALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_QUITAR_MATERIALActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int filaselected = TABLA_MATERIAL.getSelectedRow();
        if (filaselected > -1) {
            DefaultTableModel model = (DefaultTableModel) TABLA_MATERIAL.getModel();
            model.removeRow(filaselected);
            TABLA_MATERIAL.setModel(model);
            BTN_QUITAR_MATERIAL.setEnabled(false);
            CalcularMontos();

        }
    }//GEN-LAST:event_BTN_QUITAR_MATERIALActionPerformed

    private void BTN_AGREGAR_TRABAJADOR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_TRABAJADOR2ActionPerformed
        // TODO add your handling code here:
        if (TABLA_MATERIAL.getRowCount() < 10) {
            PopupObtenerMaterial getMaterial = new PopupObtenerMaterial((DefaultTableModel) TABLA_MATERIAL.getModel());
            getMaterial.setEventAction(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getMaterial.setenabledbuttonadd(false);
                    TABLA_MATERIAL.addRow(getMaterial.getMaterialSeleccionado());

                    GlassPanePopup.closePopupLast();
                    CalcularMontos();

                }
            });
        } else {
            new PopupMessage(
                    "LISTA MATERIAL",
                    "No puede insertar a mas materiales : 10",
                    3
            );
        }
    }//GEN-LAST:event_BTN_AGREGAR_TRABAJADOR2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        //GlassPanePopup.closePopupLast();

        PopupgetDate date = new PopupgetDate();
        date.setEventAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (date.ValidarDatos()) {
                    date.setenabledbutton(false);
                    ControlServicio cs = new ControlServicio();
                    cs.insertarfechaFinalizacion(date.getFechaFinalizacion(), service.getIDServicio());
                    cs.ActualizarEstadosServicio();
                    cs.Disconneting();
                    TXT_FECHA_FINALIZACION.setText(date.getFechaFinalizacion().toString());
                    GlassPanePopup.closePopupLast();

                } else {
                    new PopupMessage(
                            "¡ FECHA SELECCIONADO INVALIDO !",
                            "Debe insertar una fecha real.",
                            3
                    );
                }
            }
        });
    }//GEN-LAST:event_button1ActionPerformed

    private void BTN_GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GUARDARActionPerformed
        // TODO add your handling code here:
        BTN_GUARDAR.setEnabled(false);
        ControlServicio cs = new ControlServicio();
        cs.ActualizarEstadosServicio();
        FormServicio.MostrarServicioBusqueda();

        int ID_SERVICIO = Integer.parseInt(this.ID_SERVICIO.getText());

        cs.EliminarAllTrabajadorServicio(ID_SERVICIO);
        for (int i = 0; i < TABLA_TRABAJADOR.getRowCount(); i++) {
            String DNI_TRABAJADOR = TABLA_TRABAJADOR.getValueAt(i, 0).toString();
            double HorasEjecutadas = Double.parseDouble(TABLA_TRABAJADOR.getValueAt(i, 4).toString());
            cs.InsertarTrabajadorServicio(ID_SERVICIO, DNI_TRABAJADOR, HorasEjecutadas);
        }

        cs.EliminarAllActividadServicio(ID_SERVICIO);
        for (int i = 0; i < TABLA_ACTIVIDAD.getRowCount(); i++) {
            String ID_ACTIVIDAD = TABLA_ACTIVIDAD.getValueAt(i, 0).toString();
            cs.InsertarActividadServicio(ID_SERVICIO, ID_ACTIVIDAD);
        }

        cs.EliminarAllMaterialServicio(ID_SERVICIO);
        for (int i = 0; i < TABLA_MATERIAL.getRowCount(); i++) {
            String ID_ACTIVIDAD = TABLA_MATERIAL.getValueAt(i, 0).toString();
            int Cantidad = Integer.parseInt(TABLA_MATERIAL.getValueAt(i, 3).toString());
            cs.InsertarMaterialServicio(ID_SERVICIO, ID_ACTIVIDAD, Cantidad);
        }

        GlassPanePopup.closePopupLast();

    }//GEN-LAST:event_BTN_GUARDARActionPerformed

    public Document EscribirDocumento(Document doc ){
        doc.setidservicio(String.valueOf(service.getIDServicio()));
        doc.rellenartablaactividad((DefaultTableModel) TABLA_ACTIVIDAD.getModel());
        doc.rellenartablatrabajador((DefaultTableModel) TABLA_TRABAJADOR.getModel());
        doc.rellenartablamaterial((DefaultTableModel) TABLA_MATERIAL.getModel());
        doc.setFehaServicio(service.getFechaInicio());
        doc.setFehaFinalizacionServicio(service.getFechaFinalizacion());
        doc.settotalmanoobra(MONTO_OBRA.getText());
        doc.settotalmaterial(MONTO_MATERIAL.getText());
        doc.settotalotm(TOTAL_OTM.getText());
        doc.setubicacion(service.getUbicacion());
        doc.setdescripcion(service.getDescripcion());
        return doc;
    }
    
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        PrinterJob job = PrinterJob.getPrinterJob();

        document1 = EscribirDocumento(document1);
        //job.setPrintable(new Document());
        job.setPrintable(document1);

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "La impresion se cancelo");
        }
    }//GEN-LAST:event_button3ActionPerformed

    private static boolean isValidDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void TABLA_TRABAJADORKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TABLA_TRABAJADORKeyReleased
        // TODO add your handling code here:

        if (evt.getKeyCode() == evt.VK_ENTER) {
            int filaselected = TABLA_TRABAJADOR.getSelectedRow();
            if (filaselected > -1) {
                Object value = TABLA_TRABAJADOR.getValueAt(filaselected, 4);
                if (value != null && isValidDouble(value.toString())) {
                    double HorasTrabajadas = Double.parseDouble(TABLA_TRABAJADOR.getValueAt(filaselected, 5).toString());
                    TABLA_TRABAJADOR.setValueAt(value, filaselected, 4);
                    TABLA_TRABAJADOR.setValueAt(Double.parseDouble(value.toString()) * HorasTrabajadas, filaselected, 6);
                    CalcularMontos();
                } else {
                    TABLA_TRABAJADOR.setValueAt(0.0, filaselected, 4);
                    TABLA_TRABAJADOR.setValueAt(0.0, filaselected, 6);
                    CalcularMontos();
                    new PopupMessage(
                            "¡ VALOR DE H.E.TRABAJADOR INVALIDO!",
                            "Debe insertar un valor entero o decimal .",
                            3
                    );
                }
            }
        }
    }//GEN-LAST:event_TABLA_TRABAJADORKeyReleased

    private void TABLA_MATERIALKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TABLA_MATERIALKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            int filaselected = TABLA_MATERIAL.getSelectedRow();
            Object value = TABLA_MATERIAL.getValueAt(filaselected, 3);

            if (value != null && isValidInteger(value.toString())) {
                double PrecioUnitario = Double.parseDouble(TABLA_MATERIAL.getValueAt(filaselected, 4).toString());
                TABLA_MATERIAL.setValueAt(value, filaselected, 3);
                TABLA_MATERIAL.setValueAt(Integer.parseInt(value.toString()) * PrecioUnitario, filaselected, 5);
                CalcularMontos();
            } else {
                TABLA_MATERIAL.setValueAt(0, filaselected, 3);
                TABLA_MATERIAL.setValueAt(0, filaselected, 5);
                CalcularMontos();
                new PopupMessage(
                        "¡ VALOR DE CANTIDAD.MATERIAL INVALIDO!",
                        "Debe insertar un valor entero en la celda cantidad.",
                        3
                );
            }
        }
    }//GEN-LAST:event_TABLA_MATERIALKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        new PopupViewDocument(EscribirDocumento(new Document()));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.Button.Button BTN_AGREGAR_TRABAJADOR;
    private com.mycompany.Swing.Button.Button BTN_AGREGAR_TRABAJADOR1;
    private com.mycompany.Swing.Button.Button BTN_AGREGAR_TRABAJADOR2;
    private com.mycompany.Swing.Button.Button BTN_GUARDAR;
    private com.mycompany.Swing.Button.Button BTN_QUITAR_ACTIVIDAD;
    private com.mycompany.Swing.Button.Button BTN_QUITAR_MATERIAL;
    private com.mycompany.Swing.Button.Button BTN_QUITAR_TRABAJADOR;
    private javax.swing.JLabel DESCRIPCION;
    private javax.swing.JLabel FECHA_EJECUCION;
    private javax.swing.JLabel ID_SERVICIO;
    private javax.swing.JLabel MONTO_MATERIAL;
    private javax.swing.JLabel MONTO_OBRA;
    private static com.mycompany.Swing.Tabla.Tabla TABLA_ACTIVIDAD;
    private static com.mycompany.Swing.Tabla.Tabla TABLA_MATERIAL;
    private static com.mycompany.Swing.Tabla.Tabla TABLA_TRABAJADOR;
    private com.mycompany.Swing.Label.LabelIcon TITTLE;
    private com.mycompany.Swing.Label.LabelIcon TITTLE3;
    private com.mycompany.Swing.Label.LabelIcon TITTLE4;
    private com.mycompany.Swing.Label.LabelIcon TITTLE5;
    private javax.swing.JLabel TOTAL_OTM;
    private javax.swing.JLabel TXT_FECHA_FINALIZACION;
    private javax.swing.JLabel UBICACION;
    private com.mycompany.Swing.Button.Button button1;
    private com.mycompany.Swing.Button.Button button3;
    private com.mycompany.LuxcarDocuments.Document document1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private com.mycompany.Swing.Panel.Panel panel1;
    private com.mycompany.Swing.Panel.Panel panel2;
    private com.mycompany.Swing.Panel.Panel panel3;
    private com.mycompany.Swing.Panel.Panel panel4;
    private com.mycompany.Swing.Panel.Panel panel6;
    // End of variables declaration//GEN-END:variables
}
