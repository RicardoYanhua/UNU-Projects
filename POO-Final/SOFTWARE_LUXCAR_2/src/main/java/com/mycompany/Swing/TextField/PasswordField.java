package com.mycompany.Swing.TextField;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.Util.Shadow.ShadowRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class PasswordField extends JPasswordField {

    private String TextField_Txthint = "";
    private Color TextField_TxthintColor = new Color(220, 220, 220);
    private float TextField_ShadowOpacity = 0.5f; //<0-1.0>
    private int TextField_ShadowSize = 6;
    private Color TextField_ShadowColor = new Color(0, 0, 0);
    private boolean TextField_BorderActived = false;
    private Color TextField_BorderColor = new Color(220, 220, 220);
    private Color TextField_BackgroundColor = new Color(255, 255, 255);
    private int TextField_IconTextSpace = 10;

    private int TextField_Round = 15;
    private boolean TextField_ActivedIconColorFilter = false;
    private FlatSVGIcon Icon;
    private Color TextField_IconColorFilter = new Color(255, 255, 255);
    private FlatSVGIcon.ColorFilter Filter = new FlatSVGIcon.ColorFilter(color -> TextField_IconColorFilter);

    public PasswordField() {
        //TOP-LEFT-BOTTOM-RIGHT
        setBorder(new EmptyBorder(10, 24, 10, 24));
        setOpaque(false);
        setBackground(new Color(255, 255, 255, 0));
        setForeground(new Color(38, 38, 38));
        setFont(new java.awt.Font("sansserif", Font.PLAIN, 14));
        setSelectionColor(new Color(4, 56, 162));
        setEchoChar('•');
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Inicializa el renderizado
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int Size = TextField_ShadowSize * 2;
        int X = TextField_ShadowSize;
        int Y = TextField_ShadowSize;
        int Width = getWidth() - Size;
        int Height = getHeight() - Size;

        BufferedImage img = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g_s = img.createGraphics();
        //Inicializa el renderizado
        g_s.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Background
        g_s.setColor(TextField_BackgroundColor);
        g_s.fillRoundRect(0, 0, Width, Height, TextField_Round, TextField_Round);
        //Boder
        if (TextField_BorderActived) {
            g_s.setColor(TextField_BorderColor);
            g_s.drawRoundRect(0, 0, Width - 1, Height - 1, TextField_Round, TextField_Round);
        }
        //Shadow
        ShadowRenderer render = new ShadowRenderer(TextField_ShadowSize, TextField_ShadowOpacity, TextField_ShadowColor);
        g2.drawImage(render.createShadow(img), 0, 0, null);
        g2.drawImage(img, X, Y, null);
        paintIcon(g);
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Si el tamaño texto del compoentes es "0" o esta vacio
        if (getText().length() == 0) {
            //Inicializa el renderizado
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            //Obtener el tamaño de los bordes
            Insets ins = getInsets();
            //Calcula el tamaño del texto
            FontMetrics fm = g.getFontMetrics();
            //Color hint
            g.setColor(TextField_TxthintColor);
            //Escribe el texto hint desde la izquierda - TextRight
            g.drawString(TextField_Txthint, ins.left, (getHeight() / 2) + (fm.getAscent() / 2) - 1);

        }
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (Icon != null) {
            Image img = ((ImageIcon) Icon).getImage();
            int y = (getHeight() - Icon.getIconHeight()) / 2;
            g2.drawImage(img, getInsets().left - Icon.getIconWidth() - TextField_IconTextSpace, y, this);
        }

    }

    private void UpdateBorder() {
        int LeftMargin = getInsets().left;
        if (Icon != null) {
            LeftMargin = Icon.getIconWidth() + getInsets().left;
        }
        setBorder(new EmptyBorder(10, LeftMargin, 10, 24));

    }

    public Icon getIcon() {
        return Icon;
    }

    public void setIcon(FlatSVGIcon Icon) {
        this.Icon = Icon;
        if (TextField_ActivedIconColorFilter) {
            this.Icon.setColorFilter(this.Filter);
        }
        UpdateBorder();
    }

    public Color getTextField_TxthintColor() {
        return TextField_TxthintColor;
    }

    public void setTextField_TxthintColor(Color TextField_TxthintColor) {
        this.TextField_TxthintColor = TextField_TxthintColor;
    }

    public boolean isTextField_ActivedIconColorFilter() {
        return TextField_ActivedIconColorFilter;
    }

    public void setTextField_ActivedIconColorFilter(boolean TextField_ActivedIconColorFilter) {
        this.TextField_ActivedIconColorFilter = TextField_ActivedIconColorFilter;
    }

    public Color getTextField_IconColorFilter() {
        return TextField_IconColorFilter;
    }

    public void setTextField_IconColorFilter(Color TextField_IconColorFilter) {
        this.TextField_IconColorFilter = TextField_IconColorFilter;
    }

    public String getTextField_Txthint() {
        return TextField_Txthint;
    }

    public void setTextField_Txthint(String TextField_Txthint) {
        this.TextField_Txthint = TextField_Txthint;
    }

    public float getTextField_ShadowOpacity() {
        return TextField_ShadowOpacity;
    }

    public void setTextField_ShadowOpacity(float TextField_ShadowOpacity) {
        this.TextField_ShadowOpacity = TextField_ShadowOpacity;
    }

    public int getTextField_ShadowSize() {
        return TextField_ShadowSize;
    }

    public void setTextField_ShadowSize(int TextField_ShadowSize) {
        this.TextField_ShadowSize = TextField_ShadowSize;
    }

    public Color getTextField_ShadowColor() {
        return TextField_ShadowColor;
    }

    public void setTextField_ShadowColor(Color TextField_ShadowColor) {
        this.TextField_ShadowColor = TextField_ShadowColor;
    }

    public boolean isTextField_BorderActived() {
        return TextField_BorderActived;
    }

    public void setTextField_BorderActived(boolean TextField_BorderActived) {
        this.TextField_BorderActived = TextField_BorderActived;
    }

    public Color getTextField_BorderColor() {
        return TextField_BorderColor;
    }

    public void setTextField_BorderColor(Color TextField_BorderColor) {
        this.TextField_BorderColor = TextField_BorderColor;
    }

    public int getTextField_Round() {
        return TextField_Round;
    }

    public void setTextField_Round(int TextField_Round) {
        this.TextField_Round = TextField_Round;
    }

    public Color getTextField_BackgroundColor() {
        return TextField_BackgroundColor;
    }

    public void setTextField_BackgroundColor(Color TextField_BackgroundColor) {
        this.TextField_BackgroundColor = TextField_BackgroundColor;
    }

    public int getTextField_IconTextSpace() {
        return TextField_IconTextSpace;
    }

    public void setTextField_IconTextSpace(int TextField_IconTextSpace) {
        this.TextField_IconTextSpace = TextField_IconTextSpace;
    }

}
