package Swing.JtextField;

import Util.Shadow.ShadowRenderer;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/*

myTextField1.setDocument(new Txt_Decimal(3) {});

*/
public class JTextField extends javax.swing.JTextField {

    public String getTxt_Hint() {
        return Txt_Hint;
    }

    public void setTxt_Hint(String Txt_Hint) {
        this.Txt_Hint = Txt_Hint;
    }

    public Icon getIcon() {
        return Icon;
    }

    public void setIcon(FlatSVGIcon Icon) {
        this.Icon = Icon;

        if (IconColorFilterActived) {
            this.Icon.setColorFilter(this.colorFilter);
        }
        initBorder();
    }

    private FlatSVGIcon Icon;
    private boolean IconColorFilterActived = false;
    Color IconColorFilter = new Color(140, 140, 140);
    FlatSVGIcon.ColorFilter colorFilter = new FlatSVGIcon.ColorFilter(color -> IconColorFilter);

    public Color getIconColorFilter() {
        return IconColorFilter;
    }

    public void setIconColorFilter(Color IconColorFilter) {

        this.IconColorFilter = IconColorFilter;
    }

    public boolean isIconColorFilterActived() {
        return IconColorFilterActived;
    }

    public void setIconColorFilterActived(boolean IconColorFilterActived) {
        this.IconColorFilterActived = IconColorFilterActived;
    }

    private String Txt_Hint = "";

    private float Panel_ShadowOpacity = 0.15f;

    int Panel_Round = 15;
    boolean Panel_BorderActived = false;
    Color Panel_BorderColor = new Color(240, 240, 240);
    private Color Panel_ShadowColor = new Color(110, 110, 110);

    private Color Panel_BackgroundColor = new Color(250, 250, 255);

    public Color getPanel_BackgroundColor() {
        return Panel_BackgroundColor;
    }

    public void setPanel_BackgroundColor(Color Panel_BackgroundColor) {
        this.Panel_BackgroundColor = Panel_BackgroundColor;
    }
    
    

    boolean Panel_BackgroundGradientActived = false;
    Color Panel_BackgroundGradientColor1 = new Color(255, 255, 255);
    Color Panel_BackgroundGradientColor2 = new Color(210, 210, 210);

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

    public int getPanel_Round() {
        return Panel_Round;
    }

    public void setPanel_Round(int Panel_Round) {
        this.Panel_Round = Panel_Round;
    }

    public boolean isPanel_BorderActived() {
        return Panel_BorderActived;
    }

    public void setPanel_BorderActived(boolean Panel_BorderActived) {
        this.Panel_BorderActived = Panel_BorderActived;
    }

    public Color getPanel_BorderColor() {
        return Panel_BorderColor;
    }

    public void setPanel_BorderColor(Color Panel_BorderColor) {
        this.Panel_BorderColor = Panel_BorderColor;
    }

    public Color getPanel_ShadowColor() {
        return Panel_ShadowColor;
    }

    public void setPanel_ShadowColor(Color Panel_ShadowColor) {
        this.Panel_ShadowColor = Panel_ShadowColor;
    }

    public float getPanel_ShadowOpacity() {
        return Panel_ShadowOpacity;
    }

    public void setPanel_ShadowOpacity(float Panel_ShadowOpacity) {
        this.Panel_ShadowOpacity = Panel_ShadowOpacity;
    }

    public JTextField() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 14, 10, 14));

        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        setForeground(new Color(38, 38, 38));
        setFont(new java.awt.Font("sansserif", 0, 16));
        setSelectionColor(new Color(4, 56, 162));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = 3 * 2;
        int X = 0;
        int Y = 0;
        int Width = getWidth() - size;
        int Height = getHeight() - size;

        //  Center
        X = 3;
        Y = 3;

        BufferedImage img = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g_s = img.createGraphics();
        g_s.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (Panel_BackgroundGradientActived) {
            GradientPaint ColorGradientPaint = new GradientPaint(0, 0, Panel_BackgroundGradientColor1, Width, Height, Panel_BackgroundGradientColor2);
            g_s.setPaint(ColorGradientPaint);
        } else {
            g_s.setColor(Panel_BackgroundColor);
        }

        g_s.fillRoundRect(0, 0, Width, Height, Panel_Round, Panel_Round);

        if (Panel_BorderActived) {
            g_s.setColor(Panel_BorderColor);
            g_s.drawRoundRect(0, 0, Width - 1, Height - 1, Panel_Round, Panel_Round);
        }

        //  Create Shadow
        ShadowRenderer render = new ShadowRenderer(3, Panel_ShadowOpacity, Panel_ShadowColor);
        g2.drawImage(render.createShadow(img), 0, 0, null);
        g2.drawImage(img, X, Y, null);

        paintIcon(g);

        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(200, 200, 200));

            int EspaceIcon = 0;
            if (Icon != null) {
                EspaceIcon = ((int) ins.left / 2) - 12;
            }

            //Right
            if (getHorizontalAlignment() == CENTER) {
                g.drawString(Txt_Hint, ((getWidth() - fm.stringWidth(Txt_Hint)) / 2) + EspaceIcon, h / 2 + fm.getAscent() / 2 - 2);

            } else {
                g.drawString(Txt_Hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
            }

        }
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (Icon != null) {
            Image prefix = ((ImageIcon) Icon).getImage();
            int y = (getHeight() - Icon.getIconHeight()) / 2;
            g2.drawImage(prefix, 13, y, this);
        }

    }

    private void initBorder() {
        int IconLeft_Margin = 24;
        //  5 is default
        if (Icon != null) {
            //  prefix is left
            IconLeft_Margin = Icon.getIconWidth() + 24;
        }

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, IconLeft_Margin, 10, 24));
    }
    

}
