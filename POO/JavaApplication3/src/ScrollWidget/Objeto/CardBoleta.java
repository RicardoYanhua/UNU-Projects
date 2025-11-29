package ScrollWidget.Objeto;

import Util.Shadow.ShadowRenderer;
import Util.Type.ShadowType;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import javax.swing.JEditorPane;
import javax.swing.text.StyledEditorKit;

import javax.swing.text.html.HTMLEditorKit;

public class CardBoleta extends javax.swing.JPanel {

    private DocumentBoleta data;

    public DocumentBoleta getData() {
        return data;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    private boolean selected;

    public CardBoleta() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbIcon.setIcon(new FlatSVGIcon("svg/boleta.svg", 54, 54));
    }
   
    

    public void setData(DocumentBoleta data) {
        this.data = data;
        lbCodigo.setText(data.getCodigo());
        lbImporte.setText(data.getImporte());
        lbNombre.setText(data.getDNI());
        lbFecha.setText(data.getFecha());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Swing.Panel.JPanel();
        jPanel2 = new Swing.Panel.JPanel();
        lbImporte = new javax.swing.JLabel();
        jPanel3 = new Swing.Panel.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbNombre1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 255, 102));
        jPanel2.setPanel_Round(30);

        lbImporte.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbImporte.setForeground(new java.awt.Color(255, 255, 255));
        lbImporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImporte.setText("S/. 000.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbImporte, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbImporte)
                .addGap(15, 15, 15))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 130, -1));

        jPanel3.setPanel_BackgroundGradientColor1(new java.awt.Color(102, 0, 255));
        jPanel3.setPanel_ShadowColor(new java.awt.Color(102, 102, 102));
        jPanel3.setPanel_ShadowOpacity(0.3F);
        jPanel3.setPanel_ShadowSize(3);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCodigo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(51, 51, 51));
        lbCodigo.setText("EB-0001");
        jPanel3.add(lbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 188, -1));

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 160, 100));

        lbFecha.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(153, 153, 153));
        lbFecha.setText("01/12/2024 hh:mm:ss");
        jPanel3.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 140, 40));

        lbNombre.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(51, 51, 51));
        lbNombre.setText("74377525");
        jPanel3.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 100, -1));

        lbNombre1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbNombre1.setForeground(new java.awt.Color(51, 51, 51));
        lbNombre1.setText("DNI: ");
        jPanel3.add(lbNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 40, 20));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 120));
    }// </editor-fold>//GEN-END:initComponents

   

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.Panel.JPanel jPanel1;
    private Swing.Panel.JPanel jPanel2;
    private Swing.Panel.JPanel jPanel3;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbImporte;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombre1;
    // End of variables declaration//GEN-END:variables
}
