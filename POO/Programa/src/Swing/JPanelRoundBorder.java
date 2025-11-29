package Swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import Util.Shadow.ShadowRenderer;
import System.SystemColor;

public class JPanelRoundBorder extends javax.swing.JPanel {

    public JPanelRoundBorder() {
        setOpaque(false);
        setBackground(new Color(255,255,255));
    }

    int RoundPanel = 0;

    boolean BorderActived = false;
    Color ColorBorder = new Color(210, 210, 210);

    boolean BackgroundGradientActived = false;

    public int getRoundPanel() {
        return RoundPanel;
    }

    public void setRoundPanel(int RoundPanel) {
        this.RoundPanel = RoundPanel;
    }

    public Color getColorBorder() {
        return ColorBorder;
    }

    public void setColorBorder(Color ColorBorder) {
        this.ColorBorder = ColorBorder;
    }

    public boolean isBorderActived() {
        return BorderActived;
    }

    public void setBorderActived(boolean BorderActived) {
        this.BorderActived = BorderActived;
    }

    public boolean isBackgroundGradientActived() {
        return BackgroundGradientActived;
    }

    public void setBackgroundGradientActived(boolean BackgroundGradientActived) {
        this.BackgroundGradientActived = BackgroundGradientActived;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), RoundPanel, RoundPanel);

        if (BorderActived) {
            g2.setColor(ColorBorder);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, RoundPanel, RoundPanel);
        }

        super.paintComponent(grphcs);
    }

    


}

//Point2D start = new Point2D.Float(50, 50); // Comienza en la esquina superior izquierda
//Point2D end = new Point2D.Float(width - 50, height - 50); // Termina en la esquina inferior derecha
//Point2D start = new Point2D.Float(50, height / 2); // Comienza a la izquierda
//Point2D end = new Point2D.Float(width - 50, height / 2); // Termina a la derecha
//Point2D start = new Point2D.Float(width / 2, 50); // Comienza en la parte superior
//Point2D end = new Point2D.Float(width / 2, height - 50); // Termina en la parte inferior
