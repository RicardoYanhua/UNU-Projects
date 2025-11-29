package Swing.Background;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background_Img extends JPanel {

    public Icon getBackground_Image() {
        return Background_Image;
    }

    public void setBackground_Image(Icon Background_Image) {
        this.Background_Image = Background_Image;
        createImage();
        repaint();
    }

    public int getBackground_Round() {
        return Background_Round;
    }

    public void setBackground_Round(int Background_Round) {
        this.Background_Round = Background_Round;
        repaint();
    }

    public boolean isBackground_BorderActived() {
        return Background_BorderActived;
    }

    public void setBackground_BorderActived(boolean Background_BorderActived) {
        this.Background_BorderActived = Background_BorderActived;
    }

    public Color getBackground_BorderColor() {
        return Background_BorderColor;
    }

    public void setBackground_BorderColor(Color Background_BorderColor) {
        this.Background_BorderColor = Background_BorderColor;
    }

    public float getBackground_ImageOpacity() {
        return Background_ImageOpacity;
    }

    public void setBackground_ImageOpacity(float Background_ImageOpacity) {
        this.Background_ImageOpacity = Background_ImageOpacity;
    }

    public boolean isBackground_GradientActived() {
        return Background_GradientActived;
    }

    public void setBackground_GradientActived(boolean Background_GradientActived) {
        this.Background_GradientActived = Background_GradientActived;
    }

    public Color getBackground_GradientColor1() {
        return Background_GradientColor1;
    }

    public void setBackground_GradientColor1(Color Background_GradientColor1) {
        this.Background_GradientColor1 = Background_GradientColor1;
    }

    public Color getBackground_GradientColor2() {
        return Background_GradientColor2;
    }

    public void setBackground_GradientColor2(Color Background_GradientColor2) {
        this.Background_GradientColor2 = Background_GradientColor2;
    }

    public Background_Img() {
        setOpaque(false);
        super.setBackground(Color.WHITE);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        createImage();
    }

    private int Background_Round = 15;
    private Icon Background_Image = null;
    private float Background_ImageOpacity = 0.5f;
    private BufferedImage bffImage;
    boolean Background_BorderActived = false;
    Color Background_BorderColor = new Color(210, 210, 210);

    boolean Background_GradientActived = false;
    Color Background_GradientColor1 = new Color(255, 255, 255);
    Color Background_GradientColor2 = new Color(255, 255, 255);

    @Override
    public void paint(Graphics grphcs) {

        Graphics2D g2 = (Graphics2D) grphcs.create();

        if (bffImage != null) {
            g2.drawImage(bffImage, 0, 0, null);
        } else {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (Background_GradientActived) {
                GradientPaint ColorGradientPaint = new GradientPaint(0, 0, Background_GradientColor1, getWidth(), getHeight(), Background_GradientColor2);
                g2.setPaint(ColorGradientPaint);
            } else {
                g2.setColor(getBackground());
            }

            g2.fillRoundRect(0, 0, getWidth(), getHeight(), Background_Round, Background_Round);
        }

        if (Background_BorderActived) {
            g2.setColor(Background_BorderColor);
            g2.setStroke(new BasicStroke(3.0f));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, Background_Round, Background_Round);
        }

        //g2.dispose();
        super.paint(grphcs);
    }

    public void createImage() {

        if (Background_Image != null) {
            System.out.println("PASSSSSSSS");
            System.out.println(getWidth());
            System.out.println(getHeight());

            int width =300;
            int height =300;
            Rectangle size = getAutoSize(Background_Image);
            bffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2_img = bffImage.createGraphics();
            g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2_img.fillRoundRect(0, 0, width, height, Background_Round, Background_Round);

            //g2_img.setComposite(AlphaComposite.SrcIn);
            g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2_img.drawImage(toImage(getBackground_Image()), size.x, size.y, size.width, size.height, null);
            g2_img.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, Background_ImageOpacity));
            g2_img.setColor(getBackground());
            g2_img.fillRect(0, 0, getWidth(), getHeight());
            g2_img.dispose();
        } else {
            bffImage = null;
        }
    }

    private Rectangle getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        if (w > image.getIconWidth()) {
            w = image.getIconWidth();
        }
        if (h > image.getIconHeight()) {
            h = image.getIconHeight();
        }
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.min(xScale, yScale); //Estilo de la imagen max = rellenado min = ajustado

        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        int x = getWidth() / 2 - (width / 2);
        int y = getHeight() / 2 - (height / 2);
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createImage();
    }
}
