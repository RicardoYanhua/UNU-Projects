package Swing;

import Util.Shadow.ShadowIn;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;

public class JPanelShadowIn extends javax.swing.JPanel {

    public ShadowIn.ShadowType getShadowType() {
        return shadowType;
    }

    public void setShadowType(ShadowIn.ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        setBorder(new EmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
    }

    private ShadowIn.ShadowType shadowType = ShadowIn.ShadowType.IN_SHADOW;
    private int radius = 20;
    private int shadowSize = 8;
    private BufferedImage imageShadow;

    public JPanelShadowIn() {
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(16, 16, 16, 16));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        if (imageShadow != null) {
            grphcs.drawImage(imageShadow, 0, 0, null);
        }
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createShadowImage();
    }

    private void createShadowImage() {
            imageShadow = ShadowIn.getInstance().createShadowIn(this, shadowSize, radius);
    }
}
