package com.mycompany.Swing.Button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mycompany.Util.Ripple.RippleEffect;
import com.mycompany.Util.Shadow.ShadowRenderer;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends javax.swing.JButton {

    private int Button_Round = 0;
    private Color Button_ShadowColor = new Color(0, 0, 0);
    private final RippleEffect Button_ClickedEffect = new RippleEffect(this);
    private boolean Button_ActivedIconColorFilter = false;
    private FlatSVGIcon Icon;
    private Color Button_IconColorFilter = new Color(0, 0, 0);
    private FlatSVGIcon.ColorFilter Filter = new FlatSVGIcon.ColorFilter(color -> Button_IconColorFilter);
    private int Button_ShadowSize = 6;
    private float Button_ShawdowOpacity = 0.5f;
    private boolean MouseEnteredButton = false;
    private Color Button_BackgroundColorEntered = new Color(250, 250, 250);
    private boolean Button_ActivedClickedEffect = false;
    private boolean Button_ActivedBackgroundColorEntered = true;
    private Color Button_BackgroundColorDisabled = new Color(220, 220, 220);
    private boolean Button_ActivedBackground = true;

    public Button() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentAreaFilled(false);
        //setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(80, 80, 80));
        Button_ClickedEffect.setRippleColor(new Color(220, 220, 220));
        setFont(new java.awt.Font("sansserif", Font.PLAIN, 14));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                MouseEnteredButton = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MouseEnteredButton = false;
                repaint();
            }
        }
        );

    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Button_ShadowSize * 2;
        int X = Button_ShadowSize;
        int Y = Button_ShadowSize;
        int Width = getWidth() - size;
        int Height = getHeight() - size;

        BufferedImage img = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (!Button_ActivedBackground) {
            g.setColor(new Color(0, 0, 0, 0));
            g.fillRoundRect(0, 0, Width, Height, Button_Round, Button_Round);
        } else {
            if (isEnabled()) {
                
                if (MouseEnteredButton && Button_ActivedBackgroundColorEntered) {
                    g.setColor(Button_BackgroundColorEntered);
                } else {
                    g.setColor(getBackground());
                }
                g.fillRoundRect(0, 0, Width, Height, Button_Round, Button_Round);

            } else if (!isEnabled()) {
                g.setColor(Button_BackgroundColorDisabled);
                g.fillRoundRect(0, 0, Width, Height, Button_Round, Button_Round);

            }
        }

        //  Create Shadow
        ShadowRenderer render = new ShadowRenderer(Button_ShadowSize, Button_ShawdowOpacity, Button_ShadowColor);
        g2.drawImage(render.createShadow(img), 0, 0, null);
        g2.drawImage(img, X, Y, null);

        if (Button_ActivedClickedEffect && isEnabled()) {
            Area area = new Area(new RoundRectangle2D.Double(X, Y, Width, Height, Button_Round, Button_Round));
            Button_ClickedEffect.reder(grphcs, area);
        }

        g2.dispose();

        super.paintComponent(grphcs);
    }


    public Color getButton_ShadowColor() {
        return Button_ShadowColor;
    }

    public void setButton_ShadowColor(Color Button_ShadowColor) {
        this.Button_ShadowColor = Button_ShadowColor;
        repaint();
    }

    public FlatSVGIcon getIcon() {
        return Icon;
    }

    public void setIcon(FlatSVGIcon Icon) {
        this.Icon = Icon;
        if (Button_ActivedIconColorFilter) {
            this.Icon.setColorFilter(this.Filter);
        }
    }

    public int getButton_Round() {
        return Button_Round;
    }

    public void setButton_Round(int Button_Round) {
        this.Button_Round = Button_Round;
    }

    public boolean isButton_ActivedIconColorFilter() {
        return Button_ActivedIconColorFilter;
    }

    public void setButton_ActivedIconColorFilter(boolean Button_ActivedIconColorFilter) {
        this.Button_ActivedIconColorFilter = Button_ActivedIconColorFilter;
    }

    public Color getButton_IconColorFilter() {
        return Button_IconColorFilter;
    }

    public void setButton_IconColorFilter(Color Button_IconColorFilter) {
        this.Button_IconColorFilter = Button_IconColorFilter;
    }

    public int getButton_ShadowSize() {
        return Button_ShadowSize;
    }

    public void setButton_ShadowSize(int Button_ShadowSize) {
        this.Button_ShadowSize = Button_ShadowSize;
    }

    public float getButton_ShawdowOpacity() {
        return Button_ShawdowOpacity;
    }

    public void setButton_ShawdowOpacity(float Button_ShawdowOpacity) {
        this.Button_ShawdowOpacity = Button_ShawdowOpacity;
    }

    public Color getButton_BackgroundColorEntered() {
        return Button_BackgroundColorEntered;
    }

    public void setButton_BackgroundColorEntered(Color Button_BackgroundColorEntered) {
        this.Button_BackgroundColorEntered = Button_BackgroundColorEntered;
    }

    public boolean isButton_ActivedClickedEffect() {
        return Button_ActivedClickedEffect;
    }

    public void setButton_ActivedClickedEffect(boolean Button_ActivedClickedEffect) {
        this.Button_ActivedClickedEffect = Button_ActivedClickedEffect;
    }

    public boolean isButton_ActivedBackgroundColorEntered() {
        return Button_ActivedBackgroundColorEntered;
    }

    public void setButton_ActivedBackgroundColorEntered(boolean Button_ActivedBackgroundColorEntered) {
        this.Button_ActivedBackgroundColorEntered = Button_ActivedBackgroundColorEntered;
    }

    public Color getButton_BackgroundColorDisabled() {
        return Button_BackgroundColorDisabled;
    }

    public void setButton_BackgroundColorDisabled(Color Button_BackgroundColorDisabled) {
        this.Button_BackgroundColorDisabled = Button_BackgroundColorDisabled;
    }

    public boolean isButton_ActivedBackground() {
        return Button_ActivedBackground;
    }

    public void setButton_ActivedBackground(boolean Button_ActivedBackground) {
        this.Button_ActivedBackground = Button_ActivedBackground;
    }
    
    


}
