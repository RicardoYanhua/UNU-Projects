package com.mycompany.LuxcarForm.FormsTrabajador;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.DataBase.Control.ControlTrabajador;
import com.mycompany.DataBase.Control.TrabajadorClass;
import com.mycompany.Luxcar.Main;
import com.mycompany.Luxcar.Utilidades;
import com.mycompany.LuxcarForm.FormTrabajador;
import com.mycompany.Popup.PopupMessage;
import com.mycompany.Swing.TextField.Filter.TxtPhone;
import com.mycompany.Swing.TextField.Filter.TxtDecimalSize;
import com.mycompany.Swing.TextField.Filter.TxtUpper;
import com.mycompany.Util.Glasspanepopup.DefaultOption;
import com.mycompany.Util.Glasspanepopup.GlassPanePopup;
import com.mycompany.Util.jnafilechooser.api.JnaFileChooser;
import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ricar
 */
public class PopupModificarTrabajador extends javax.swing.JPanel {

    ControlTrabajador DataTrabajadorModificar;
    ImageIcon foto = null;

    public PopupModificarTrabajador() {
        initComponents();
        DataTrabajadorModificar = new ControlTrabajador();
        CargarImagenDefault();
        LoadDocuments();
        LoadIcons();

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

    public PopupModificarTrabajador(TrabajadorClass TrabajadorModificar) {
        this();
        DNI.setText(TrabajadorModificar.getDNI());
        NOMBRES.setText(TrabajadorModificar.getNombres());
        APELLIDOS.setText(TrabajadorModificar.getApellidos());
        DIRECCION.setText(TrabajadorModificar.getDireccion());
        CORREO.setText(TrabajadorModificar.getCorreo());
        PUESTO.setText(TrabajadorModificar.getPuesto());
        COBRO_HORA.setText(String.valueOf(TrabajadorModificar.getHoraCobro()));

        if (TrabajadorModificar.getFoto() == null) {
            CargarImagenDefault();
        } else {
            try {
                foto = Utilidades.bytesToImageIcon(TrabajadorModificar.getFoto());
            } catch (IOException ex) {
                Logger.getLogger(PopupModificarTrabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
            IMAGEN.setBackground_Image(foto);
        }

        switch (TrabajadorModificar.getGenero()) {
            case "Masculino":
                R_MASCULINO.setSelected(true);
                break;
            case "Femenino":
                R_FEMENINO.setSelected(true);
                break;
        }
        switch (TrabajadorModificar.getEstado()) {
            case "Activo":
                R_ACTIVO.setSelected(true);
                break;
            case "Inactivo":
                R_INACTIVO.setSelected(true);
                break;
            case "Deshabilitado":
                R_DESHABILITADO.setSelected(true);
                break;
        }
        TELEFONO.setText(TrabajadorModificar.getTelefono());
        insertarFechaNacimiento(TrabajadorModificar.getFechaNacimiento());
        insertarFechaContratacion(TrabajadorModificar.getFechaContratacion());
    }

    public void insertarFechaNacimiento(LocalDate fecha) {
        int dia_fecha = fecha.getDayOfMonth();
        String mes_fecha = Utilidades.getMesEnEspanol(fecha.getMonth());
        int año_fecha = fecha.getYear();
        DIA_NACIMIENTO.setValue(dia_fecha);
        MES_NACIMIENTO.setValue(mes_fecha);
        AÑO_NACIMIENTO.setValue(año_fecha);

    }

    public void insertarFechaContratacion(LocalDate fecha) {
        int dia_fecha = fecha.getDayOfMonth();
        String mes_fecha = Utilidades.getMesEnEspanol(fecha.getMonth());
        int año_fecha = fecha.getYear();
        DIA_CONTRATACION.setValue(dia_fecha);
        MES_CONTRATACION.setValue(mes_fecha);
        AÑO_CONTRATACION.setValue(año_fecha);

    }

    public boolean ValidarDatosTrabajador() {
        if (getFechaNacimiento() == null) {
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
            new PopupMessage("COBRO POR HORA", "Debe ingresar un valor en cobro por hora del trabajador.", 3);
            return false;
        } /*else if (getFechaFinalizacion() == null) {
            new PopupMessage("F. FINALIZACION", "La fecha de finalizacion es invalido.", 3);
            return false;
        }*/ else {
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

    String getCobroHora() {
        return COBRO_HORA.getText();
    }

    LocalDate getFechaNacimiento() {
        return Utilidades.getFechaSpinnerx3_dd_StringMes_yyyy(DIA_NACIMIENTO.getTextEditor(), MES_NACIMIENTO.getValue().toString(), AÑO_NACIMIENTO.getTextEditor());
    }

    LocalDate getFechaContratacion() {
        return Utilidades.getFechaSpinnerx3_dd_StringMes_yyyy(DIA_CONTRATACION.getTextEditor(), MES_CONTRATACION.getValue().toString(), AÑO_CONTRATACION.getTextEditor());
    }

    public void LoadIcons() {
        int size = 20;
        TITTLE.setIcon(new FlatSVGIcon("svg/worker.svg", 60, 60));
        NOMBRES.setIcon(new FlatSVGIcon("svg/user_2.svg", size, size));
        APELLIDOS.setIcon(new FlatSVGIcon("svg/text_icon.svg", size, size));
        DIRECCION.setIcon(new FlatSVGIcon("svg/direccion_icon.svg", size, size));
        CORREO.setIcon(new FlatSVGIcon("svg/correo_icon.svg", size, size));
        TELEFONO.setIcon(new FlatSVGIcon("svg/phone.svg", size, size));
        PUESTO.setIcon(new FlatSVGIcon("svg/worker_icon.svg", size, size));
        COBRO_HORA.setIcon(new FlatSVGIcon("svg/money_icon.svg", size, size));
        int sizebtn = 35;
        BTN_ADD_PHOTO.setIcon(new FlatSVGIcon("svg/addphoto.svg", sizebtn, sizebtn));
        BTN_DELETE_PHOTO.setIcon(new FlatSVGIcon("svg/delete.svg", sizebtn, sizebtn));
    }

    public void LoadDocuments() {
        NOMBRES.setDocument(new TxtUpper() {
        });
        APELLIDOS.setDocument(new TxtUpper() {
        });
        PUESTO.setDocument(new TxtUpper() {
        });
        COBRO_HORA.setDocument(new TxtDecimalSize(2) {
        });
        TELEFONO.setDocument(new TxtPhone() {
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
        APELLIDOS = new com.mycompany.Swing.TextField.TextField();
        IMAGEN = new com.mycompany.Swing.Background.Background_Img();
        panel2 = new com.mycompany.Swing.Panel.Panel();
        R_ACTIVO = new com.mycompany.Swing.RadioButton.RadioButton();
        R_DESHABILITADO = new com.mycompany.Swing.RadioButton.RadioButton();
        R_INACTIVO = new com.mycompany.Swing.RadioButton.RadioButton();
        DIRECCION = new com.mycompany.Swing.TextField.TextField();
        CORREO = new com.mycompany.Swing.TextField.TextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panel4 = new com.mycompany.Swing.Panel.Panel();
        R_MASCULINO = new com.mycompany.Swing.RadioButton.RadioButton();
        R_FEMENINO = new com.mycompany.Swing.RadioButton.RadioButton();
        TELEFONO = new com.mycompany.Swing.TextField.TextField();
        jLabel13 = new javax.swing.JLabel();
        COBRO_HORA = new com.mycompany.Swing.TextField.TextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TITTLE1 = new com.mycompany.Swing.Label.LabelIcon();
        panel5 = new com.mycompany.Swing.Panel.Panel();
        TITTLE = new com.mycompany.Swing.Label.LabelIcon();
        TITTLE3 = new com.mycompany.Swing.Label.LabelIcon();
        DNI = new com.mycompany.Swing.Label.LabelIcon();
        PUESTO = new com.mycompany.Swing.TextField.TextField();
        jLabel18 = new javax.swing.JLabel();
        TITTLE2 = new com.mycompany.Swing.Label.LabelIcon();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        NOMBRES = new com.mycompany.Swing.TextField.TextField();
        TITTLE4 = new com.mycompany.Swing.Label.LabelIcon();
        DIA_NACIMIENTO = new com.mycompany.Swing.Spinner.SpinnerDia();
        MES_NACIMIENTO = new com.mycompany.Swing.Spinner.SpinnerMes();
        AÑO_NACIMIENTO = new com.mycompany.Swing.Spinner.SpinnerAño();
        DIA_CONTRATACION = new com.mycompany.Swing.Spinner.SpinnerDia();
        MES_CONTRATACION = new com.mycompany.Swing.Spinner.SpinnerMes();
        AÑO_CONTRATACION = new com.mycompany.Swing.Spinner.SpinnerAño();
        jSeparator2 = new javax.swing.JSeparator();

        setOpaque(false);

        panel1.setBackground(new java.awt.Color(250, 250, 250));
        panel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        panel1.setPanel_BorderColor(new java.awt.Color(16, 78, 128));
        panel1.setPanel_Round(5);
        panel1.setPanel_ShadowColor(new java.awt.Color(16, 78, 128));
        panel1.setPanel_ShadowSize(3);
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN_DELETE_PHOTO.setBackground(new java.awt.Color(51, 51, 51));
        BTN_DELETE_PHOTO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_DELETE_PHOTO.setButton_ActivedIconColorFilter(true);
        BTN_DELETE_PHOTO.setButton_BackgroundColorEntered(new java.awt.Color(102, 102, 102));
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

        button2.setBackground(new java.awt.Color(51, 51, 51));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Guardar");
        button2.setButton_BackgroundColorEntered(new java.awt.Color(102, 102, 102));
        button2.setButton_Round(15);
        button2.setButton_ShadowSize(3);
        button2.setButton_ShawdowOpacity(0.3F);
        button2.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 660, 130, 50));

        button3.setText("Cancelar");
        button3.setButton_Round(15);
        button3.setButton_ShadowSize(3);
        button3.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 660, 130, 50));

        BTN_ADD_PHOTO.setBackground(new java.awt.Color(51, 51, 51));
        BTN_ADD_PHOTO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ADD_PHOTO.setButton_ActivedIconColorFilter(true);
        BTN_ADD_PHOTO.setButton_BackgroundColorEntered(new java.awt.Color(102, 102, 102));
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

        APELLIDOS.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        APELLIDOS.setTextField_ActivedIconColorFilter(true);
        APELLIDOS.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        APELLIDOS.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        APELLIDOS.setTextField_Round(5);
        APELLIDOS.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        APELLIDOS.setTextField_ShadowOpacity(0.3F);
        APELLIDOS.setTextField_ShadowSize(3);
        APELLIDOS.setTextField_Txthint("Apellidos del trabajador.");
        APELLIDOS.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(APELLIDOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 470, 50));

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

        panel1.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 320, 50));

        DIRECCION.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        DIRECCION.setTextField_ActivedIconColorFilter(true);
        DIRECCION.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        DIRECCION.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        DIRECCION.setTextField_Round(5);
        DIRECCION.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        DIRECCION.setTextField_ShadowOpacity(0.3F);
        DIRECCION.setTextField_ShadowSize(3);
        DIRECCION.setTextField_Txthint("Direccion del trabajador.");
        DIRECCION.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(DIRECCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 470, 50));

        CORREO.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        CORREO.setTextField_ActivedIconColorFilter(true);
        CORREO.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        CORREO.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        CORREO.setTextField_Round(5);
        CORREO.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        CORREO.setTextField_ShadowOpacity(0.3F);
        CORREO.setTextField_ShadowSize(3);
        CORREO.setTextField_Txthint("Correo electronico del trabajador.");
        CORREO.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(CORREO, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 470, 50));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Género");
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 82, 30));

        jSeparator1.setForeground(new java.awt.Color(220, 220, 220));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, 10, 500));

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

        panel1.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 240, 50));

        TELEFONO.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        TELEFONO.setTextField_ActivedIconColorFilter(true);
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
        panel1.add(TELEFONO, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 220, 50));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Telefono");
        panel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 100, 30));

        COBRO_HORA.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        COBRO_HORA.setTextField_ActivedIconColorFilter(true);
        COBRO_HORA.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        COBRO_HORA.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        COBRO_HORA.setTextField_Round(5);
        COBRO_HORA.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        COBRO_HORA.setTextField_ShadowOpacity(0.3F);
        COBRO_HORA.setTextField_ShadowSize(3);
        COBRO_HORA.setTextField_Txthint("0.00");
        COBRO_HORA.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(COBRO_HORA, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 450, 220, 50));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Estado");
        panel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 82, 30));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Cobro por hora");
        panel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 420, 130, 30));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("F. Nacimiento");
        panel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 170, 30));

        TITTLE1.setForeground(new java.awt.Color(51, 51, 51));
        TITTLE1.setText("FOTO DEL TRABAJADOR");
        TITTLE1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TITTLE1.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE1.setIconColorFilterActived(true);
        panel1.add(TITTLE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 280, 30));

        panel5.setBackground(new java.awt.Color(51, 51, 51));
        panel5.setPanel_BackgroundGradientColor1(new java.awt.Color(51, 51, 51));
        panel5.setPanel_BackgroundGradientColor2(new java.awt.Color(51, 51, 51));
        panel5.setPanel_Round(5);
        panel5.setPanel_ShadowSize(3);
        panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TITTLE.setForeground(new java.awt.Color(255, 255, 255));
        TITTLE.setText("MODIFICAR TRABAJADOR");
        TITTLE.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        TITTLE.setIconColorFilterActived(true);
        panel5.add(TITTLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 400, 90));

        TITTLE3.setForeground(new java.awt.Color(255, 255, 255));
        TITTLE3.setText("DNI:");
        TITTLE3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        TITTLE3.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE3.setIconColorFilterActived(true);
        panel5.add(TITTLE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 80, 40));

        DNI.setForeground(new java.awt.Color(255, 255, 255));
        DNI.setText("12345678");
        DNI.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        DNI.setIconColorFilter(new java.awt.Color(16, 71, 128));
        DNI.setIconColorFilterActived(true);
        panel5.add(DNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 40, 160, 30));

        panel1.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 100));

        PUESTO.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        PUESTO.setTextField_ActivedIconColorFilter(true);
        PUESTO.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        PUESTO.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        PUESTO.setTextField_Round(5);
        PUESTO.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        PUESTO.setTextField_ShadowOpacity(0.3F);
        PUESTO.setTextField_ShadowSize(3);
        PUESTO.setTextField_Txthint("Puesto del trabajador.");
        PUESTO.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(PUESTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 200, 320, 50));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("F. Contratación");
        panel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 140, 30));

        TITTLE2.setForeground(new java.awt.Color(51, 51, 51));
        TITTLE2.setText("DATOS DE TRABAJO");
        TITTLE2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TITTLE2.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE2.setIconColorFilterActived(true);
        panel1.add(TITTLE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 150, 320, 30));
        panel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 700, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(220, 220, 220));
        panel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 1270, 20));
        panel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 280, 10));

        NOMBRES.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        NOMBRES.setTextField_ActivedIconColorFilter(true);
        NOMBRES.setTextField_BorderColor(new java.awt.Color(102, 102, 102));
        NOMBRES.setTextField_IconColorFilter(new java.awt.Color(0, 0, 0));
        NOMBRES.setTextField_Round(5);
        NOMBRES.setTextField_ShadowColor(new java.awt.Color(16, 78, 128));
        NOMBRES.setTextField_ShadowOpacity(0.3F);
        NOMBRES.setTextField_ShadowSize(3);
        NOMBRES.setTextField_Txthint("Nombres del trabajador.");
        NOMBRES.setTextField_TxthintColor(new java.awt.Color(183, 193, 173));
        panel1.add(NOMBRES, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 470, 50));

        TITTLE4.setForeground(new java.awt.Color(51, 51, 51));
        TITTLE4.setText("DATOS DEL TRABAJADOR");
        TITTLE4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        TITTLE4.setIconColorFilter(new java.awt.Color(16, 71, 128));
        TITTLE4.setIconColorFilterActived(true);
        panel1.add(TITTLE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 470, 30));

        DIA_NACIMIENTO.setBackground(new java.awt.Color(204, 204, 204));
        panel1.add(DIA_NACIMIENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, 80, 50));
        panel1.add(MES_NACIMIENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, 150, 50));
        panel1.add(AÑO_NACIMIENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, -1, 50));
        panel1.add(DIA_CONTRATACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, 80, 50));
        panel1.add(MES_CONTRATACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 360, 150, 50));
        panel1.add(AÑO_CONTRATACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 360, -1, 50));

        jSeparator2.setForeground(new java.awt.Color(220, 220, 220));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 10, 500));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        button3.setEnabled(false);
        DataTrabajadorModificar.Disconneting();
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_button3ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if (ValidarDatosTrabajador()) {
            TrabajadorClass TrabajadorModificado = new TrabajadorClass();
            TrabajadorModificado.setDNI(getDNI());//1
            TrabajadorModificado.setNombres(getNombres());//2
            TrabajadorModificado.setApellidos(getApellidos());//3
            TrabajadorModificado.setDireccion(getDireccion());//4
            TrabajadorModificado.setCorreo(getCorreo());//5
            TrabajadorModificado.setEstado(getEstado());//6
            TrabajadorModificado.setGenero(getGenero());//7
            TrabajadorModificado.setPuesto(getPuesto());//8
            TrabajadorModificado.setFechaNacimiento(getFechaNacimiento());//9
            TrabajadorModificado.setFechaContratacion(getFechaContratacion());//10
            TrabajadorModificado.setHoraCobro(Double.parseDouble(getCobroHora()));//11
            TrabajadorModificado.setTelefono(getTelefono());//12
            if (foto != null) {

                try {
                    TrabajadorModificado.setFoto(Utilidades.imageIconToBytes(foto));
                } catch (IOException ex) {
                    Logger.getLogger(PopupModificarTrabajador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                TrabajadorModificado.setFoto(null);

            }
            DataTrabajadorModificar.ModificarTrabajador(TrabajadorModificado);
            FormTrabajador.MostrarTablaTrabajadorBusqueda();
            DataTrabajadorModificar.Disconneting();

            GlassPanePopup.closePopupLast();
            new PopupMessage(
                    "¡ MODIFICAION EXITOSO !",
                    "El trabajador ha sido modificado correctamente a la base de datos Luxcar",
                    0
            );
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void BTN_DELETE_PHOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DELETE_PHOTOActionPerformed
        CargarImagenDefault();
        foto = null;
    }//GEN-LAST:event_BTN_DELETE_PHOTOActionPerformed

    private void BTN_ADD_PHOTOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ADD_PHOTOMousePressed


    }//GEN-LAST:event_BTN_ADD_PHOTOMousePressed

    private void TELEFONOMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TELEFONOMouseReleased
        if (TELEFONO.getText().equals("+51 ")) {
            TELEFONO.setCaretPosition(4);
        }

    }//GEN-LAST:event_TELEFONOMouseReleased

    private void BTN_ADD_PHOTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ADD_PHOTOMouseClicked
        JnaFileChooser jnaCh = new JnaFileChooser();
        boolean save = jnaCh.showSaveDialog(Main.getMain());
        if (save) {
            try {
                foto = Utilidades.getImagenIconToURL(
                        String.valueOf(jnaCh.getSelectedFile())
                );
                IMAGEN.setBackground_Image(foto
                );

            } catch (Exception e) {
                new PopupMessage(
                        "¡ ERROR AL CARGAR LA IMAGEN !",
                        "Este error ocurre cuanto la imagen es muy grande o este corrupto.",
                        2
                );
            }

        }
    }//GEN-LAST:event_BTN_ADD_PHOTOMouseClicked

    private void BTN_ADD_PHOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ADD_PHOTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ADD_PHOTOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.Swing.TextField.TextField APELLIDOS;
    private com.mycompany.Swing.Spinner.SpinnerAño AÑO_CONTRATACION;
    private com.mycompany.Swing.Spinner.SpinnerAño AÑO_NACIMIENTO;
    private com.mycompany.Swing.Button.Button BTN_ADD_PHOTO;
    private com.mycompany.Swing.Button.Button BTN_DELETE_PHOTO;
    private com.mycompany.Swing.TextField.TextField COBRO_HORA;
    private com.mycompany.Swing.TextField.TextField CORREO;
    private com.mycompany.Swing.Spinner.SpinnerDia DIA_CONTRATACION;
    private com.mycompany.Swing.Spinner.SpinnerDia DIA_NACIMIENTO;
    private com.mycompany.Swing.TextField.TextField DIRECCION;
    private com.mycompany.Swing.Label.LabelIcon DNI;
    private com.mycompany.Swing.Background.Background_Img IMAGEN;
    private com.mycompany.Swing.Spinner.SpinnerMes MES_CONTRATACION;
    private com.mycompany.Swing.Spinner.SpinnerMes MES_NACIMIENTO;
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
    private com.mycompany.Swing.Label.LabelIcon TITTLE4;
    private com.mycompany.Swing.Button.Button button2;
    private com.mycompany.Swing.Button.Button button3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private com.mycompany.Swing.Panel.Panel panel1;
    private com.mycompany.Swing.Panel.Panel panel2;
    private com.mycompany.Swing.Panel.Panel panel4;
    private com.mycompany.Swing.Panel.Panel panel5;
    // End of variables declaration//GEN-END:variables
}
