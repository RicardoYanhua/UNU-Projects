package com.mycompany.LuxcarForm.FormsTrabajador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ControlTrabajador;
import com.mycompany.DataBase.Control.TrabajadorClass;
import com.mycompany.Luxcar.Main;
import com.mycompany.Luxcar.Utilidades;
import com.mycompany.LuxcarForm.FormTrabajador;
import com.mycompany.Popup.PopupMessage;
import com.mycompany.Swing.TextField.Filter.TxtDate;
import com.mycompany.Swing.TextField.Filter.TxtPhone;
import com.mycompany.Swing.TextField.Filter.TxtDecimalSize;
import com.mycompany.Swing.TextField.Filter.TxtIntegerSize;
import com.mycompany.Swing.TextField.Filter.TxtUpper;
import com.mycompany.Util.Glasspanepopup.DefaultOption;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import com.mycompany.Util.jnafilechooser.api.JnaFileChooser;
import java.awt.Color;
import java.time.LocalDate;

/**
 *
 * @author ricar
 */
public class PopupRegistrarTrabajador extends javax.swing.JPanel {
    
    ControlTrabajador Trabajador;
    
    public PopupRegistrarTrabajador() {
        initComponents();
        Trabajador = new ControlTrabajador();
        CargarImagenDefault();
        CargarDocumentsFilters();
        CargarAllIcons();
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
    
    public boolean ValidarDatosTrabajador() {
        if (getDNI().equals("")) {
            new PopupMessage("DNI", "El campo DNI esta vacio.", 3);
            return false;
        } else if (getDNI().length() < 8) {
            new PopupMessage("DNI", "El DNI ingresado es invalido.", 3);
            return false;
        } else if (Trabajador.isExistTrabajador(getDNI())) {
            new PopupMessage("DNI", "El DNI ingresado ya existe.", 3);
            return false;
        } else if (getFechaNacimiento() == null) {
            new PopupMessage("F. NACIMIENTO", "La fecha de nacimiento es invalido.", 3);
            return false;
        } else if (getNombres().equals("")) {
            new PopupMessage("NOMBRES", "Debe ingresar los nombres del trabajador.", 3);
            return false;
        } else if (getApellidos().equals("")) {
            new PopupMessage("APELLIDOS", "Debe ingresar los apellidos del trabajador.", 3);
            return false;
        } else if (getDireccion().equals("")) {
            new PopupMessage("DIRECCION", "Debe ingresar la direccion del trabajador.", 3);
            return false;
        } else if (getCorreo().equals("")) {
            new PopupMessage("CORREO", "Debe ingresar el correo del trabajador.", 3);
            return false;
        } else if (getTelefono().equals("+51 ")) {
            new PopupMessage("TELEFONO", "Debe ingresar el telefono del trabajador.", 3);
            return false;
        } else if (getTelefono().length() < 9) {
            new PopupMessage("TELEFONO", "El telefono ingresado es  invalido", 3);
            return false;
        } else if (getGenero().equals("")) {
            new PopupMessage("GENERO", "Seleccione el genero del trabajador.", 3);
            return false;
        } else if (getPuesto().equals("")) {
            new PopupMessage("PUESTO", "Debe ingresar el puesto o cargo del trabajador.", 3);
            return false;
        } else if (getEstado().equals("")) {
            new PopupMessage("ESTADO", "No ha selecionado un Estado inicial.", 3);
            return false;
        } else if (getFechaContratacion() == null) {
            new PopupMessage("F. CONTRATACION", "La fecha de contratacion es invalido.", 3);
            return false;
        } else if (getCobroHora().equals("")) {
            new PopupMessage("COBRO POR HORA", "Debe ingresar un valor en salario.", 3);
            return false;
        } else {
            return true;
        }
    }
    
    String getDNI() {
        return DNI.getText();
    }
    
    String getNombres() {
        return NOMBRES.getText();
    }
    
    String getApellidos() {
        return APELLIDOS.getText();
    }
    
    LocalDate getFechaNacimiento() {
        return Utilidades.getFechaTextField(NACIMIENTO.getText());
    }
    
    String getDireccion() {
        return DIRECCION.getText();
    }
    
    String getCorreo() {
        return CORREO.getText();
    }
    
    String getTelefono() {
        return Utilidades.getNumeroTelefonox9_from51(TELEFONO.getText());
    }
    
    String getGenero() {
        if (R_MASCULINO.isSelected()) {
            return "Masculino";
        } else if (R_FEMENINO.isSelected()) {
            return "Femenino";
        } else {
            return "";
        }
    }
    
    String getPuesto() {
        return PUESTO.getText();
    }
    
    String getEstado() {
        if (R_ACTIVO.isSelected()) {
            return "Activo";
        } else if (R_INACTIVO.isSelected()) {
            return "Inactivo";
        } else if (R_DESHABILITADO.isSelected()) {
            return "Deshabilitado";
        } else {
            return "";
        }
    }
    
    LocalDate getFechaContratacion() {
        return Utilidades.getFechaTextField(CONTRATACION.getText());
    }
    
    String getCobroHora() {
        return COBRO_HORA.getText();
    }
    
    
    
    
    public void CargarAllIcons() {
        int size = 20;
        TITTLE.setIcon(new FlatSVGIcon("svg/worker.svg", 60, 60));
        NOMBRES.setIcon(new FlatSVGIcon("svg/user_2.svg", size, size));
        DNI.setIcon(new FlatSVGIcon("svg/dni_icon.svg", size, size));
        APELLIDOS.setIcon(new FlatSVGIcon("svg/text_icon.svg", size, size));
        DIRECCION.setIcon(new FlatSVGIcon("svg/direccion_icon.svg", size, size));
        CORREO.setIcon(new FlatSVGIcon("svg/correo_icon.svg", size, size));
        NACIMIENTO.setIcon(new FlatSVGIcon("svg/birthday_icon.svg", size, size));
        TELEFONO.setIcon(new FlatSVGIcon("svg/phone.svg", size, size));
        PUESTO.setIcon(new FlatSVGIcon("svg/worker_icon.svg", size, size));
        CONTRATACION.setIcon(new FlatSVGIcon("svg/date_icon.svg", size, size));
        COBRO_HORA.setIcon(new FlatSVGIcon("svg/money_icon.svg", size, size));
        int sizebtn = 35;
        BTN_ADD_PHOTO.setIcon(new FlatSVGIcon("svg/addphoto.svg", sizebtn, sizebtn));
        BTN_DELETE_PHOTO.setIcon(new FlatSVGIcon("svg/delete.svg", sizebtn, sizebtn));
        BTN_NEW_CODIGO.setIcon(new FlatSVGIcon("svg/code.svg", sizebtn, sizebtn));
        TODAY.setIcon(new FlatSVGIcon("svg/today.svg", 25, 25));
    }
    
    public void CargarDocumentsFilters() {
        NOMBRES.setDocument(new TxtUpper() {
        });
        APELLIDOS.setDocument(new TxtUpper() {
        });
        PUESTO.setDocument(new TxtUpper() {
        });
        COBRO_HORA.setDocument(new TxtDecimalSize(2) {
        });
        DNI.setDocument(new TxtIntegerSize(8) {
        });
        TELEFONO.setDocument(new TxtPhone() {
        });
        NACIMIENTO.setDocument(new TxtDate() {
        });
        CONTRATACION.setDocument(new TxtDate() {
        });
    }
    
    public void CargarImagenDefault() {
        IMAGEN.setBackground_Image(new FlatSVGIcon("svg/photo.svg", 150, 150));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panel1 = new com.mycompany.Swing.Panel.Panel();
        BTN_DELETE_PHOTO = new com.mycompany.Swing.Button.Button();
        button2 = new com.mycompany.Swing.Button.Button();
        button3 = new com.mycompany.Swing.Button.Button();
        BTN_ADD_PHOTO = new com.mycompany.Swing.Button.Button();
        BTN_NEW_CODIGO = new com.mycompany.Swing.Button.Button();
        APELLIDOS = new com.mycompany.Swing.TextField.TextField();
        IMAGEN = new com.mycompany.Swing.Background.Background_Img();
        jLabel9 = new javax.swing.JLabel();
        DNI = new com.mycompany.Swing.TextField.TextField();
        panel2 = new com.mycompany.Swing.Panel.Panel();
        R_ACTIVO = new com.mycompany.Swing.RadioButton.RadioButton();
        R_DESHABILITADO = new com.mycompany.Swing.RadioButton.RadioButton();
        R_INACTIVO = new com.mycompany.Swing.RadioButton.RadioButton();
        DIRECCION = new com.mycompany.Swing.TextField.TextField();
        jLabel8 = new javax.swing.JLabel();
        CORREO = new com.mycompany.Swing.TextField.TextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        panel4 = new com.mycompany.Swing.Panel.Panel();
        R_MASCULINO = new com.mycompany.Swing.RadioButton.RadioButton();
        R_FEMENINO = new com.mycompany.Swing.RadioButton.RadioButton();
        NACIMIENTO = new com.mycompany.Swing.TextField.TextField();
        jLabel12 = new javax.swing.JLabel();
        TELEFONO = new com.mycompany.Swing.TextField.TextField();
        jLabel13 = new javax.swing.JLabel();
        COBRO_HORA = new com.mycompany.Swing.TextField.TextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TITTLE1 = new com.mycompany.Swing.Label.LabelIcon();
        panel5 = new com.mycompany.Swing.Panel.Panel();
        TITTLE = new com.mycompany.Swing.Label.LabelIcon();
        PUESTO = new com.mycompany.Swing.TextField.TextField();
        CONTRATACION = new com.mycompany.Swing.TextField.TextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        TITTLE2 = new com.mycompany.Swing.Label.LabelIcon();
        TITTLE3 = new com.mycompany.Swing.Label.LabelIcon();
        jSeparator3 = new javax.swing.JSeparator();
        url = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        NOMBRES = new com.mycompany.Swing.TextField.TextField();
        jSeparator8 = new javax.swing.JSeparator();
        TODAY = new com.mycompany.Swing.Button.Button();

        setOpaque(false);

        panel1.setBackground(new java.awt.Color(249, 249, 255));
        panel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        panel1.setPanel_BorderColor(new java.awt.Color(16, 78, 128));
        panel1.setPanel_Round(5);
        panel1.setPanel_ShadowColor(new java.awt.Color(16, 78, 128));
        panel1.setPanel_ShadowSize(3);
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN_DELETE_PHOTO.setBackground(new java.awt.Color(16, 78, 128));
        BTN_DELETE_PHOTO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_DELETE_PHOTO.setButton_ActivedIconColorFilter(true);
        BTN_DELETE_PHOTO.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_DELETE_PHOTO.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_DELETE_PHOTO.setButton_Round(15);
        BTN_DELETE_PHOTO.setButton_ShadowSize(3);
        BTN_DELETE_PHOTO.setButton_ShawdowOpacity(0.3F);
        BTN_DELETE_PHOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_DELETE_PHOTOActionPerformed(evt);
            }
        });
        panel1.add(BTN_DELETE_PHOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 50, 50));

        button2.setBackground(new java.awt.Color(16, 78, 128));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Guardar");
        button2.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        button2.setButton_Round(7);
        button2.setButton_ShadowColor(new java.awt.Color(16, 78, 128));
        button2.setButton_ShadowSize(3);
        button2.setButton_ShawdowOpacity(0.3F);
        button2.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 700, 130, 50));

        button3.setText("Cancelar");
        button3.setButton_Round(7);
        button3.setButton_ShadowSize(3);
        button3.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 700, 130, 50));

        BTN_ADD_PHOTO.setBackground(new java.awt.Color(16, 78, 128));
        BTN_ADD_PHOTO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ADD_PHOTO.setButton_ActivedIconColorFilter(true);
        BTN_ADD_PHOTO.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_ADD_PHOTO.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_ADD_PHOTO.setButton_Round(15);
        BTN_ADD_PHOTO.setButton_ShadowSize(3);
        BTN_ADD_PHOTO.setButton_ShawdowOpacity(0.3F);
        BTN_ADD_PHOTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_ADD_PHOTOMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BTN_ADD_PHOTOMousePressed(evt);
            }
        });
        BTN_ADD_PHOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ADD_PHOTOActionPerformed(evt);
            }
        });
        panel1.add(BTN_ADD_PHOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 50, 50));

        BTN_NEW_CODIGO.setBackground(new java.awt.Color(16, 78, 128));
        BTN_NEW_CODIGO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_NEW_CODIGO.setButton_ActivedIconColorFilter(true);
        BTN_NEW_CODIGO.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        BTN_NEW_CODIGO.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        BTN_NEW_CODIGO.setButton_Round(15);
        BTN_NEW_CODIGO.setButton_ShadowSize(3);
        BTN_NEW_CODIGO.setButton_ShawdowOpacity(0.3F);
        BTN_NEW_CODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NEW_CODIGOActionPerformed(evt);
            }
        });
        panel1.add(BTN_NEW_CODIGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 50, 50));

        APELLIDOS.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        APELLIDOS.setTextField_ActivedIconColorFilter(true);
        APELLIDOS.setTextField_BorderActived(true);
        APELLIDOS.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        APELLIDOS.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        APELLIDOS.setTextField_Round(5);
        APELLIDOS.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        APELLIDOS.setTextField_ShadowOpacity(0.3F);
        APELLIDOS.setTextField_ShadowSize(3);
        APELLIDOS.setTextField_Txthint("Apellidos del trabajador.");
        APELLIDOS.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(APELLIDOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 470, 50));

        IMAGEN.setBackground_BorderActived(true);
        IMAGEN.setBackground_BorderColor(new java.awt.Color(16, 78, 128));
        IMAGEN.setBackground_ImageOpacity(0.0F);
        IMAGEN.setBackground_ImgMaxMin(true);
        IMAGEN.setBackground_Round(7);

        javax.swing.GroupLayout IMAGENLayout = new javax.swing.GroupLayout(IMAGEN);
        IMAGEN.setLayout(IMAGENLayout);
        IMAGENLayout.setHorizontalGroup(
            IMAGENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        IMAGENLayout.setVerticalGroup(
            IMAGENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel1.add(IMAGEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 280, 280));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Nombres");
        panel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 82, 30));

        DNI.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        DNI.setTextField_ActivedIconColorFilter(true);
        DNI.setTextField_BorderActived(true);
        DNI.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        DNI.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        DNI.setTextField_Round(5);
        DNI.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        DNI.setTextField_ShadowOpacity(0.3F);
        DNI.setTextField_ShadowSize(3);
        DNI.setTextField_Txthint("Ingrese DNI.");
        DNI.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 220, 50));

        panel2.setPanel_BorderActived(true);
        panel2.setPanel_BorderColor(new java.awt.Color(102, 102, 102));
        panel2.setPanel_Round(7);
        panel2.setPanel_ShadowOpacity(0.3F);
        panel2.setPanel_ShadowSize(3);
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        R_ACTIVO.setBackground(new java.awt.Color(51, 51, 255));
        buttonGroup2.add(R_ACTIVO);
        R_ACTIVO.setText("Activo");
        R_ACTIVO.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        panel2.add(R_ACTIVO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        R_DESHABILITADO.setBackground(new java.awt.Color(51, 51, 255));
        buttonGroup2.add(R_DESHABILITADO);
        R_DESHABILITADO.setText("Deshabilitado");
        R_DESHABILITADO.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        panel2.add(R_DESHABILITADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 30));

        R_INACTIVO.setBackground(new java.awt.Color(51, 51, 255));
        buttonGroup2.add(R_INACTIVO);
        R_INACTIVO.setText("Inactivo");
        R_INACTIVO.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        panel2.add(R_INACTIVO, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 30));

        panel1.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 340, 320, 50));

        DIRECCION.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        DIRECCION.setTextField_ActivedIconColorFilter(true);
        DIRECCION.setTextField_BorderActived(true);
        DIRECCION.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        DIRECCION.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        DIRECCION.setTextField_Round(5);
        DIRECCION.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        DIRECCION.setTextField_ShadowOpacity(0.3F);
        DIRECCION.setTextField_ShadowSize(3);
        DIRECCION.setTextField_Txthint("Ingresar direccion.");
        DIRECCION.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(DIRECCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 470, 50));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Dirección");
        panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 82, 30));

        CORREO.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        CORREO.setTextField_ActivedIconColorFilter(true);
        CORREO.setTextField_BorderActived(true);
        CORREO.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        CORREO.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        CORREO.setTextField_Round(5);
        CORREO.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        CORREO.setTextField_ShadowOpacity(0.3F);
        CORREO.setTextField_ShadowSize(3);
        CORREO.setTextField_Txthint("Ingresar correo electrònico.");
        CORREO.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(CORREO, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 470, 50));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Correo");
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 82, 30));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Apellidos");
        panel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 82, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Género");
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 550, 82, 30));

        jSeparator1.setForeground(new java.awt.Color(220, 220, 220));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 10, 560));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("DNI");
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 82, 30));

        panel4.setPanel_BorderActived(true);
        panel4.setPanel_BorderColor(new java.awt.Color(102, 102, 102));
        panel4.setPanel_Round(7);
        panel4.setPanel_ShadowOpacity(0.3F);
        panel4.setPanel_ShadowSize(3);
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(R_MASCULINO);
        R_MASCULINO.setText("Masculino");
        R_MASCULINO.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        panel4.add(R_MASCULINO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        R_FEMENINO.setBackground(new java.awt.Color(255, 0, 204));
        buttonGroup1.add(R_FEMENINO);
        R_FEMENINO.setText("Femenino");
        R_FEMENINO.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        panel4.add(R_FEMENINO, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 30));

        panel1.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 580, 240, 50));

        NACIMIENTO.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        NACIMIENTO.setTextField_ActivedIconColorFilter(true);
        NACIMIENTO.setTextField_BorderActived(true);
        NACIMIENTO.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        NACIMIENTO.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        NACIMIENTO.setTextField_Round(5);
        NACIMIENTO.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        NACIMIENTO.setTextField_ShadowOpacity(0.3F);
        NACIMIENTO.setTextField_ShadowSize(3);
        NACIMIENTO.setTextField_Txthint("dd / mm / yyyy");
        NACIMIENTO.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(NACIMIENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 180, 50));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Puesto");
        panel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, 82, 30));

        TELEFONO.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        TELEFONO.setTextField_ActivedIconColorFilter(true);
        TELEFONO.setTextField_BorderActived(true);
        TELEFONO.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        TELEFONO.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        TELEFONO.setTextField_Round(5);
        TELEFONO.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        TELEFONO.setTextField_ShadowOpacity(0.3F);
        TELEFONO.setTextField_ShadowSize(3);
        TELEFONO.setTextField_Txthint("Nùmero telefònico.");
        TELEFONO.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        TELEFONO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TELEFONOMouseReleased(evt);
            }
        });
        panel1.add(TELEFONO, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 500, 220, 50));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Telefono");
        panel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 470, 100, 30));

        COBRO_HORA.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        COBRO_HORA.setTextField_ActivedIconColorFilter(true);
        COBRO_HORA.setTextField_BorderActived(true);
        COBRO_HORA.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        COBRO_HORA.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        COBRO_HORA.setTextField_Round(5);
        COBRO_HORA.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        COBRO_HORA.setTextField_ShadowOpacity(0.3F);
        COBRO_HORA.setTextField_ShadowSize(3);
        COBRO_HORA.setTextField_Txthint("0.00");
        COBRO_HORA.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(COBRO_HORA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 420, 140, 50));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Estado");
        panel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 310, 82, 30));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Cobro por hora");
        panel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 390, 110, 30));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("F. Nacimiento");
        panel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 170, 30));

        TITTLE1.setForeground(new java.awt.Color(16, 71, 128));
        TITTLE1.setText("FOTO DEL TRABAJADOR");
        TITTLE1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TITTLE1.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE1.setIconColorFilterActived(true);
        panel1.add(TITTLE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 280, 30));

        panel5.setPanel_BackgroundGradientActived(true);
        panel5.setPanel_BackgroundGradientColor1(new java.awt.Color(16, 78, 128));
        panel5.setPanel_BackgroundGradientColor2(new java.awt.Color(26, 88, 128));
        panel5.setPanel_Round(5);
        panel5.setPanel_ShadowSize(3);
        panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TITTLE.setForeground(new java.awt.Color(255, 255, 255));
        TITTLE.setText("REGISTRAR TRABAJADOR");
        TITTLE.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        TITTLE.setIconColorFilterActived(true);
        panel5.add(TITTLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 400, 90));

        panel1.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 100));

        PUESTO.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        PUESTO.setTextField_ActivedIconColorFilter(true);
        PUESTO.setTextField_BorderActived(true);
        PUESTO.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        PUESTO.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        PUESTO.setTextField_Round(5);
        PUESTO.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        PUESTO.setTextField_ShadowOpacity(0.3F);
        PUESTO.setTextField_ShadowSize(3);
        PUESTO.setTextField_Txthint("Puesto del trabajador.");
        PUESTO.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(PUESTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, 320, 50));

        CONTRATACION.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        CONTRATACION.setTextField_ActivedIconColorFilter(true);
        CONTRATACION.setTextField_BorderActived(true);
        CONTRATACION.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        CONTRATACION.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        CONTRATACION.setTextField_Round(5);
        CONTRATACION.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        CONTRATACION.setTextField_ShadowOpacity(0.3F);
        CONTRATACION.setTextField_ShadowSize(3);
        CONTRATACION.setTextField_Txthint("dd / mm / yyyy");
        CONTRATACION.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(CONTRATACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, 170, 50));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("F. Contratación");
        panel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 390, 140, 30));

        jSeparator2.setForeground(new java.awt.Color(220, 220, 220));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 10, 560));

        TITTLE2.setForeground(new java.awt.Color(16, 71, 128));
        TITTLE2.setText("DATOS DE TRABAJO");
        TITTLE2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TITTLE2.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE2.setIconColorFilterActived(true);
        panel1.add(TITTLE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 150, 320, 30));

        TITTLE3.setForeground(new java.awt.Color(16, 71, 128));
        TITTLE3.setText("DATOS DEL TRABAJADOR");
        TITTLE3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TITTLE3.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE3.setIconColorFilterActived(true);
        panel1.add(TITTLE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 470, 30));
        panel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 700, -1, -1));

        url.setForeground(new java.awt.Color(220, 220, 220));
        panel1.add(url, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 1280, 20));
        panel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 280, 10));
        panel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, 320, 10));

        NOMBRES.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        NOMBRES.setTextField_ActivedIconColorFilter(true);
        NOMBRES.setTextField_BorderActived(true);
        NOMBRES.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        NOMBRES.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        NOMBRES.setTextField_Round(5);
        NOMBRES.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        NOMBRES.setTextField_ShadowOpacity(0.3F);
        NOMBRES.setTextField_ShadowSize(3);
        NOMBRES.setTextField_Txthint("Nombres del trabajador.");
        NOMBRES.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(NOMBRES, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 470, 50));
        panel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 470, 10));

        TODAY.setBackground(new java.awt.Color(16, 78, 128));
        TODAY.setButton_ActivedIconColorFilter(true);
        TODAY.setButton_BackgroundColorEntered(new java.awt.Color(36, 98, 128));
        TODAY.setButton_IconColorFilter(new java.awt.Color(255, 255, 255));
        TODAY.setButton_Round(10);
        TODAY.setButton_ShadowSize(3);
        TODAY.setButton_ShawdowOpacity(0.3F);
        TODAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TODAYActionPerformed(evt);
            }
        });
        panel1.add(TODAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 390, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        Trabajador.Disconneting();
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_button3ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if (ValidarDatosTrabajador()) {
            TrabajadorClass NuevoTrabajador = new TrabajadorClass();
            NuevoTrabajador.setDNI(getDNI());//1
            NuevoTrabajador.setNombres(getNombres());//2
            NuevoTrabajador.setApellidos(getApellidos());//3
            NuevoTrabajador.setDireccion(getDireccion());//4
            NuevoTrabajador.setCorreo(getCorreo());//5
            NuevoTrabajador.setEstado(getEstado());//6
            NuevoTrabajador.setGenero(getGenero());//7
            NuevoTrabajador.setPuesto(getPuesto());//8
            NuevoTrabajador.setFechaNacimiento(getFechaNacimiento());//9
            NuevoTrabajador.setFechaContratacion(getFechaContratacion());//10
            NuevoTrabajador.setHoraCobro(Double.parseDouble(getCobroHora()));//11
            NuevoTrabajador.setTelefono(getTelefono());//12

            Trabajador.InsertarTrabajador(NuevoTrabajador);
            FormTrabajador.MostrarTablaTrabajadorBusqueda();
            Trabajador.Disconneting();
            GlassPanePopup.closePopupLast();
            //MostrarMensaje
            new PopupMessage(
                    "¡ REGISTRO EXITOSO !",
                    "El trabajador ha sido añadido correctamente a la base de datos Luxcar",
                    0
            );
            
        }
        

    }//GEN-LAST:event_button2ActionPerformed

    private void BTN_ADD_PHOTOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ADD_PHOTOMousePressed
        

    }//GEN-LAST:event_BTN_ADD_PHOTOMousePressed

    private void BTN_NEW_CODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NEW_CODIGOActionPerformed
        DNI.setText(Trabajador.GenerarDniTrabajador());

    }//GEN-LAST:event_BTN_NEW_CODIGOActionPerformed

    private void TELEFONOMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TELEFONOMouseReleased
        if (TELEFONO.getText().equals("+51 ")) {
            TELEFONO.setCaretPosition(4);
        }

    }//GEN-LAST:event_TELEFONOMouseReleased

    private void BTN_DELETE_PHOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DELETE_PHOTOActionPerformed
        CargarImagenDefault();
    }//GEN-LAST:event_BTN_DELETE_PHOTOActionPerformed

    private void TODAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TODAYActionPerformed
        CONTRATACION.setText(Utilidades.getFechaActual_dd_mm_yyy());
    }//GEN-LAST:event_TODAYActionPerformed
    

    private void BTN_ADD_PHOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ADD_PHOTOActionPerformed

    }//GEN-LAST:event_BTN_ADD_PHOTOActionPerformed

    private void BTN_ADD_PHOTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ADD_PHOTOMouseClicked
        JnaFileChooser jnaCh = new JnaFileChooser();
        boolean save = jnaCh.showSaveDialog(Main.getMain());
        
        if (save) {
            IMAGEN.setBackground_Image(
                    Utilidades.getImagenIconToURL(
                            String.valueOf(jnaCh.getSelectedFile())
                    ));
        }
    }//GEN-LAST:event_BTN_ADD_PHOTOMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.TextField.TextField APELLIDOS;
    private com.mycompany.Swing.Button.Button BTN_ADD_PHOTO;
    private com.mycompany.Swing.Button.Button BTN_DELETE_PHOTO;
    private com.mycompany.Swing.Button.Button BTN_NEW_CODIGO;
    private com.mycompany.Swing.TextField.TextField COBRO_HORA;
    private com.mycompany.Swing.TextField.TextField CONTRATACION;
    private com.mycompany.Swing.TextField.TextField CORREO;
    private com.mycompany.Swing.TextField.TextField DIRECCION;
    private com.mycompany.Swing.TextField.TextField DNI;
    private com.mycompany.Swing.Background.Background_Img IMAGEN;
    private com.mycompany.Swing.TextField.TextField NACIMIENTO;
    private com.mycompany.Swing.TextField.TextField NOMBRES;
    private com.mycompany.Swing.TextField.TextField PUESTO;
    private com.mycompany.Swing.RadioButton.RadioButton R_ACTIVO;
    private com.mycompany.Swing.RadioButton.RadioButton R_DESHABILITADO;
    private com.mycompany.Swing.RadioButton.RadioButton R_FEMENINO;
    private com.mycompany.Swing.RadioButton.RadioButton R_INACTIVO;
    private com.mycompany.Swing.RadioButton.RadioButton R_MASCULINO;
    private com.mycompany.Swing.TextField.TextField TELEFONO;
    private com.mycompany.Swing.Label.LabelIcon TITTLE;
    private com.mycompany.Swing.Label.LabelIcon TITTLE1;
    private com.mycompany.Swing.Label.LabelIcon TITTLE2;
    private com.mycompany.Swing.Label.LabelIcon TITTLE3;
    private com.mycompany.Swing.Button.Button TODAY;
    private com.mycompany.Swing.Button.Button button2;
    private com.mycompany.Swing.Button.Button button3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private com.mycompany.Swing.Panel.Panel panel1;
    private com.mycompany.Swing.Panel.Panel panel2;
    private com.mycompany.Swing.Panel.Panel panel4;
    private com.mycompany.Swing.Panel.Panel panel5;
    private javax.swing.JSeparator url;
    // End of variables declaration//GEN-END:variables
}
