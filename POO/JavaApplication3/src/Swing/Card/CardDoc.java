package Swing.Card;

import ScrollWidget.Objeto.Document;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import javax.swing.JEditorPane;
import javax.swing.text.StyledEditorKit;

import javax.swing.text.html.HTMLEditorKit;

public class CardDoc extends javax.swing.JPanel {

    private Document data;

    public Document getData() {
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

    public CardDoc() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbIcon.setIcon(new FlatSVGIcon("svg/svg.svg", 64, 64));
    }

    Color Panel_BackgroundGradientColor1 = new Color(120, 120, 120);
    Color Panel_BackgroundGradientColor2 = new Color(240, 240, 240);

    Color TxtTitleForeground = new Color(255, 255, 255);
    Color TxtDescripcionForeground = new Color(230, 230, 230);

    public Color getTxtTitleForeground() {
        return TxtTitleForeground;
    }

    public void setTxtTitleForeground(Color TxtTitleForeground) {
        this.TxtTitleForeground = TxtTitleForeground;
    }

    public Color getTxtDescripcionForeground() {
        return TxtDescripcionForeground;
    }

    public void setTxtDescripcionForeground(Color TxtDescripcionForeground) {
        this.TxtDescripcionForeground = TxtDescripcionForeground;
    }

    boolean IconFilterColor_Actived = false;
    int Card_Round = 30;

    public boolean isIconFilterColor_Actived() {
        return IconFilterColor_Actived;
    }

    public void setIconFilterColor_Actived(boolean IconFilterColor_Actived) {
        this.IconFilterColor_Actived = IconFilterColor_Actived;
    }

    public Color getPanel_BackgroundGradientColor1() {
        return Panel_BackgroundGradientColor1;
    }

    public void setPanel_BackgroundGradientColor1(Color Panel_BackgroundGradientColor1) {
        this.Panel_BackgroundGradientColor1 = Panel_BackgroundGradientColor1;
    }

    public Color getPanel_BackgroundGradientColor2() {
        return Panel_BackgroundGradientColor2;
    }

    public void setPanel_BackgroundGradientColor2(Color Panel_BackgroundGradientColor2) {
        this.Panel_BackgroundGradientColor2 = Panel_BackgroundGradientColor2;
    }

    public int getCard_Round() {
        return Card_Round;
    }

    public void setCard_Round(int Card_Round) {
        this.Card_Round = Card_Round;
    }

    String txt_title;
    String txt_descr;

    public String getTxt_descr() {
        return txt_descr;
    }

    public void setTxt_descr(String txt_descr) {
        this.txt_descr = txt_descr;
        lbDescripcion.setText(txt_descr);
    }

    public String getTxt_title() {
        return txt_title;
    }

    public void setTxt_title(String txt_title) {
        this.txt_title = txt_title;
        lbCodigo.setText(txt_title);
    }

    public void setData(Document data) {
        this.data = data;
        lbCodigo.setText(data.getCodigo());
        lbImporte.setText(data.getImporte());

    }

    public void setDescripForegroundColor(Color color) {
        lbCodigo.setForeground(color);
    }

    public void setTitleForegroundColor(Color color) {
        lbCodigo.setForeground(color);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCodigo = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JTextPane();
        lbImporte = new javax.swing.JLabel();

        lbCodigo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo.setText("EB-0001");

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbDescripcion.setEditable(false);
        lbDescripcion.setBackground(new Color(0,0,0,0));
        lbDescripcion.setBorder(null);
        lbDescripcion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lbDescripcion.setText("Descripcion");
        lbDescripcion.setAutoscrolls(false);
        lbDescripcion.setFocusCycleRoot(false);
        lbDescripcion.setFocusable(false);
        lbDescripcion.setRequestFocusEnabled(false);
        lbDescripcion.setVerifyInputWhenFocusTarget(false);

        lbImporte.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbImporte.setForeground(new java.awt.Color(255, 255, 255));
        lbImporte.setText("S/. 0000.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbImporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lbDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbImporte)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint ColorGradientPaint = new GradientPaint(0, 0, Panel_BackgroundGradientColor1, getWidth(), getHeight(), Panel_BackgroundGradientColor2);
        g2.setPaint(ColorGradientPaint);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), Card_Round, Card_Round);

        super.paintComponent(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JTextPane lbDescripcion;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbImporte;
    // End of variables declaration//GEN-END:variables
}
