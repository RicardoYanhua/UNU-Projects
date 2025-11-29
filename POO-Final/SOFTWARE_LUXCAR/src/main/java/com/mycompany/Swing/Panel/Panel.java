package com.mycompany.Swing.Panel;

import com.mycompany.Util.Shadow.ShadowRenderer;
import com.mycompany.Util.Type.PanelType;
import com.mycompany.Util.Type.ShadowType;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Panel extends javax.swing.JPanel {

    public Panel() {
        setOpaque(false);
        setBackground(Color.WHITE);
    }

    int Panel_Round = 15;
    boolean Panel_BorderActived = false;
    Color Panel_BorderColor = new Color(210, 210, 210);
    boolean Panel_BackgroundGradientActived = false;
    Color Panel_BackgroundGradientColor1 = new Color(255, 255, 255);
    Color Panel_BackgroundGradientColor2 = new Color(210, 210, 210);
    private Color Panel_ShadowColor = new Color(110, 110, 110);
    private ShadowType Panel_ShadowType = ShadowType.CENTER;
    private PanelType Panel_Type = PanelType.SQUARE_TYPE;
    private int Panel_ShadowSize = 6;
    private float Panel_ShadowOpacity = 0.5f;

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Panel_ShadowSize * 2;
        int X = 0;
        int Y = 0;
        int Width = getWidth() - size;
        int Height = getHeight() - size;

        if (Panel_ShadowType == ShadowType.TOP) {
            X = Panel_ShadowSize;
            Y = size;
        } else if (Panel_ShadowType == ShadowType.BOT) {
            X = Panel_ShadowSize;
            Y = 0;
        } else if (Panel_ShadowType == ShadowType.TOP_LEFT) {
            X = size;
            Y = size;
        } else if (Panel_ShadowType == ShadowType.TOP_RIGHT) {
            X = 0;
            Y = size;
        } else if (Panel_ShadowType == ShadowType.BOT_LEFT) {
            X = size;
            Y = 0;
        } else if (Panel_ShadowType == ShadowType.BOT_RIGHT) {
            X = 0;
            Y = 0;
        } else {
            //  Center

            X = Panel_ShadowSize;
            Y = Panel_ShadowSize;
        }
        BufferedImage img = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (Panel_BackgroundGradientActived) {
            GradientPaint ColorGradientPaint = new GradientPaint(0, 0, Panel_BackgroundGradientColor1, Width, Height, Panel_BackgroundGradientColor2);
            g.setPaint(ColorGradientPaint);
        } else {
            g.setColor(getBackground());
        }

        if (Panel_Type == Panel_Type.SQUARE_TYPE) {
            g.fillRoundRect(0, 0, Width, Height, Panel_Round, Panel_Round);

            if (Panel_BorderActived) {
                g.setColor(Panel_BorderColor);
                g.drawRoundRect(0, 0, Width - 1, Height - 1, Panel_Round, Panel_Round);
            }
        } else {
            g.fillOval(0, 0, Width, Height);

            if (Panel_BorderActived) {
                g.setColor(Panel_BorderColor);
                g.drawOval(0, 0, Width - 1, Height - 1);

            }
        }

        //  Create Shadow
        if (Panel_ShadowSize >= 1) {
            ShadowRenderer render = new ShadowRenderer(Panel_ShadowSize, Panel_ShadowOpacity, Panel_ShadowColor);
            g2.drawImage(render.createShadow(img), 0, 0, null);
        }

        g2.drawImage(img, X, Y, null);

        super.paintComponent(grphcs);
    }

    public int getPanel_ShadowSize() {
        return Panel_ShadowSize;
    }

    public void setPanel_ShadowSize(int Panel_ShadowSize) {
        this.Panel_ShadowSize = Panel_ShadowSize;
    }

    public float getPanel_ShadowOpacity() {
        return Panel_ShadowOpacity;
    }

    public void setPanel_ShadowOpacity(float Panel_ShadowOpacity) {
        this.Panel_ShadowOpacity = Panel_ShadowOpacity;
    }

    public ShadowType getPanel_ShadowType() {
        return Panel_ShadowType;
    }

    public void setPanel_ShadowType(ShadowType Panel_ShadowType) {
        this.Panel_ShadowType = Panel_ShadowType;
    }

    public PanelType getPanel_Type() {
        return Panel_Type;
    }

    public void setPanel_Type(PanelType Panel_Type) {
        this.Panel_Type = Panel_Type;
    }

    public Color getPanel_ShadowColor() {
        return Panel_ShadowColor;
    }

    public void setPanel_ShadowColor(Color Panel_ShadowColor) {
        this.Panel_ShadowColor = Panel_ShadowColor;
        repaint();
    }

    public int getPanel_Round() {
        return Panel_Round;
    }

    public void setPanel_Round(int Panel_Round) {
        this.Panel_Round = Panel_Round;
    }

    public Color getPanel_BorderColor() {
        return Panel_BorderColor;
    }

    public void setPanel_BorderColor(Color Panel_BorderColor) {
        this.Panel_BorderColor = Panel_BorderColor;
    }

    public boolean isPanel_BorderActived() {
        return Panel_BorderActived;
    }

    public void setPanel_BorderActived(boolean Panel_BorderActived) {
        this.Panel_BorderActived = Panel_BorderActived;
    }

    public boolean isPanel_BackgroundGradientActived() {
        return Panel_BackgroundGradientActived;
    }

    public void setPanel_BackgroundGradientActived(boolean Panel_BackgroundGradientActived) {
        this.Panel_BackgroundGradientActived = Panel_BackgroundGradientActived;
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
}
