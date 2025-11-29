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

public class JPanelCustom extends javax.swing.JPanel {

    public JPanelCustom() {
        setOpaque(false);
        setBackground(Color.WHITE);
    }

    int RoundPanel = 15;

    boolean BorderActived = false;
    Color ColorBorder = new Color(210, 210, 210);

    boolean BackgroundGradientActived = false;
    Color BackgroundColorGradient1 = new Color(255, 255, 255);
    Color BackgroundColorGradient2 = new Color(210, 210, 210);

    private boolean ShadowActived = true;
    private Color shadowColor = new Color(110, 110, 110);
    private BufferedImage imageShadow;
    private final Insets shadowSize = new Insets(2, 5, 8, 5);
    
    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        createImageShadow();
        repaint();
    }
    
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

    public Color getBackgroundColorGradient1() {
        return BackgroundColorGradient1;
    }

    public void setBackgroundColorGradient1(Color BackgroundColorGradient1) {
        this.BackgroundColorGradient1 = BackgroundColorGradient1;
    }

    public Color getBackgroundColorGradient2() {
        return BackgroundColorGradient2;
    }

    public void setBackgroundColorGradient2(Color BackgroundColorGradient2) {
        this.BackgroundColorGradient2 = BackgroundColorGradient2;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double Width = getWidth() - (shadowSize.left + shadowSize.right);
        double Height = getHeight() - (shadowSize.top + shadowSize.bottom);
        double X = shadowSize.left;
        double Y = shadowSize.top;
        
        g2.drawImage(imageShadow, 0, 0, null);
        
        if (BackgroundGradientActived) {
            GradientPaint ColorGradientPaint = new GradientPaint(0, 0, BackgroundColorGradient1, getWidth(), getHeight(), BackgroundColorGradient2);
            g2.setPaint(ColorGradientPaint);
        } else {
            g2.setColor(getBackground());
        }

        g2.fillRoundRect((int)X, (int)Y, (int)Width, (int)Height, RoundPanel, RoundPanel);

        if (BorderActived) {
            g2.setColor(ColorBorder);
            g2.drawRoundRect((int)X, (int)Y, (int)Width - 1,(int)Height - 1, RoundPanel, RoundPanel);
        }

        super.paintComponent(grphcs);
    }
    
     @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        createImageShadow();
    }

    private void createImageShadow() {
        int height = getHeight();
        int width = getWidth();
        if (width > 0 && height > 0) {
            imageShadow = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageShadow.createGraphics();
            BufferedImage img = createShadow();
            if (img != null) {
                g2.drawImage(createShadow(), 0, 0, null);
            }
            g2.dispose();
        }
    }

    private BufferedImage createShadow() {
        int width = getWidth() - (shadowSize.left + shadowSize.right);
        int height = getHeight() - (shadowSize.top + shadowSize.bottom);
        if (width > 0 && height > 0) {
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fill(new RoundRectangle2D.Double(0, 0, width, height, RoundPanel, RoundPanel));
            g2.dispose();
            return new ShadowRenderer(5, 0.3f, shadowColor).createShadow(img);
        } else {
            return null;
        }
    }

}

//Point2D start = new Point2D.Float(50, 50); // Comienza en la esquina superior izquierda
//Point2D end = new Point2D.Float(width - 50, height - 50); // Termina en la esquina inferior derecha
//Point2D start = new Point2D.Float(50, height / 2); // Comienza a la izquierda
//Point2D end = new Point2D.Float(width - 50, height / 2); // Termina a la derecha
//Point2D start = new Point2D.Float(width / 2, 50); // Comienza en la parte superior
//Point2D end = new Point2D.Float(width / 2, height - 50); // Termina en la parte inferior
